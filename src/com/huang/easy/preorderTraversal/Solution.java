package com.huang.easy.preorderTraversal;

import com.huang.easy.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.huang.easy.util.TreeUtil.createTree;
import static com.huang.easy.util.TreeUtil.prePrinTree;

public class Solution {
    public static void main(String[] args) {
        Integer[] arr={1,null,2,3};
        TreeNode tree = createTree(arr);
        List<Integer> integers = preorderTraversal(tree);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }

//        prePrinTree(tree);

    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            integers.add(pop.val);
            if(pop.right != null) stack.push(pop.right);
            if(pop.left != null) stack.push(pop.left);
        }
//        forword(integers, root);
        return integers;
    }
//    public static List<Integer> forword(List<Integer> list, TreeNode root){
//        if(root == null){
//            return list;
//        }
//        list.add(root.val);
//        if(root.left != null){
////            preorderTraversal(root.left);
//            forword(list,root.left);
//        }
//        if(root.right != null){
////            preorderTraversal(root.right);
//            forword(list,root.right);
//        }
//        return list;
//    }
}
