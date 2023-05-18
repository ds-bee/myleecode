package com.huang.medium.isValidBST;

import com.huang.easy.util.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return validBST(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }
    boolean validBST(long lower, long upper, TreeNode root) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return validBST(lower, root.val, root.left) && validBST(root.val, upper, root.right);
    }
    static int a = Integer.MIN_VALUE;

//    public static boolean isValidBST(TreeNode root) {
//        if(root == null){
//            return true;
//        }
//        boolean left = isValidBST(root.left);
//        if(left < )
//
//
//        return true;
//    }
//    public static boolean find(TreeNode root, int val){
//        if(root == null){
//            return true;
//        }
//
//    }

}
