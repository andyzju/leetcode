package com.alating.alo.leetcode.tree;

/**
 * https://blog.csdn.net/weixin_30363263/article/details/80181628
 */
public class IsValidBST {


    /**
     *  这个递归的用法很巧妙
     *
     *  还有另一种用法，中序遍历，看看是不是递增的
     * @param root
     * @param pre
     * @return
     */
    private boolean isValidBSTDeep(TreeNode root,long pre){
        if(root==null){
            return true;
        }

        if(!isValidBSTDeep(root.left,pre)){
            return false;
        }

        if(root.val<=pre){
            return false;
        }
        pre=root.val;

        return isValidBSTDeep(root.right,pre);

    }

    /**
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }

        long pre=Integer.MIN_VALUE;
        boolean flag = isValidBSTDeep(root,pre);
        return flag;
    }

    // 采用中序遍历，然后验证树句是否升序即可


    // https://blog.csdn.net/weixin_30363263/article/details/80181628
}
