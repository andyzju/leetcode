package com.alating.alo.leetcode.string;

/**
 * https://mp.weixin.qq.com/s/XcKQwnwCh5nZsz-DLHJwzQ
 *
 * 36进制的加法
 *
 * great;
 */
public class AddFor36 {


    public char getChar(int mod){
        if(0<=mod && mod<=9){
            return (char) (mod+'0');
        }else{
            return (char) (mod-10+'a');
        }
    }

    /**
     * 36进制的转换
     * @param a
     * @return
     */
    public int getNum(char a){

        if(a>='0' && a<='9'){
            return a-'0';
        }else{
            return a-'a'+10;
        }

    }
    public String addFor36(String a,String b){

        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }

        int len1=a.length();
        int len2=b.length();

        int x,y;
        int i=len1-1;
        int j=len2-1;
        int carry=0;

        StringBuffer res=new StringBuffer();

        while(i>=0 || j>=0){

            x=getNum(a.charAt(i));
            y=getNum(b.charAt(j));

            int tmp=x+y+carry;

            int mod= tmp%36;
            carry= tmp/36;

            res.append(getChar(mod));
            i--;
            j--;
        }

        return res.reverse().toString();
    }

    public static void main(String args[]){
        System.out.println(new AddFor36().addFor36("1b","2x"));
    }
}
