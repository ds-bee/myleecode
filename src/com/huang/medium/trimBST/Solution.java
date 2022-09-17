package com.huang.medium.trimBST;

import com.huang.easy.util.TreeNode;
import com.huang.easy.util.TreeUtil;

public class Solution {
    /**
     * 这个题又是一种把算法归咎成一种思维的方式的解题，先检查root节点，符合要求就跳出，不符合要求就进入递归
     * 当符合要求的时候将左节点置为将左节点放入递归函数
     * 右节点同理 ，最终返回root就行
     * 我的思维方式更像是迭代，将递归中的步骤表示出来了，
     *     public TreeNode trimBST(TreeNode root, int low, int high) {
     *         if (root == null) {
     *             return null;
     *         }
     *         if (root.val < low) {
     *             return trimBST(root.right, low, high);
     *         } else if (root.val > high) {
     *             return trimBST(root.left, low, high);
     *         } else {
     *             root.left = trimBST(root.left, low, high);
     *             root.right = trimBST(root.right, low, high);
     *             return root;
     *         }
     *     }
     * 我们看迭代方法
     *    public TreeNode trimBST(TreeNode root, int low, int high) {
     *         while (root != null && (root.val < low || root.val > high)) {
     *             if (root.val < low) {
     *                 root = root.right;
     *             } else {
     *                 root = root.left;
     *             }
     *         }
     *         if (root == null) {
     *             return null;
     *         }
     *         这种for循环的写法值得学习 这里跟链表的创建伪二叉树，将需要改变的在伪节点中改变
     *         for (TreeNode node = root; node.left != null; ) {
     *             if (node.left.val < low) {
     *                 node.left = node.left.right;
     *             } else {
     *                 在伪树中能够遍历，这个节点右边的是符合要求的，通过循环能左节点的值都符合要求，右节点同理
     *                 node = node.left;
     *             }
     *         }
     *         for (TreeNode node = root; node.right != null; ) {
     *             if (node.right.val > high) {
     *                 node.right = node.right.left;
     *             } else {
     *                 node = node.right;
     *             }
     *         }
     *         return root;
     *     }
     */
    public static void main(String[] args) {
        Integer[] ints = {3,2,4,1};
        TreeNode treeNode = TreeUtil.createTree(ints);
//        TreeNode treeNode1 = trimBST(treeNode, 1, 2);
        TreeNode treeNode1 = trimBST(treeNode, 1, 1);
        TreeUtil.prePrinTree(treeNode1);

    }
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }
        if(root != null && root.val < low){
            root = root.right;
            root = trimBST(root,low,high);
        }
        if(root != null && root.val > high){
            root = root.left;
            root = trimBST(root,low,high);
        }
        if (root == null) {
            return root;
        }
        if (root.left != null) {
            if(root.left.val < low ){
//                if (root.left.right != null) {
                    root.left = root.left.right;
//                }
            }
        }
        if (root.right != null) {
            if(root.right.val > high){
//                if (root.right.left != null) {
                    root.right = root.right.left;
//                }
            }
        }
        if (root.left != null) {
            root.left = trimBST(root.left, low, high);
        }
        if (root.right != null) {
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}
