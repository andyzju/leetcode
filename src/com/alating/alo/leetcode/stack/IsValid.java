package com.alating.alo.leetcode.stack;


import java.util.Stack;

public class IsValid {

    private boolean isPair(Character left, Character right){

        if(left.equals('(') && right.equals(')')){
            return true;
        }else if(left.equals('{') && right.equals('}')){
            return true;
        }else if(left.equals('[') && right.equals(']')){
            return true;
        }else{
            return false;
        }
    }
    public boolean isValid(String s) {

        Stack<Character> stack=new Stack<Character>();

        int num=0;
        for(Character ch : s.toCharArray()){

            if(ch.equals('(')||ch.equals('{') || ch.equals('[')){
                stack.add(ch);
            }else if(ch.equals(')')||ch.equals('}') || ch.equals(']')){
                if(!stack.empty() && isPair(stack.peek(),ch)){
                    stack.pop();
                    num++;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }

        if(stack.isEmpty() && num==s.length()/2){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String args[]){

        System.out.println(new IsValid().isValid("()"));
    }
}
