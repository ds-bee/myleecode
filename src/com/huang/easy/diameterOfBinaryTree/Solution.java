package com.huang.easy.diameterOfBinaryTree;

import com.huang.easy.util.TreeNode;
import com.huang.easy.util.TreeUtil;

public class Solution {


    public static void main(String[] args) {
                Integer[] ints = {1,2};
//        Integer[] ints = {4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};
//        Integer[] ints = {1,null,2};
//        Integer[] ints = {1,2,3,4,5};
        TreeNode treeNode = TreeUtil.createTree(ints);
        System.out.println(diameterOfBinaryTree(treeNode));

    }
    static int sum = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        int left = 0,right = 0;
        if(root == null){
            return 0;
        }
        if(root.left != null){
            left = height(root.left);
        }

        if(root.right != null){
            right = height(root.right);
        }
        sum = Math.max(left+right,sum);
        return Math.max(sum,Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));

    }
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left) , height(root.right));
    }

}
