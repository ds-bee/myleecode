package com.huang.medium.trimBST;

import com.huang.easy.util.TreeNode;

import static com.huang.easy.util.TreeUtil.createTree;
import static com.huang.easy.util.TreeUtil.prePrinTree;

public class Solution1 {
    public static void main(String[] args) {

//        Integer[] arr={3,2,4,1};
        Integer[] arr={1,null,2};
        TreeNode tree = createTree(arr);
        TreeNode treeNode = trimBST(tree, 1, 1);
        prePrinTree(treeNode);
    }
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return root;
        }
        if(root.val < low){
            if(root.right != null&&root.right.val >= low){
                return root.right;
            }else if(root.right != null && root.right.val < low){
                return trimBST(root.right, low, high);
            }else {
                return null;
            }
        }
        if(root.val > high){
            if(root.left != null&&root.left.val <= high){
                return root.left;
            }else if(root.left != null && root.left.val > high){
                return trimBST(root.left, low, high);
            }else {
                return null;
            }
        }

        TreeNode treeNodeleft = trimBST(root.left, low, high);
        TreeNode treeNoderight = trimBST(root.right, low, high);
        root.left = treeNodeleft;
        root.right = treeNoderight;

        return root;
    }
}
