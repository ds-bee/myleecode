package com.huang.easy.maxDepth;



public class Solution {
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
    }
    int length = 0;

    public int maxDepth(TreeNode root) {
        if(root == null){
            return length;
        }else {
            length++;
        }
        if(root.left != null){
            maxDepth(root.left);
        }else if(root.left == null && root.right != null ){
            length--;
        }
        if(root.right != null){
            maxDepth(root.right);
        }
        return length;
    }


}
