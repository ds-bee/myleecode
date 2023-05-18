package com.huang.easy.sumOfLeftLeaves;

import com.huang.easy.util.TreeNode;
import com.huang.easy.util.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        //        Integer[] ints = {1,2,2,3,3,null,null,4,4};
//        Integer[] ints = {3,9,20,null,null,15,7};
//        Integer[] ints = {1,null,2,null,3};
        Integer[] ints = {1,2,3,4,5};
        TreeNode treeNode = TreeUtil.createTree(ints);
        System.out.println(sumOfLeftLeaves(treeNode));
    }

    static int num = 0;

    public static int sumOfLeftLeaves(TreeNode root) {
        Queue<Integer> integers = new LinkedList<>();
        Queue<TreeNode> treeNodes = new LinkedList<>();
        if(root != null){
            treeNodes.offer(root);
            integers.offer(root.val);
        }
        while (treeNodes == null){
            TreeNode poll = treeNodes.poll();
            if(root.left != null){
                treeNodes.offer(root.left);
            }
            if(root.right != null){
                treeNodes.offer(root.left);
            }


        }




        if (root == null) {
            return 0;
        }
        if(root.left == null){
            return 0;
        }
        num = root.left.val;
        return num + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public int sumOfLeftLeaves1(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    public int dfs(TreeNode node) {
        int ans = 0;
        //
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }


}
