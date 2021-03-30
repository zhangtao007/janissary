package com.lanjiu.im.regist.server;

import com.lanjiu.im.regist.server.impl.RegisterUserStorageServiceGrpcImpl;
import com.lanjiu.im.storage.thread.FlushOverTimeGuestUserTask;
import com.lanjiu.im.storage.thread.GuestAutoNumTask;
import com.lanjiu.im.storage.thread.RegistAutoNumTask;
import com.lanjiu.im.storage.util.PropertyConf;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LoginRegistStorageServer {

    private  static  final Logger logger = LoggerFactory.getLogger(LoginRegistStorageServer.class);

    private Server server;

    private  void start(int port) throws IOException{

        this.server = ServerBuilder.forPort(port).addService(new RegisterUserStorageServiceGrpcImpl()).build().start();
        logger.info("Login__Storage started , on port :{} " ,port);
        System.out.println("Login__Storage started , on port"+port);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                LoginRegistStorageServer.this.stop();
            }

        });
    }

    private void stop(){
        if(null != this.server){
            this.server.shutdown();
        }
    }

    //启动后让该方法等待，
    private void awaitTermination() throws InterruptedException {
        if(null != this.server){
            this.server.awaitTermination();
        }
    }

    public static void runSErver(){
        PropertyConf propertyConf = new PropertyConf("/login_regist_storage.properties");
        int port = Integer.valueOf(propertyConf.getValue("login_regist_storage_port"));
        LoginRegistStorageServer loginRegistStorageServer = new LoginRegistStorageServer();
        try {
            loginRegistStorageServer.start(port);
            loginRegistStorageServer.awaitTermination();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        //自动补充号码库
        new RegistAutoNumTask().start();
//        Thread.sleep(3);
//        new GuestAutoNumTask().start();


        LoginRegistStorageServer.runSErver();

        //定时清除登录超时的游客，及相关信息资料；++》取消游客类别所有功能
//        new FlushOverTimeGuestUserTask().start();


    }
}
