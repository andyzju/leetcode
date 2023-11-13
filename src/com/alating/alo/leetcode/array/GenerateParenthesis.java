package com.alating.alo.leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * https://leetcode.cn/problems/generate-parentheses/
 *
 * 生产括号，三步走
 *
 * 1. 产生括号
 * 2. 判断括号是否ok
 */
public class GenerateParenthesis {



    private boolean valid(char []com,int n){

        Stack<Character> stack=new Stack<Character>();
        int k=0;
        for(char c:com){
            if(c=='('){
                stack.push(c);
            }else if(c==')' && !stack.isEmpty()){
                stack.pop();
                k++;
            }
        }

        return stack.isEmpty() && k==n/2;

    }
    /**
     * 构成数组
     * @param com
     * @param pos
     * @param result
     */
    private void generateAll(char [] com, int pos, List<String> result){

        if(pos == com.length){
            if(valid(com,com.length)){
                result.add(new String(com));
            }
        }else{
            com[pos]='(';
            generateAll(com,pos+1,result);
            com[pos]=')';
            generateAll(com,pos+1,result);
        }
    }

    public List<String> generateParenthesis(int n) {

        ArrayList<String> result=new ArrayList<>();
        if(n==0){
            return result;
        }

        generateAll(new char[2*n],0,result);

        return result;
    }

    public static void main(String args[]){


        System.out.println(new GenerateParenthesis().generateParenthesis(3));

    }
}
