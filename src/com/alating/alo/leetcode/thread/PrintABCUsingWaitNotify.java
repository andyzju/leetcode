package com.alating.alo.leetcode.thread;

public class PrintABCUsingWaitNotify {

    private int state;
    private int times;
    private static final Object LOCK=new Object();

    public PrintABCUsingWaitNotify(int times){
        this.times=times;
    }


    private void printLetter(String name,int targetState){

        for(int i=0;i<times;i++){
            synchronized (LOCK){
                while(state%3!=targetState){  //  先获取锁，但是业务逻辑不符合，先让别线程执行
                    try{
                        LOCK.wait();  // 不符合顺序的情况下，先不执行，让其它线程先执行
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                state++;
                System.out.print(name);

                //  正常执行完之后，同志其它线程获取锁去执行
                LOCK.notifyAll();
            }
        }

    }

    public static void main(String args[]){

        PrintABCUsingWaitNotify printABCUsingWaitNotify=new PrintABCUsingWaitNotify(10);

        new Thread(()->{
            printABCUsingWaitNotify.printLetter("a",0);
        },"a").start();

        new Thread(()->{
            printABCUsingWaitNotify.printLetter("b",1);
        },"b").start();

        new Thread(()->{
            printABCUsingWaitNotify.printLetter("c",2);
        },"c").start();


    }
}
