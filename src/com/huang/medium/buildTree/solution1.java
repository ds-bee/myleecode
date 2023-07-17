package com.huang.medium.buildTree;

import com.huang.easy.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

import static com.huang.easy.util.TreeUtil.prePrinTree;

public class solution1 {
    public static void main(String[] args) {
        int[] arr1 = {3,9,20,15,7};
        int[] arr2 = {9,3,15,20,7};
        TreeNode treeNode = buildTree(arr1, arr2);
        prePrinTree(treeNode);

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode treeNode = new TreeNode();
        int a = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[0]){
                a = i;
            }
        }
        find(treeNode, preorder, inorder, 0, a, preorder.length);
        return treeNode;
    }

    private static void find(TreeNode treeNode, int[] preorder, int[] inorder, int start, int head, int end) {
        if(head >= end - 1){
            treeNode.val = inorder[head];
            return;
        }
        treeNode.val = inorder[head];
        int tem = 0;
        for(int i = start; i < end; i++){
            if(inorder[i] == preorder[start+1]){
                tem = i;
            }
        }
        int tem1 = 0;
        for(int i = head+1; i < end; i++){
            if(inorder[i] == preorder[head+1]){
                tem1 = i;
            }
        }
        treeNode.left = new TreeNode();
        treeNode.right = new TreeNode();
        find(treeNode.left,preorder,inorder,start+1,tem-1,head-1);
        find(treeNode.right,preorder,inorder,head,tem1,end);
    }
    static private Map<Integer, Integer> indexMap;

    public static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
    public static TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

}
