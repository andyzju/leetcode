package com.alating.alo.leetcode.thread;


//class MyThread extends Thread{
//
//
//    public void run(){
//
//        for(int i=0;i<10;i++){
//            System.out.println("新开的线程"+ i);
//        }
//    }
//}

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyThread implements Runnable{

    @Override
    public void run() {

        for(int i=0;i<10;i++){
            System.out.println("新开的线程"+ i);
        }
    }
}

class MyThreadCall implements Callable<String>{

    public String call() throws Exception{
        System.out.println("子线程执行");
        return "true";
    }
}
public class ThreadTest {

    public static void main(String args[]){

        MyThread mthread= new MyThread();

        // mthread.run(); // 在原来的斩内直接执行，这种执行方式是串行的

        mthread.run(); // 异步的方式，开启新的zhanzhen，异步执行


        for(int i=0;i<10;i++){
            System.out.println("==主线程执行"+ i);
        }
    }


}
