package com.alating.alo.leetcode.array;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class Func {


    private Long lastFirst = System.currentTimeMillis();
    private Integer count =0;


    /**
     *
     */
    public String func(){

        Long curr= System.currentTimeMillis();

        if(curr-lastFirst> 10*60*1000){
            count=0;
            lastFirst=System.currentTimeMillis();
        }

        if(count>=1000){
            return "请求被拒绝";
        }else{
            count++;
            return "正常处理";
        }
    }


    public Func(){
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                count = 0;
                lastFirst = System.currentTimeMillis();
            }
        }, 600000, 600000);
    }

    public static void main(String args[]){

        Func func=new Func();
        System.out.println(func.func());

    }

}
