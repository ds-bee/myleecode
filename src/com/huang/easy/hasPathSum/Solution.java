package com.huang.easy.hasPathSum;

import com.huang.easy.util.TreeNode;
import com.huang.easy.util.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;


public class Solution {

    public static void main(String[] args) {
//        Integer[] ints = {1,2,2,3,3,null,null,4,4};
//        Integer[] ints = {3,9,20,null,null,15,7};
//        Integer[] ints = {1,null,2,null,3};
        Integer[] ints = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode treeNode = TreeUtil.createTree(ints);
        boolean b = hasPathSum(treeNode, 22);
        System.out.println(b);
    }
    public static boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        } else {
            targetSum = targetSum - root.val;
            if (root.left != null) {
                /**
                 这里递归为什么直接就返回flase了，是因为hasPathSum(root.left, targetSum)这个函数最终返回的就是FALSE，然后是在最初一层return结束的函数，实际就是
                 只遍历了左子树就直接返回了
                 static int Sum(int n)
                 {
                 if (n <= 1)                  //#1
                 return n;                //#2
                 return n+Sum(n - 1);         //#3
                 }
                比如这里是return的 n + sum（n - 1） ，sum（n - 1）又得到了另外一个值 n-1 + sum（n - 2）

                 所以这里的题解使用
                 return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
                 传入一个节点，既能向左走，又能向右走
                 */
                //其他的一直调用是
                return hasPathSum(root.left, targetSum);
            } else if (root.right != null) {

                return  hasPathSum(root.right, targetSum);
            }
            if (targetSum == 0) {
                return true;
            }
            return false;
        }
    }


}
