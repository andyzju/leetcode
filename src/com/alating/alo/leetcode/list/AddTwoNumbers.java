package com.alating.alo.leetcode.list;

import java.util.List;

/**
 * https://leetcode.cn/problems/add-two-numbers/
 *
 * 两数相加
 */
public class AddTwoNumbers {


    /**
     * 这种方式容易超出边界
     * @param head
     * @return
     */
    private int getNum(ListNode head){
        if(head==null){
            return 0;
        }
        int x=0;
        int num=0;
        while(head!=null){
            num+= head.val * Math.pow(10,x++);
            head=head.next;
        }
        return num;
    }

    /**
     * 链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1==null && l2==null){
            return null;
        }

        int sum= getNum(l1)+getNum(l2);

        int mod=sum;

        ListNode head=new ListNode(0);
        ListNode pre=head;

        if(mod==0){
            return head;
        }

        while(mod!=0){
            int y=mod%10;
            mod/=10;

            ListNode cur=new ListNode(y);
            pre.next=cur;
            pre=cur;

        }
        return head.next;
    }



    // 上述方法需要保障链表长度和数据范围在long类型以内，所以需要采用字符串的处理方法


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        if(l1==null && l2==null){
            return null;
        }

        ListNode p=l1,q=l2;

        ListNode head=new ListNode(0);
        ListNode pre=head;

        int carry=0;

        while(p!=null ||q!=null){

            int x=p!=null?p.val:0;
            int y=q!=null?q.val:0;

            int temp= x + y +carry;
            p=p!=null?p.next:p;
            q=q!=null?q.next:q;

            carry=temp/10;

            int mod=temp%10;

            ListNode cur=new ListNode(mod);
            pre.next=cur;
            pre=cur;
        }

        /**
         * 最后一个补充
         */
        if(carry!=0){
            ListNode cur=new ListNode(carry);
            pre.next=cur;
            pre=cur;
        }

        return head.next;

    }

    public static void main(String args[]){

        ListNode l1=new ListNode().getListNode(new int[]{9});
        ListNode l2=new ListNode().getListNode(new int[]{1,9,9,9,9,9,9,9,9,9});

        new ListNode().printListNode(new AddTwoNumbers().addTwoNumbers2(l1,l2));

    }
}
