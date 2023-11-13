package com.alating.alo.leetcode.array;

import java.util.HashMap;

/**
 * https://blog.csdn.net/weixin_49693003/article/details/119942689
 */
public class LengthOfLongestSubstring {


    public int lengthOfLongestSubstring(String s) {


        int max=0;
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(int start=0,end=0;end<s.length();end++){

            Character cur= s.charAt(end);
            if(map.get(cur)!=null){
                start=Math.max(map.get(cur)+1,start);
            }
            map.put(cur, end);
            max=Math.max(max,end-start+1);
        }
        return max;

    }

    public static void main(String args[]){

        String astr="abbbbcde";

        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(astr));
    }
}
