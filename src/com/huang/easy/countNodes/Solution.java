package com.huang.easy.countNodes;

import com.huang.easy.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
//    public int countNodes(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//        int record = 0;
//        Queue<TreeNode> treeNodes = new LinkedList<>();
//        treeNodes.offer(root);
//        while (!treeNodes.isEmpty()){
//            int size = treeNodes.size();
//            while (size > 0 ){
//                TreeNode poll = treeNodes.poll();
//                record++;
//                if(poll.left != null){
//                    treeNodes.add(poll.left);
//                }
//                if(poll.right != null){
//                    treeNodes.add(poll.right);
//                }
//                size--;
//            }
//        }
//        return record;
//    }

//    public int countNodes(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//        int record = 0;
//        int sum = 0;
//        TreeNode tem = root;
//        while (tem != null){
//            tem = tem.left;
//            record++;
//        }
//        for (int i = 0; i < record - 1; i++) {
//            sum = sum + i*i;
//        }
//        tem =root;
//        int i = 1;
//        while (!(tem.right != null && tem.left != null) ){
//            int size = i*i;
//            while (size > 0 ){
//
//            }
//            i++;
//        }
//
//        }
//
//
//
//        return record;
//    }

}
