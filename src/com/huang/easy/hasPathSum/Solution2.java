package com.huang.easy.hasPathSum;

import com.huang.easy.util.TreeNode;

import static com.huang.easy.util.TreeUtil.createTree;

public class Solution2 {
    public static void main(String[] args) {
        Integer[] arr={5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode tree = createTree(arr);
        System.out.println(hasPathSum(tree, 22));
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        int sum = 0;
        boolean flag = false;
        return find(flag,root, sum, targetSum);
    }
    public static boolean find(boolean flag, TreeNode root, int sum, int targetSum){
        if(root == null){
            return flag;
        }
        sum = sum + root.val;
        if(root.left == null && root.right == null){
            if(sum == targetSum){
                flag = true;
                return flag;
            }
        }
//        find(flag, root.left, sum, targetSum);
//        find(flag, root.right, sum, targetSum);
//        return flag;
        return find(flag, root.left, sum, targetSum)||find(flag, root.right, sum, targetSum);
    }

}
