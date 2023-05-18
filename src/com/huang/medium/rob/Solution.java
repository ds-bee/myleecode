package com.huang.medium.rob;

import com.huang.easy.util.TreeNode;
import com.huang.easy.util.TreeUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static void main(String[] args) {
        //        Integer[] ints = {1,2,2,3,3,null,null,4,4};
//        Integer[] ints = {3,9,20,null,null,15,7};
        Integer[] ints = {4,1,null,2,null,3};
//        Integer[] ints = {3,2,3,null,3,null,1};
        TreeNode treeNode = TreeUtil.createTree(ints);
        System.out.println(rob(treeNode));
    }
    public static int rob(TreeNode root) {

        int count = 1,odd = 0 , even = 0;
        HashMap<TreeNode, Integer> nodeIntegerHashMap = new HashMap<>();
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        nodeIntegerHashMap.put(root,count);
        while (!treeNodes.isEmpty()){
            TreeNode poll = treeNodes.poll();
            Integer num = nodeIntegerHashMap.get(poll);
            if(poll.left != null){
                treeNodes.offer(poll.left);
                nodeIntegerHashMap.put(poll.left, num + 1);
            }
            if(poll.right != null){
                treeNodes.offer(poll.right);
                nodeIntegerHashMap.put(poll.right,num + 1);
            }
        }
        for (Map.Entry<TreeNode, Integer> entry : nodeIntegerHashMap.entrySet()) {
            for (Map.Entry<TreeNode, Integer> entry1 : nodeIntegerHashMap.entrySet()) {
                    if(entry1.getValue() - entry.getValue() > 1){

                    }

            }

        }
        int max = Math.max(odd, even);
        return max;
    }
    public static boolean judge(HashMap<TreeNode, Integer> nodeIntegerHashMap,TreeNode node1, TreeNode node2){
        return (nodeIntegerHashMap.get(node1) - nodeIntegerHashMap.get(node2)) > 1;
    }


}
