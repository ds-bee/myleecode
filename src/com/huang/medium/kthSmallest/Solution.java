package com.huang.medium.kthSmallest;

import com.huang.easy.util.TreeNode;
import com.huang.easy.util.TreeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Integer[] ints = {3,1,4,null,2};
        TreeNode treeNode = TreeUtil.createTree(ints);
        System.out.println(kthSmallest(treeNode, 1));
    }
    static ArrayList<Integer> list = new ArrayList<>();
    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        dfs(root);
        Collections.sort(list);
        return list.get(k);
    }

    private static void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        list.add(root.val);
        if(root.left != null){
            dfs(root.left);
        }
        if(root.right != null){
            dfs(root.right);
        }
    }

}
