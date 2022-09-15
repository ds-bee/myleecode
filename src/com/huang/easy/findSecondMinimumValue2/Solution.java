package com.huang.easy.findSecondMinimumValue2;

import com.huang.easy.util.TreeNode;
import com.huang.easy.util.TreeUtil;

public class Solution {
    //这个题的题解使用

    /**
     *     int ans; //使用这个不使用static就能避免leetcode中测试产生的问题，就是一个例子能通过但是很多个例子不能通过
     *     int rootvalue;
     *
     *     public int findSecondMinimumValue(TreeNode root) {
     *         ans = -1;
     *         rootvalue = root.val;
     *         dfs(root);
     *         return ans;
     *     }
     *
     *     public void dfs(TreeNode node) { //这题的关键在这里 dfs可以不返回值，在dfs中将设定的值进行更新就行
     *         if (node == null) {
     *             return;
     *         }
     *         if (ans != -1 && node.val >= ans) {
     *             return;
     *         }
     *         if (node.val > rootvalue) {
     *             ans = node.val;
     *         }
     *         dfs(node.left);
     *         dfs(node.right);
     *     }
     * @param args
     */
    public static void main(String[] args) {
        Integer[] ints = {2,2,5,null,null,5,5};
        TreeNode treeNode = TreeUtil.createTree(ints);
        System.out.println(findSecondMinimumValue(treeNode));
    }
    static int result;
    public static int findSecondMinimumValue(TreeNode root) {
        int a = 0,b=0;
        if(root == null){
            return -1;
        }
        int i = find(root);
        if (find(root) != -1) {
            return i;
        }
        if (findSecondMinimumValue(root.left) != -1) {
             a = findSecondMinimumValue(root.left);
        }
        if(findSecondMinimumValue(root.right) != -1){
             b = findSecondMinimumValue(root.right);
        }
        if(a != b){
            return Math.max(a,b);
        }

        return -1;

    }

    public static int find(TreeNode root){
        if(root == null){
            return -1;
        }
        if(root.left != null ){
            if(root.left.val > root.val ){
                return root.left.val;
            }
            if(root.right.val > root.val){
                return root.right.val;
            }
        }
        return -1;
    }

}
