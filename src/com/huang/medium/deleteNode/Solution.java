package com.huang.medium.deleteNode;

import com.huang.easy.util.TreeNode;

import java.util.Stack;

import static com.huang.easy.util.TreeUtil.createTree;
import static com.huang.easy.util.TreeUtil.prePrinTree;

public class Solution {
    public static void main(String[] args) {
        Integer[] arr={5,3,6,2,4,null,7};
        TreeNode tree = createTree(arr);
        TreeNode treeNode = deleteNode(tree, 5);
        prePrinTree(treeNode);
    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if(root.left == null && root.right == null){
            if(root.val == key){
                return null;
            }else {
                return root;
            }
        }
        TreeNode record = new TreeNode();
        TreeNode record1 = new TreeNode();
        TreeNode record2 = new TreeNode();

//        if(root.val < key){
//            root
//        }

        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);
        while (!treeNodeStack.isEmpty()) {
            TreeNode pop = treeNodeStack.pop();
            if (pop.val > key) {
                if (pop.left != null) {
                    record = pop;
                    treeNodeStack.push(pop.left);
                } else {
                    return root;
                }
            }
            if (pop.val < key) {
                if (pop.right != null) {
                    record = pop;
                    treeNodeStack.push(pop.right);
                } else {
                    return root;
                }
            }
            if (pop.val == key) {
                record1 = pop.left;
                record2 = pop.right;
//                if(record1==null &&record2==null){
//                    return record;
//                }
                if(key < record.val){
                    if(record1 == null){
                        record.left = record2;
                    }
                    if(record2 == null){
                        record.left = record1;
                    }
                    record.left = record2;
                    while (record2.left != null){
                        record2 = record2.left;
                    }
                    record2.left = record1;
                }
                if(key > record.val){
                    if(record1 == null){
                        record.right = record2;
                    }
                    if(record2 == null){
                        record.right = record1;
                    }
                    record.right = record1;
                    while (record1.right != null){
                        record1 = record1.right;
                    }
                    record1.right = record2;
                }
            }
        }
        return root;
    }
//    public static

}
