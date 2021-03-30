package com.lanjiu.im.netty.clean;

public class UpdateQuartz {
    public static void main(String[] args) throws Exception{
        //==========添加任务=========
        String expression = "0/2 * * * * ?";
        QuartzManager.addJob("demoJob","trigger001", expression,"007");
        System.out.println("***********已添加任务***********");
        Thread.sleep(10 * 1000);

//        //==========修改任务=========
        String expression2 = "0/3 * * * * ?";
        QuartzManager.modifyJobExpression("trigger001", expression2);
        System.out.println("***********已修改任务***********");
        Thread.sleep(10 * 1000);
//
//        //==========删除任务=========
        QuartzManager.removeJob("demoJob","trigger001");
        System.out.println("***********已删除任务***********");
        Thread.sleep(10 * 1000);
//
//        //==========添加任务=========
        String expression3 = "0/2 * * * * ?";
        QuartzManager.addJob("demoJob", "trigger001",expression3,"008");
        System.out.println("***********已添加任务***********");
        Thread.sleep(10 * 1000);
//
        QuartzManager.shutdownJobs();
    }
}
