package com.huang.easy.minDepthv1;

import com.huang.easy.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static com.huang.easy.util.TreeUtil.createTree;
import static com.huang.easy.util.TreeUtil.prePrinTree;

public class Solution {
    public static void main(String[] args) {
        Integer[] arr={2,9,3,null,4,null,5,null,6};
        TreeNode tree = createTree(arr);
        System.out.println(minDepth(tree));
//        prePrinTree(tree);
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }

//    public static int minDepth(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//        int len = Integer.MAX_VALUE;
//        int record = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            while (size>0){
//                TreeNode poll = queue.poll();
//                if(poll.left != null){
//                    queue.offer(poll.right);
//                }
//                if(poll.right != null){
//                    queue.offer(poll.right);
//                }
//                if(poll.left == null && poll.right == null){
//                    len = Math.min(len,record);
//                }
//                size--;
//            }
//            record++;
//        }
//        return len;
//    }




}
