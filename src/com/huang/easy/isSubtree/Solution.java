package com.huang.easy.isSubtree;

import com.huang.easy.util.TreeNode;

public class Solution {


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot != null) {
            return false;
        }
        if (root != null && subRoot == null) {
            return false;
        }
        if(judge(root,subRoot)){
            return true;
        }else {
            return isSubtree(root.left,subRoot) || isSubtree(root.right, subRoot);
        }

    }
    public static boolean judge(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null && subRoot != null) {
            return false;
        }
        if (root != null && subRoot == null) {
            return false;
        }
        if(root.val == subRoot.val){
            return judge(root.left,subRoot.left) && judge(root.right,subRoot.right);
        }
        return false;
    }


}
