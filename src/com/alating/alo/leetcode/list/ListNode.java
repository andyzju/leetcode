package com.alating.alo.leetcode.list;

 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; this.next=null;}
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     public ListNode getListNode(int []arr){

          ListNode headF=new ListNode(0);
          ListNode pre=headF;
          for(int e:arr){
              ListNode cur=new ListNode(e);
              cur.next=null;
              pre.next=cur;
              pre=cur;
          }
          return headF.next;
     }

     public void  printListNode(ListNode head){

          StringBuffer sb=new StringBuffer();
         while(head!=null){
             sb.append(head.val).append(" ");
             head=head.next;
         }

         System.out.println(sb.toString());
     }


     /**
      * 逆序
      * @param head
      * @return
      */
     public ListNode reverseList(ListNode head){

         if(head==null){
             return head;
         }

         ListNode pre=null;
         ListNode headF=new ListNode(0);
         headF.next=head;
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
          ListNode head=new ListNode().getListNode(new int[]{1,2,3,4,5,6});

          ListNode reverseHead = new ListNode().reverseList(head);

          new ListNode().printListNode(reverseHead);

          new ListNode().printListNode(head);
     }
  }

