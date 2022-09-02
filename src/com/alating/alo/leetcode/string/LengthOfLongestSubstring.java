package com.alating.alo.leetcode.string;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {

    /**
     * 滑动窗口的代码
     * @param s
     * @return
     */
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

        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abccdefgqabhab"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbbb"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("dvdf"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(" "));
    }
}
