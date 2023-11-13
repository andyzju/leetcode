package com.alating.alo.leetcode.thread;

public class OddEvenPrinter {

    private Object monitor=new Object();
    private  int limit;
    private volatile int count;

    OddEvenPrinter(int initCount, int times){

        this.count=initCount;
        this.limit=times;
    }

    private void print(){

        synchronized (monitor){

            while(count<limit){

                try{
                    System.out.println(
                            String.format("线程[%s]打印数字:%d", Thread.currentThread().getName(), ++count)
                    );
                    monitor.notifyAll();  // 交替使用
                    monitor.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            monitor.notifyAll();
        }

    }


    public static void main(String args[]){


        OddEvenPrinter printer=new OddEvenPrinter(0,10);

        new Thread(()->{
            printer.print();
        },"odd").start();

        new Thread(()->{
            printer.print();
        },"even").start();
    }

}
