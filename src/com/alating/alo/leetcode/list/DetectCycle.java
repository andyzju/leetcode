package com.alating.alo.leetcode.list;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 *
 * 环形链表 II
 */
public class DetectCycle {

    /**
     *
     * a= (n-1)(b+c) + c
     * 检测到链表是否有环
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        if(head==null|| head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while( fast!=null) {

            if (fast != null && fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;

            if (fast == slow) {
                ListNode ptr = head; // 这里的操作很关键
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }

                return ptr;
            }

        }
        return null;
    }


    /**
     * 判断是否有环
     * @param head
     * @return
     */
    public boolean isCycle(ListNode head){

        if(head==null || head.next==null){
            return false;
        }

        ListNode slow=head;
        ListNode fast=head;

        while(slow!=fast){

            if(fast!=null && fast.next!=null){
                fast=fast.next.next;
            }else{
                return false;
            }
            slow=slow.next;
        }
        return true;

    }
}
