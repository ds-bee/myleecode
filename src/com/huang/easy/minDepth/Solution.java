package com.huang.easy.minDepth;

import com.huang.easy.util.TreeNode;
import com.huang.easy.util.TreeUtil;

public class Solution {
    public static void main(String[] args) {
        Integer[] ints = {2,null,3,null,4,null,5,null,6};
        TreeNode tree = TreeUtil.createTree(ints);
        int i = minDepth(tree);
        System.out.println(i);
    }




    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
     if(root.left == null && root.right == null){
         return 0;
     }else if(root.left == null){
         minDepth(root.right);
     }else if(root.right == null){
         minDepth(root.left);
     }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


}
