package com.huang.easy.isSymmetric;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root.left ==null && root.right == null){
            return true;
        }
        boolean flag = true;
        List<Integer> justleft = justleft(root.left);
        List<Integer> justRight = justRight(root.right);
        if(justleft.size() == justRight.size()) {
            for (int i = 0; i < justleft.size(); i++) {
                if (justleft.get(i) != justRight.get(i) ){
                    flag = false;
                }
            }
        }
        return flag;
    }
    public static List<Integer> justleft(TreeNode node){
        ArrayList<Integer> list = new ArrayList<>();
        if(node == null){
            list.add(null);
        }
        if(node.left != null){
            justleft(node.left);
            list.add(node.left.val);
        }
        list.add(node.val);
        if(node.right != null){
            justleft(node.right);
            list.add(node.right.val);
        }
        return list;
    }
    public static List<Integer> justRight(TreeNode node){
        ArrayList<Integer> list = new ArrayList<>();
        if(node == null){
            return null;
        }
        if(node.right != null){
            justleft(node.right);
            list.add(node.right.val);
        }
        list.add(node.val);
        if(node.left != null){
            justleft(node.left);
            list.add(node.left.val);
        }
        return list;
    }


}

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