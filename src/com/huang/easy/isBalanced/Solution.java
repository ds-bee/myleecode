package com.huang.easy.isBalanced;


import com.huang.easy.util.TreeNode;
import com.huang.easy.util.TreeUtil;

public class Solution {


    public static void main(String[] args) {
//        Integer[] ints = {1,2,2,3,3,null,null,4,4};
//        Integer[] ints = {3,9,20,null,null,15,7};
//        Integer[] ints = {1,null,2,null,3};
        Integer[] ints = {2,1,4,null,null,3,5,null,null,null,6};
        TreeNode treeNode = TreeUtil.createTree(ints);
        boolean balanced = isBalanced(treeNode);
        System.out.println(balanced);

    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftTree;
        if (root.left == null) {
            leftTree = 0;
        } else {
            leftTree = leftTree(root.left, 1);
        }
        int rightTree;
        if (root.right == null) {
            rightTree = 0;
        } else {
            rightTree = leftTree(root.right, 1);
        }

        int max = Math.abs(leftTree - rightTree);
        if (max <= 1  && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        } else {
            return false;
        }

    }

    public static int leftTree(TreeNode root, int level){
        if(root == null){
            return level;
        }
        if(root.left != null){
            level = leftTree(root.left,level+1);

        }else if(root.right != null){
            level = leftTree(root.right, level + 1);
        }
        return level;
    }


}
