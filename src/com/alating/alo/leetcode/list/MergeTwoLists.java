package com.alating.alo.leetcode.list;

import com.alating.alo.leetcode.list.ListNode;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null){
            return list2;
        }

        if(list2==null){
            return list1;
        }

        ListNode p=list1;
        ListNode q=list2;

        ListNode head=new ListNode(0);
        ListNode cur=head;

        while(p!=null && q!=null){

            if(p.val<=q.val){
                cur.next=p;
                cur=p;
                p=p.next;
            }else{
                cur.next=q;
                cur=q;
                q=q.next;
            }
        }

        if(p!=null){
            cur.next=p;
        }
        if(q!=null){
            cur.next=q;
        }

        return head.next;
    }
}
