package com.alating.alo.leetcode.thread;

public class NumAndLetterPrinter {

    private static char c='A';
    private static int i = 0;
    static final Object lock=new Object();

    private void print() {

        for (int i = 0; i < 26; i++) {
            synchronized (lock) {
                if (Thread.currentThread().getName().equals("numThread")) {
                    System.out.print(i + 1);
                    lock.notifyAll();  // 执行完nofity

                    // 立马中断当前线程
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (Thread.currentThread().getName().equals("letterThread")) {

                    System.out.print((char)(c + i));
                    lock.notifyAll();  // 执行完nofity

                    // 立马中断当前线程
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                lock.notifyAll();


            }
        }
    }




    public static void main(String args[]){

        NumAndLetterPrinter printer=new NumAndLetterPrinter();
        new Thread(()->{
            printer.print();
        },"numThread").start();

        new Thread(()->{
            printer.print();
        },"letterThread").start();
    }
}
