package com.alating.alo.leetcode.list;

/**
 * https://leetcode.cn/problems/sort-list/
 *
 * 链表，就只能用归并排序了
 */
public class SortList {

    /**
     * 采用归并排序方法
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        if(head==null||head.next==null){
            return head;
        }

        // 先获取连表的两部分,这部分非常关键，如何在链表中求取中间节点
        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        // 此时slow是前半部分的最后
        ListNode head2=slow.next;
        slow.next=null; // 非常重要的一步

        ListNode l1=sortList(head);
        ListNode l2=sortList(head2);

        return mergeList(l1,l2);
    }

    public ListNode mergeList(ListNode l1,ListNode l2){

        ListNode dummyHead=new ListNode(0);
        ListNode cur=dummyHead;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;
            }else if(l2.val<=l1.val){
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }

        if(l1!=null){
            cur.next=l1;
        }

        if(l2!=null){
            cur.next=l2;
        }

        return dummyHead.next;
    }


    public static void main(String args[]){
        ListNode head=new ListNode().getListNode(new int[]{4,5,7,9,8,6,2,1});
        new ListNode().printListNode(new SortList().sortList(head));
    }
}
