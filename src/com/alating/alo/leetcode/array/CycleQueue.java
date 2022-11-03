package com.alating.alo.leetcode.array;


interface Queue{
    /**
     * 是否空
     * @return
     */
    public abstract boolean isEmpty();

    /**
     * 队列是否满
     * @return
     */
    public abstract boolean isFull();

    /**
     * 添加
     * @param num
     */
    public abstract void add(int num);

    /**
     * 获取队头
     */
    public abstract Integer poll();

    /**
     * 获取长度
     * @return
     */
    public abstract int length();
}
public class CycleQueue implements Queue{

    private Integer [] arr;

    /**
     * 队头
     */
    private int front;

    /**
     * 队尾
     */
    private int end;

    private int capacity;

    private final int min=3;

    public CycleQueue(int capacity){
        if(capacity<=min){
            capacity=min;
        }
        arr=new Integer[capacity+1];
        this.capacity=capacity;
        front=0;
        end=0;
    }

    /**
     * 是否空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front==end;
    }

    /**
     * 队列是否满
     *
     * @return
     */
    @Override
    public boolean isFull() {
        return front==(end+1)%(capacity+1);
    }

    /**
     * 添加
     *
     * @param num
     */
    @Override
    public void add(int num) {

        if(isFull()){
            System.out.print("the queue is full.");
            return;
        }

        arr[end]=num;
        // 循环队列的核心在于处理此处的取模
        end=(end+1)%(capacity+1);
    }

    /**
     * 获取队头
     */
    @Override
    public Integer poll() {

        if(isEmpty()){
            System.out.print("the queue is empty.");
            return null;
        }

        int data=arr[front];
        arr[front]=null;
        front=(front+1)%(capacity+1);
        return data;

    }

    /**
     * 获取长度
     *
     * @return
     */
    @Override
    public int length() {
        return (end-front+capacity+1)%(capacity+1);
    }

    public static void main(String args[]){


    }
}
