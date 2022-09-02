package com.alating.alo.leetcode.list;

public class RemoveTheLastNNode {

    public  ListNode removeNNode(ListNode head, int n){

        if(head==null){
            return head;
        }

        ListNode first=head;
        ListNode second=head;

        ListNode head2=new ListNode(0);
        head2.next=head;
        ListNode pre=head2;

        int len=1;
        while(second!=null && len<n){
            len++;
            second=second.next;
        }

        // 说明n 小于链表长度
        if(second!=null){

            while(second.next!=null){
                pre=pre.next;
                first=first.next;
                second=second.next;
            }

            pre.next=first.next;

            return head2.next;
        }else{

            // 如果是
            return head;
        }


    }

    public static void main(String args[]){

        ListNode head=new ListNode().getListNode(new int[]{1,2,3,4,5,6});


        new ListNode().printListNode(new RemoveTheLastNNode().removeNNode(head,9));


    }
}
