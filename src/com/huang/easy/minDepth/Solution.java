package com.huang.easy.minDepth;

import com.huang.easy.util.TreeNode;
import com.huang.easy.util.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 这道题我的问题点在于，我认为需要一个数来记录最小值但是没有头绪，代码写不出来
 * 还有个想法就是找到条件node.left == null && node.right == null这个就是最小的值出现的地方，同样不知道如何表示
 * 先看第一个深度优先，使用的是递归minDepth1、
 * 广度优先就是第二个方法条件做的看下面的理解
 */


public class Solution {
    public static void main(String[] args) {
        // TODO 這是使用數組創建二叉樹的例子
        Integer[] ints = {2,null,3,null,4,null,5,null,6};
        TreeNode tree = TreeUtil.createTree(ints);
        int i = minDepth3(tree);
        System.out.println(i);
    }

    public static class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    /**
     * 广度优先就好理解相对于深度优先，这里是引用的队列
     * 说明使用不同的数据结构对于解题十分关键，因为先遍历的肯定先出去，所以使用队列
     * 当然它自己还创建了一个QueueNode也不容易想到，用来记录深度，但应该可以不用这个结构来代替
     * 就是正常的思考逻辑了
     * 这个就是想找node.left == null && node.right == null这个条件，然后思考一层一层的找
     * 没找到，深度就加1，找到了就返回，思路其实挺清晰的，就是代码难写
     * @param root
     * @return
     */
    public static int minDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueNode> queue = new LinkedList<QueueNode>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }

        return 0;
    }
    /**
     * Integer.MAX_VALUE这个写出来能装包，代表一个无线大的值，这个其实不好想到
     * Math.min(minDepth(root.left), min_depth)这里使用的三个值比较，就能得到最小的值了，
     * 与最大深度不同，这个也没有在return语句中＋1
     * 是最后在min_depth这个上面加1的，通过递归来迭代
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
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

//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/minimum-depth-of-binary-tree/solution/er-cha-shu-de-zui-xiao-shen-du-by-leetcode-solutio/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
     if(root.left == null && root.right == null){
         return 0;
     }else if(root.left == null){
         minDepth(root.right);
     }else if(root.right == null){
         minDepth(root.left);
     }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


}
