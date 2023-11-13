package com.alating.alo.leetcode.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintAbcLock {

    private int times;
    private int state;
    private Lock lock=new ReentrantLock();

    public PrintAbcLock(int times){
        this.times=times;
        this.state=0;
    }

    public void printAbc(String name,int serId){

        for(int i=0;i<times;){
            lock.lock();
            if(state%3==serId){
                System.out.println("I am "+ name );
                state++;
                i++;
            }
            lock.unlock();

        }

    }

    public static void main(String args[]){

        PrintAbcLock printAbcLock=new PrintAbcLock(10);

        new Thread(()->{
            printAbcLock.printAbc("a",0);
        }).start();

        new Thread(()->{
            printAbcLock.printAbc("b",1);
        }).start();

        new Thread(()->{
            printAbcLock.printAbc("c",2);
        }).start();

    }


}
