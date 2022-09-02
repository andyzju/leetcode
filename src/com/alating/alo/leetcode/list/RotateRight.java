package com.alating.alo.leetcode.list;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/rotate-list/
 *
 * 这就是一个两段法，先将后续k开始，然后从开头开始到len-k；
 */
public class RotateRight {


    /**
     *  + 链表方法
     *
     * 栈中是倒序出k个元素，在链接出
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || k==0){
            return head;
        }

        ListNode p=head;

        ArrayList<ListNode> list=new ArrayList<>();

        int len=0;
        while(p!=null){
            list.add(p);
            p=p.next;
            len++;
        }

        k=k%len;

        if(k==0){
            return head;
        }


        ListNode head2=new ListNode(0);
        ListNode pre=head2;


        // 这一块类似 删除倒数n个元素
        int idx=len-k;
        while(idx<len){
            ListNode cur=list.get(idx);
            idx++;
            pre.next=cur;
            pre=cur;
        }

        int res=len-k;
        p=head;
        while (p!=null && res-->0){
            pre.next=p;
            pre=pre.next;
            p=p.next;
        }

        pre.next=null;

        return head2.next;
    }

    public static void main(String args[]){

        ListNode head=new ListNode().getListNode(new int[]{1,2});

        new ListNode().printListNode(new RotateRight().rotateRight(head,1));
    }
}
