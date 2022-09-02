package com.alating.alo.leetcode.tree;

import java.util.*;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    /**
     * 通过层次遍历创建树
     * 非常完美的
     * @param arr
     * @return
     */
      TreeNode getLevelTreeNode(Integer arr[]) {

          if (arr == null || arr.length == 0) {
              return null;
          }

          //  非常关键的一个树的数组
          TreeNode[] treeArr = new TreeNode[arr.length];

          for (int i = 0; i <= arr.length - 1; i++) {

              // 位置i的节点还没创建，同时值不为null
              if (treeArr[i] == null && arr[i] != null) {
                  TreeNode cur = new TreeNode(arr[i]);
                  treeArr[i] = cur;
              }

              // 如果当前是null，那么其必然没有[左右子树]，后序逻辑跳过
              if(arr[i]==null){
                  continue;
              }
              int leftIdx = 2 * i + 1;
              if (leftIdx < arr.length && arr[leftIdx] != null) {
                  TreeNode left = new TreeNode(arr[leftIdx]);
                  treeArr[leftIdx]=left;
                  treeArr[i].left = left;
              } else {
                  treeArr[i].left = null;
              }

              int rightIdx = 2 * i + 2;
              if (rightIdx < arr.length && arr[rightIdx] != null) {
                  TreeNode right = new TreeNode(arr[rightIdx]);
                  treeArr[rightIdx]=right;
                  treeArr[i].right = right;
              } else {
                  treeArr[i].right = null;
              }
          }
          return treeArr[0];
      }

    /**
     * 按照层次遍历
     */
    public void levelVisit(TreeNode root){

        if(root==null){
            return;
        }

        List<Integer> res=new ArrayList<Integer>();

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){

            TreeNode cur=queue.poll();
            res.add(cur.val);

            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }

        System.out.println(res);

    }

    /**
     * 递归前序
     * @param root
     */
    public void preVisitOrigin(TreeNode root,ArrayList<TreeNode> lst){

        if(root!=null){
            lst.add(root);
            if(root.left!=null){
                preVisitOrigin(root.left,lst);
            }
            if(root.right!=null){
                preVisitOrigin(root.right,lst);
            }
        }
    }
    /**
     * 按照前序遍历
     *
     * 采用栈， 压入树头，出栈后，先压入右子树，再压入左子树
     */
    public void preVisit(TreeNode root){

        if(root==null){
            return;
        }

        List<Integer> res=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode cur= stack.pop();
            res.add(cur.val);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
        System.out.println(res);
    }

    /**
     * 按中序遍历
     *
     * 递归的访问方法
     */
    public void midVisitOrigin(TreeNode root,ArrayList<Integer> lst){

        if(root==null){
            return;
        }

        if(root.left!=null){
            midVisitOrigin(root.left,lst);
        }

        lst.add(root.val);

        if(root.right!=null){
            midVisitOrigin(root.right,lst);
        }
    }


    /**
     * 按中序遍历
     *
     * 需要注意 while 里面的条件
     *
     * 需要注意
     */
    public void midVisit(TreeNode root){

        if(root==null){
            return;
        }

        List<Integer> res=new ArrayList<Integer>();
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode q=root;
        while(q!=null || !stack.isEmpty()){

            while(q!=null){
                stack.push(q);
                q=q.left;
            }

            if(!stack.isEmpty()){
                TreeNode cur=stack.pop();
                res.add(cur.val);
                q=cur.right;
            }
        }

        System.out.println(res);

    }

      public static void main(String args[]){

        TreeNode root=new TreeNode().getLevelTreeNode(new Integer[]{1,2,3,4,5,6,7,null,8});
        new TreeNode().levelVisit(root);
        new TreeNode().preVisit(root);

        ArrayList<Integer> res=new ArrayList<Integer>();
        new TreeNode().midVisitOrigin(root,res);
        System.out.println(res);

          ArrayList<Integer> res2=new ArrayList<Integer>();
          new TreeNode().midVisit(root);
          //System.out.println(res);
      }

  }