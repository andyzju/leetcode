package com.alating.alo.leetcode.list;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 */
public class ReverseKGroup {


    /**
     * 反转链表
     * @param start
     * @return
     */
    private ListNode reverse(ListNode start){
        ListNode pre=null;
        ListNode cur=start;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;

    }
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head==null || head.next==null ||k<=1){
            return head;
        }

        ListNode headF=new ListNode(0);
        headF.next=head;


        ListNode pre=headF;
        ListNode end=headF;

        while(end.next!=null) {

            // 这里容易出错

            for(int i=0;i<k && end!=null;i++){
                end=end.next;
            }

            if(end==null){
                break;
            }

            // 逆序
            ListNode start=pre.next;
            ListNode next=end.next;

            // 后续的处理
            end.next=null;  // 这个容易忽略
            pre.next= reverse(start);

            // 前后连接上 [容易缺漏]
            start.next=next;

            pre=start;
            end=start;
        }

        return headF.next;
    }

    public static  void main(String args[]){

        ListNode head=new ListNode().getListNode(new int []{1,2,3,4,5});

        ListNode newreveerse = new ReverseKGroup().reverseKGroup(head,2);

        new ListNode().printListNode(newreveerse);

    }
}
