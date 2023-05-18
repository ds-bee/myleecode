package com.huang.easy.findBottomLeftValue;

import com.huang.easy.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static com.huang.easy.util.TreeUtil.createTree;

public class Solution {
    public static void main(String[] args) {
        Integer[] arr={1,null,1};
        TreeNode tree = createTree(arr);
        System.out.println(findBottomLeftValue(tree));
    }
    public static int findBottomLeftValue(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int record = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            boolean flag = true;
            int size = queue.size();
            while (size > 0){
                TreeNode poll = queue.poll();
                if(poll.left != null){
                    queue.add(poll.left);
                    if(poll.left.left == null && poll.left.right == null && flag == true){
                        record = poll.left.val;
                        flag = false;
                    }
                }
                if(poll.right != null){
                    queue.add(poll.right);
                    if(poll.right.left == null && poll.right.right == null && flag == true){
                        record = poll.right.val;
                        flag = false;
                    }
                }
                size--;
            }
//            record++;
        }
        return record;
    }
}
