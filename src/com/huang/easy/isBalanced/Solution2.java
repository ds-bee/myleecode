package com.huang.easy.isBalanced;

import com.huang.easy.util.TreeNode;

import static com.huang.easy.util.TreeUtil.createTree;
import static com.huang.easy.util.TreeUtil.prePrinTree;

public class Solution2 {
    public static void main(String[] args) {
//        Integer[] arr={1,null,2,null,3};
//        Integer[] arr={1,2,2,3,null,null,3,4,null,null,4};

        Integer[] arr={3,9,20,null,null,15,7};
        TreeNode tree = createTree(arr);
//        prePrinTree(tree);
        boolean balanced = isBalanced(tree);
        System.out.println(balanced);

//        prePrinTree(tree);
    }
    public static boolean isBalanced(TreeNode root) {
        if(root == null || (root.right == null && root.left == null) ){
            return true;
        }
        boolean flag = false;
        int left = findnum(0, root.left);
        int right = findnum(0, root.right);
        if(Math.abs(left - right) <2 ){
            flag = true;
        }
        if(!(isBalanced(root.left) && isBalanced(root.right))){
            flag = false;
        }
        return flag;
    }
    public static int findnum(int len, TreeNode root){
        if(root == null ){
            return len;
        }
        if(root.left == null && root.right == null){
            return len+1;
        }
//        len = len + 1;
        int left = 0;
        int right = 0;
        if(root.left != null){
            left = findnum(len + 1, root.left);
        }
        if(root.right != null){
            right = findnum(len + 1, root.right);
        }
        return Math.max(left, right);

    }


}
