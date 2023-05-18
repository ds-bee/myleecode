package com.huang.easy.searchBST;

import com.huang.easy.util.TreeNode;

import static com.huang.easy.util.TreeUtil.createTree;
import static com.huang.easy.util.TreeUtil.prePrinTree;

public class Solution {
    public static void main(String[] args) {
        Integer[] arr={4,2,7,1,3};
        TreeNode tree = createTree(arr);
        TreeNode treeNode = searchBST(tree, 2);
        prePrinTree(treeNode);

    }
    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        if(root.val > val){
            root = searchBST(root.left, val);
            if(root == null){
                return null;
            }
        }
        if(root.val < val){
            root = searchBST(root.right, val);
            if(root == null){
                return null;
            }
        }
        return root;

    }
}
