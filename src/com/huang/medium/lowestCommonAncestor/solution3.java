package com.huang.medium.lowestCommonAncestor;

import com.huang.easy.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import static com.huang.easy.util.TreeUtil.createTree;
import static com.huang.easy.util.TreeUtil.prePrinTree;

public class solution3 {
    public static void main(String[] args) {
        Integer[] arr={3,5,1,6,2,0,8,null,null,7,4};
        Integer[] arr1={5,6,2,null,null,7,4};
        Integer[] arr2={4};
        TreeNode tree = createTree(arr);
//        TreeNode tree1 = createTree(arr);
//        TreeNode tree2 = createTree(arr2);
        TreeNode treeNode = lowestCommonAncestor(tree, tree.right, tree.left);
//        TreeNode treeNode = lowestCommonAncestor(tree, tree.left, tree.left.right.right);
        prePrinTree(treeNode);


    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        boolean flaglist = false;
        HashSet<Integer> set = new HashSet<>();
        boolean flagset = false;
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode tem = root.left;
        treeNodeStack.push(tem);
        while (!treeNodeStack.isEmpty()){
            TreeNode pop = treeNodeStack.pop();
            if(pop.val == p.val){
                treeNodes.add(pop);
                flaglist = true;
            }
            if(pop.val == q.val){
                set.add(pop.val);
                flagset = true;
            }
            if(!flaglist){
                treeNodes.add(pop);
            }
            if(!flagset){
                set.add(pop.val);
            }
            if(pop.right != null){
                treeNodeStack.push(pop.right);
            }
            if(pop.left != null){
                treeNodeStack.push(pop.left);
            }
//            if(!flaglist && !flagset){
//                break;
//            }
        }
        for (int i = treeNodes.size() - 1; i >= 0; i--) {
            if(set.contains(treeNodes.get(i).val) && flaglist && flagset){
                return treeNodes.get(i);
            }
        }
        return root;
    }

    /**
     *
     */
    private TreeNode ans;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        //这里传入的是左节点
        boolean lson = dfs(root.left, p, q);
        //这里传入的是右节点 通过递归判断左右节点是否满足条件
        //(root.val == p.val || root.val == q.val) && (lson || rson) 这里是左右节点存在 且当前节点满足某一个子节点
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }




}
