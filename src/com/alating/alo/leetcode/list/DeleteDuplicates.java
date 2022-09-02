package com.alating.alo.leetcode.list;

import com.alating.alo.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 *
 * 删除排序链表中的重复元素2
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        ListNode p=head;
        while (p!=null){
            map.put(p.val,map.getOrDefault(p.val,0)+1);
            p=p.next;
        }

        ListNode head2=new ListNode(0);
        ListNode pre=head2;

        p=head;
        while (p!=null){

            if(map.get(p.val)==1){
                pre.next=p;
                pre=p;
            }
            p=p.next;
        }
        pre.next=null;

        return head2.next;

    }

    public static void main(String args[]){

        ListNode ls=new ListNode().getListNode(new int[]{1,2,3,3,4,4,5});

        new ListNode().printListNode(new DeleteDuplicates().deleteDuplicates(ls));

    }
}
