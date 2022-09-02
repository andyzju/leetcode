package com.alating.alo.leetcode.list;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 *
 * 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd {


    /**
     * 删除链表的节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {

        if(head==null || n==0){
            return head;
        }

        ListNode headF= new ListNode(0);
        headF.next=head;
        ListNode p=head;

        int len=0;
        while(p!=null){
            len++;
            p=p.next;
        }

        // n比链表长度更长
        if(len < n){
            return head;
        }

        if(len==n){
            headF.next=headF.next.next;
            return headF.next;
        }

        int preIdx=len-n;
        int removeIdx=len-n+1;

        p=head;
        int idx=0;
        ListNode pre=null;
        ListNode remove=null;
        while(p!=null){
            idx++;
            if(idx==preIdx){
                pre=p;
            }

            if(idx==removeIdx){
                remove=p;
            }

            p=p.next;
        }
        pre.next=remove.next;

        return headF.next;
    }


    /**
     * 采用栈的方法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null ){
            return head;
        }

        Stack<ListNode> stack=new Stack<ListNode>();

        ListNode headF=new ListNode(0);
        headF.next=head;
        ListNode p=head;

        while(p!=null){
            stack.push(p);
            p=p.next;
        }

        int i=0;
        while(i<n){
            stack.pop();
            i++;
        }

        // 如果n比长度大会如何
        // 栈空，则不操作
        if(stack.isEmpty()){
            return head;
        }

        ListNode pre=stack.peek();
        pre.next=pre.next.next;

        return headF.next;
    }


    /**
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        if(head==null){
            return head;
        }

        ListNode headF=new ListNode(0);
        headF.next=head;

        ListNode first=head;
        ListNode second=headF;//  这里设计巧妙，这样就不需要pre节点了

        for(int i=0;i<n;i++){
            first=first.next;
        }

        while(first!=null){
            first=first.next;
            second=second.next;
        }

        second.next=second.next.next;

        return headF.next;
    }
}
