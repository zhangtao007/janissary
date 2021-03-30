package com.lanjiu.im.grpc.client.pool_model;


import com.lanjiu.pro.file.FileTransmissionServiceGrpc;
import io.grpc.ManagedChannel;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Pool {
	//1指定两个队列， 一个busy表示忙碌队列,一个idel表示空闲队列
	private LinkedBlockingQueue idel;
	private LinkedBlockingQueue busy;

	//2指定最大连接数
	private final int MAXSIZE=20;
	//活跃的连接数
	private AtomicInteger activeSize = new AtomicInteger(10);

	//3初始化方法
	   public void init(){
	   	idel = new LinkedBlockingQueue();
	   	busy = new LinkedBlockingQueue();
	   	//初始化5个连接对象
           for (int i=0;i<10;i++){
               FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub ftsbs = PoolUtil.get();
               idel.offer(ftsbs);
           }
	   }

	//4销毁方法
	   public void destory(){
	   	idel=null;
	   	busy=null;
	   }

	//5返回一个连接对象
	   public FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub get(){
		   //5.1从idel中取出一个
           System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&连接数量 ："+activeSize.get());
           FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub conn =(FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub) idel.poll();
				if (conn!= null){
                    return conn;
                }

		   //5.2idel若没有，判断总连接是否够10个，不够就新建；
				if (activeSize.get() < MAXSIZE){
					if(activeSize.incrementAndGet() <= MAXSIZE){
						conn =PoolUtil.get();
						busy.offer(conn);
						activeSize.incrementAndGet();
						return conn;
					}
				}
		   //5.3已经够10个就阻塞，超时就抛异常
		   try {
			   conn = (FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub) idel.poll(10000, TimeUnit.MILLISECONDS);
			   if (conn == null)
			   	throw new RuntimeException("等待超时");
		   } catch (InterruptedException e) {
			   e.printStackTrace();
		   }
		   return conn;
	   }


	//6归还一个连接,从busy中取出，放入idel
	   public  void  release(FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub connection){
	   	  busy.remove(connection);
	   	  idel.offer(connection);
	   }

	//7定时器，定时检查空闲连接是否可用，不可用就换掉
       public  void timer(){
           Timer timer = new Timer();
           timer.schedule(new TimerTask() {
               @Override
               public void run() {
                   try {
                       check();
                       System.out.println("1分钟检测空闲连接是否可用...");
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               }
           },60000);
       }

	   public   void check() throws SQLException {
		   Iterator it = idel.iterator();
		   while (it.hasNext()){
               FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub conn = (FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub) it.next();
               ManagedChannel managedChannel =(ManagedChannel) conn.getChannel();
               if(managedChannel.isTerminated()){
			   	idel.remove(conn);
			   	idel.offer(PoolUtil.get());
			   }

		   }
	   }


}
