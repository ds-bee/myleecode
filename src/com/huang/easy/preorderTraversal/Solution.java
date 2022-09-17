package com.huang.easy.preorderTraversal;

import com.huang.easy.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 使用广度优先遍历二叉树能达到不使用迭代的效果
 * 但是能达到遍历某一个节点的效果
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        list.add(root.val);
//        while (root.left != null){
////            list.add(root)
//        }
        Queue<TreeNode> queue = new LinkedList<>();
        while (queue.isEmpty()){
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            if (poll.left != null) {
                queue.offer(poll.left);
            }
        }
        return list;

    }


}
