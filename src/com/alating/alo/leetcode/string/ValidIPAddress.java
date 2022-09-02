package com.alating.alo.leetcode.string;

import javax.print.DocFlavor;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/validate-ip-address/
 *
 * 验证IP地址
 */
public class ValidIPAddress {


    /**
     * 判断是否是ipv4
     * @param queryIP
     * @return
     */
    private boolean isIpv4(String queryIP){
        Stack<Integer> stack=new Stack<>();

        int multi=0;
        int pointNum=0;
        queryIP=queryIP+".";
        for(int i=0;i<queryIP.length();i++){

            if(queryIP.charAt(i)=='.'){
                pointNum++;
                if(multi>=0 && multi<=255 && stack.size()>0){
                    multi=0;
                    stack= new Stack<>();
                    continue;
                }else{
                    return false;
                }
            }else if(Character.isDigit(queryIP.charAt(i))){

                //  前导0
                if(queryIP.charAt(i)=='0' && stack.size()==0){
                    return false;
                }
                multi=10*multi+ queryIP.charAt(i)-'0';
                stack.push(queryIP.charAt(i)-'0');
            }else{
                return false;
            }
        }

        return pointNum==4;
    }

    private boolean isIpv6(String queryIP){

        Stack<Character> stack=new Stack<>();

        int pointNum=0;
        queryIP=queryIP+":";

        for(int i=0;i<queryIP.length();i++){

            if(queryIP.charAt(i)==':'){
                pointNum++;
                if(stack.size()<=4 && stack.size()>0){
                    stack= new Stack<>();
                    continue;
                }else {
                    return false;
                }
            }else if(Character.isDigit(queryIP.charAt(i)) ||
                    (queryIP.charAt(i)>='a' && queryIP.charAt(i)<='f') ||
                    (queryIP.charAt(i)>='A' && queryIP.charAt(i)<='F')){

                stack.push(queryIP.charAt(i));
            }else{
                return false;
            }
        }
        return pointNum==8;
    }
    /**
     *
     * @param queryIP
     * @return
     */
    public String validIPAddress(String queryIP) {

        if(queryIP==null || queryIP.length()==0){
            return "Neither";
        }

        if(queryIP.contains(".")){
            return isIpv4(queryIP)?"IPv4":"Neither";
        }else if(queryIP.contains(":")){
            return isIpv6(queryIP)?"IPv6":"Neither";
        }
        return "Neither";
    }


    public static void main(String args[]){


        System.out.println(new ValidIPAddress().validIPAddress("172.16.254.1"));

        System.out.println(new ValidIPAddress().validIPAddress("172.16.254.01"));

        System.out.println(new ValidIPAddress().validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));

        System.out.println(new ValidIPAddress().validIPAddress("2001:0db8:85a3:0:00:8a2e:0370:7334"));

    }
}
