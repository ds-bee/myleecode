package com.huang.medium.convertBST;

import com.huang.easy.util.TreeNode;

public class Solution {
    public static TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        int val = 0;
        int tem = convertBSTv1(root, val);
        return root;
    }
    public static int convertBSTv1(TreeNode root, int val) {
        if(root == null){
            return 0;
        }
        int tem = convertBSTv1(root.right, root.val);
        val = root.val + val;
        root.val = val;
        int tem1 = convertBSTv1(root.left,root.val);
        return val;
    }
}
