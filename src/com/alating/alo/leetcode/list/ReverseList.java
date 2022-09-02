package com.alating.alo.leetcode.list;

public class ReverseList {

    public ListNode reverseList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    public static void main(String args[]){


        ListNode head = new ListNode().getListNode(new int[]{0,1,2,3,4,5,6});

        new ListNode().printListNode(new ReverseList().reverseList(head));
    }


}
