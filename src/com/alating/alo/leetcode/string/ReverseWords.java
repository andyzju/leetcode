package com.alating.alo.leetcode.string;

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 *
 * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 该方法是可以执行的；
 *
 *
 * 还有没有更简介的方法
 */
public class ReverseWords {


    /**
     * 针对整个单词进行逆序
     * @param ele
     * @return
     */
    private String reverse(String ele){

        StringBuffer sb=new StringBuffer();
        for(int i=ele.length()-1;i>=0;i--){
            sb.append(ele.charAt(i));
        }
        return sb.toString();
    }

    private boolean isBlank(String ele){
        boolean flag=true;
        for(int i=0;i<ele.length();i++){
            if(ele.charAt(i)!=' '){
                return false;
            }
        }
        return flag;
    }
    /**
     * 核心方法是将 1.字符串按照单词进行切割；2。 按照每个单词进行逆序，然后拼接成一个字符串；
     * 3。 针对整个字符串进行逆序
     * @param s
     * @return
     */
    public String reverseWords(String s) {

        if(s==null){
            return s;
        }

        String arr[]=s.split(" ");

        StringBuffer sb=new StringBuffer();
        for(String e:arr){
            if(!isBlank(e)){
                sb.append(reverse(e)).append(" ");
            }
        }
        return reverse(sb.toString().trim());
    }

    public static void main(String args[]){

        System.out.println(new ReverseWords().reverseWords("the sky is blue"));
        System.out.println(new ReverseWords().reverseWords("  hello world  "));
        System.out.println(new ReverseWords().reverseWords("a good   example"));
    }
}
