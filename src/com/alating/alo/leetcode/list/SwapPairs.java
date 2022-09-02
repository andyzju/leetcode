package com.alating.alo.leetcode.list;

/**
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 *
 * 24. 两两交换链表中的节点
 *
 */
public class SwapPairs {

    /**
     * 两两交换节点
     * 这个和 kgroup 类似
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode headF=new ListNode(0);
        headF.next=head;
        ListNode pre=headF;
        ListNode first=head;


        // 三个重要的参数
        //  pre\first\second
        while(first!=null){
            ListNode second=first.next;
            // 终止条件
            if(second==null){
                break;
            }

            // 开始针对 first,second进行排查
            ListNode next=second.next;

            //换顺序
            second.next=first;
            first.next=next;
            pre.next=second;

            //重新设置
            pre=first;
            first=next;
        }

        return headF.next;
    }

    public static void main(String args[]){

        new ListNode().printListNode(new SwapPairs().swapPairs(new ListNode().getListNode(new int[]{1,2,3,4,5,6})));
    }
}
