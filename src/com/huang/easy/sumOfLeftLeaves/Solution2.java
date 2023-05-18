package com.huang.easy.sumOfLeftLeaves;

import com.huang.easy.util.TreeNode;

import static com.huang.easy.util.TreeUtil.createTree;

public class Solution2 {
    public static void main(String[] args) {
//        Integer[] arr={3,9,20,null,null,15,7};
        Integer[] arr={1,2,3,4,5};
        TreeNode tree = createTree(arr);
        System.out.println(sumOfLeftLeaves(tree));
    }
    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        return leftsun(sum, root);
    }
    public static int leftsun(int sum, TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left != null){
            if(root.left.left ==null && root.left.right==null){
                sum = sum + root.left.val;
            }
            sum = leftsun(sum, root.left);
        }
        if(root.right != null){
            sum = leftsun(sum, root.right);
        }
        return sum;
    }


}
