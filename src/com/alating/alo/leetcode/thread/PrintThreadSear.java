package com.alating.alo.leetcode.thread;

import java.util.concurrent.CountDownLatch;

public class PrintThreadSear {

    private final static int N=4;
   private static int nextNum=1;

    public static void main(String args[]){

        Object o1=new Object();

        CountDownLatch downLatch=new CountDownLatch(N);

        new Thread(()->{

            // 这个循环的意义是什么
            for(int i=0;i<N;i++){

                synchronized (o1){
                    while (nextNum!=1){
                        try{
                            o1.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }

                    System.out.println("A");
                    nextNum=2;
                    o1.notifyAll();
                }
            }
            downLatch.countDown();
        }).start();


        new Thread(()->{

            for(int i=0;i<N;i++){
                synchronized (o1){
                    while(nextNum!=2){
                        try {
                            o1.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

                System.out.println("B");
                nextNum=3;
                o1.notifyAll();
            }
            downLatch.countDown();
        }).start();


        new Thread(()->{

            for(int i=0;i<N;i++){
                synchronized (o1){
                    while(nextNum!=3){
                        try {
                            o1.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

                System.out.println("C");
                nextNum=4;
                o1.notifyAll();
            }
            downLatch.countDown();
        }).start();


        new Thread(()->{

            for(int i=0;i<N;i++){
                synchronized (o1){
                    while(nextNum!=4){
                        try {
                            o1.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

                System.out.println("D");
                nextNum=1;
                o1.notifyAll();
            }
            downLatch.countDown();
        }).start();

    }
}
