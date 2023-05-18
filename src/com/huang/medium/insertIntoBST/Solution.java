package com.huang.medium.insertIntoBST;

import com.huang.easy.util.TreeNode;

import static com.huang.easy.util.TreeUtil.createTree;
import static com.huang.easy.util.TreeUtil.prePrinTree;

public class Solution {
    public static void main(String[] args) {
        Integer[] arr={4,2,7,1,3};
        TreeNode tree = createTree(arr);
        TreeNode treeNode = insertIntoBST(tree, 5);
        prePrinTree(treeNode);

    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val < val){
            root.right = insertIntoBST(root.right, val);
        }
        if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
