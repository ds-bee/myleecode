package com.huang.medium.rob;

import com.huang.easy.util.TreeNode;

import java.util.*;

import static com.huang.easy.util.TreeUtil.createTree;

public class Solution3 {
    public static void main(String[] args) {
//        Integer[] arr={3,2,3,null,3,null,1};
        Integer[] arr={2,1,3,null,4};
        TreeNode tree = createTree(arr);
        System.out.println(rob(tree));

    }
    public static int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.right == null && root.left == null){
            return root.val;
        }
        HashMap<TreeNode, Integer> treeNodeIntegerHashMap = new HashMap<>();

        int level = findlevel(root, treeNodeIntegerHashMap ,0);
        int[] dp = new int[level ];
        dp[0] = root.val;
        dp[1] = find(root);

        for (int i = 2; i < level; i++) {
            List<TreeNode> treeNodes = new ArrayList<>();
            for(Map.Entry<TreeNode, Integer> entry: treeNodeIntegerHashMap.entrySet()){
                if(entry.getValue() == i){
                    treeNodes.add(entry.getKey());
                }
            }
            int record = 0;
//            treeNodeIntegerHashMap.containsValue(i)
            for (int i1 = 0; i1 < treeNodes.size(); i1++) {
                record = record + treeNodes.get(i1).val;
            }
            dp[i] = Math.max(dp[i-1], dp[i-2] + record);
        }
        return dp[level-1];
    }
    public static int find(TreeNode root){
        int sum = 0;
        if(root.left != null){
            sum = sum + root.left.val;
        }
        if(root.right != null){
            sum = sum + root.right.val;
        }
        return Math.max(sum, root.val);
    }
    public static int findlevel(TreeNode treeNode,HashMap<TreeNode, Integer> treeNodeIntegerHashMap, int level){
        if(treeNode == null){
            return level;
        }
        treeNodeIntegerHashMap.put(treeNode,level);
        return Math.max(findlevel(treeNode.left,treeNodeIntegerHashMap,level+1), findlevel(treeNode.right,treeNodeIntegerHashMap,level+ 1));
    }

}
