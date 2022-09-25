package com.alating.alo.leetcode.string;

public class Zuobiao {

    private boolean isChecked(Character c){
        if(c== 'A' || c=='D' || c=='S' || c=='W'){
            return true;
        }
        return false;
    }

    public void printZuo(String str){

        int x=0;
        int y=0;

        String eles[]=str.split(";");

        int num=0;
        for(String ele:eles){


            if(ele==null ||ele=="" || ele.charAt(0)==' ' || !isChecked(ele.charAt(0))){
                continue;
            }
            Character action=ele.charAt(0);

            boolean checkDigit=false;
            boolean checkCha=false;
            for(int i=1;i<ele.length();i++){
                Character cc=ele.charAt(i);
                if(cc>='0' && cc<='9'){
                    num= num*10+ cc-'0';
                    checkDigit=true;
                }else if(checkDigit){
                    checkCha=true;
                    num=0;
                    break;
                }
            }

            if(checkDigit && checkCha){
                continue;
            }


            switch(ele.charAt(0)){
                case 'A':
                    x-=num;
                    break;
                case 'D':
                    x+=num;
                    break;
                case 'W':
                    y+=num;
                    break;
                case 'S':
                    y-=num;
                    break;

            }

            num=0;
        }

        System.out.println(x +","+ y);
    }
    public static void main(String args[]){


        new Zuobiao().printZuo("A10;S20;W10;D30;X;A1A;B10A11;;A10;");

    }
}
