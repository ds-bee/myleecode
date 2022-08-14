package com.huang.easy.inorderTraversal;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {

    static List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

//        if(root.right == null){
//            return list;
//        }
        if(root == null){
            return list;
        }

        rightlistAll(root.left);
        list.add(root.val);
        rightlistAll(root.right);

//        if(root != null){
//            rightlistAll(root);
//
//
//        }
//        if(root.left != null) {
//            inorderTraversal(root.left);
//            list.add(root.val);
//            if(root.left != null){
//                list.add(root.left.val);
//            }
//            if(root.right != null){
//                list.add(root.right.val);
//            }
//        }
//        list.add(root.val);
//        if (root.right != null){
//            inorderTraversal(root.right);
//        }
        return list;
    }

    public void rightlistAll(TreeNode root) {
        if (root.left != null) {
            rightlistAll(root.left);
            list.add(root.left.val);
        }
        list.add(root.val);
            if (root.right != null) {
                rightlistAll(root.right);
                list.add(root.right.val);
            }
        }
}



