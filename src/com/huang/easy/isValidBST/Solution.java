package com.huang.easy.isValidBST;

import com.huang.easy.util.TreeNode;

import java.util.Stack;

import static com.huang.easy.util.TreeUtil.createTree;

public class Solution {
    public static void main(String[] args) {
        Integer[] arr={5,4,6,3,7,null,null};
        TreeNode tree = createTree(arr);
        System.out.println(isValidBST1(tree));

    }
    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left != null && root.left.val >= root.val){
            return false;
        }
        if(root.right != null && root.right.val < root.val){
            return false;
        }
        boolean flag = true;
//        if(root)
        if(!(isValidBST(root.left)||isValidBST(root.right))){
            flag = false;
        }
        return flag;

    }

    public static boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;// 左
            }
            // 中，处理
            TreeNode pop = stack.pop();
            if (pre != null && pop.val <= pre.val) {
                return false;
            }
            pre = pop;

            root = pop.right;// 右
        }
        return true;
    }


}
