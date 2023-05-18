package com.huang.easy.invertTree;

import com.huang.easy.util.TreeNode;

import static com.huang.easy.util.TreeUtil.createTree;
import static com.huang.easy.util.TreeUtil.prePrinTree;

public class Solution {
    public static void main(String[] args) {
        Integer[] arr={4,2,7,1,3,6,9};
        TreeNode tree = createTree(arr);
        TreeNode treeNode = invertTree(tree);
        prePrinTree(treeNode);
    }
    public static TreeNode invertTree(TreeNode root) {
        TreeNode treeNode = new TreeNode(root.val);
//        treeNode = root;
        TreeNode change = change(treeNode, root);
        return change;
    }
    public static TreeNode change(TreeNode treeNode, TreeNode root){
        if(root == null){
            return treeNode;
        }
        treeNode.val = root.val;
        if(root.right != null){
            //这里需要创建新的节点来接受接受前一节点指针
            change(treeNode.left, root.right);
        }
        if(root.left != null){
            change(treeNode.right, root.left);
        }
        return treeNode;

    }

//    public static TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode treeNode = new TreeNode(root.val);
//        change(treeNode, root);
//        return treeNode;
//    }
//
//    public static void change(TreeNode treeNode, TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        if (root.right != null) {
//            treeNode.left = new TreeNode(root.right.val);
//            change(treeNode.left, root.right);
//        }
//        if (root.left != null) {
//            treeNode.right = new TreeNode(root.left.val);
//            change(treeNode.right, root.left);
//        }
//    }

}
