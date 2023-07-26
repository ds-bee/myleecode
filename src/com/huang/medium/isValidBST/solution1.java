package com.huang.medium.isValidBST;

import com.huang.easy.util.TreeNode;

import static com.huang.easy.util.TreeUtil.createTree;
import static com.huang.easy.util.TreeUtil.prePrinTree;

public class solution1 {
    public static void main(String[] args) {
//        Integer[] arr={2,1,3};
//        Integer[] arr={2,-1};
        Integer[] arr={32,26,47,19,null,null,56,null,27};
//        Integer[] arr={5,4,6,null,null,3,7};
        TreeNode tree = createTree(arr);
        System.out.println(isValidBST(tree, Long.MIN_VALUE, Long.MAX_VALUE));

    }
    public static boolean isValidBST(TreeNode root) {
        if(root == null ||( root.right == null && root.left == null)){
            return true;
        }
        boolean left = true;
        boolean right = true;
        if(root.left!= null){
            left = ljudge(root.left, root.val,root.val,0);
        }
        if(root.right!= null){
            right = rjudge(root.right, root.val,root.val,1);
        }
        return left && right;
    }
    public static boolean ljudge(TreeNode root, int provalue,int first,int lrjudge){
        if(lrjudge == 0 && root.val > first){
            return false;
        }
        if(lrjudge == 1 && root.val < first){
            return false;
        }
        if(root.left == null && root.right == null){
//            if(provalue > root.val && root.val > first){
            if(provalue > root.val ){
                return true;
            }else {
                return false;
            }
        }

        if(provalue > root.val){
            if(root.left!= null){
                boolean ljudge = ljudge(root.left, root.val,first,0);
                if(!ljudge){
                    return false;
                }
            }
            if(root.right!= null){
                boolean rjudge = rjudge(root.right, root.val,first,0);
                if(!rjudge){
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }

    public static boolean rjudge(TreeNode root, int provalue, int first,int rflag){
        if(rflag == 0 && root.val > first){
            return false;
        }
        if(rflag == 1 && root.val < first){
            return false;
        }
        if(root.left == null && root.right == null){
//            if(provalue < root.val && frist > root.val){
            if(provalue < root.val ){
                return true;
            }else {
                return false;
            }
        }

        if(provalue < root.val){
            if(root.left!= null){
                boolean ljudge = ljudge(root.left, root.val,first,1);
                if(!ljudge){
                    return false;
                }
            }
            if(root.right!= null){
                boolean rjudge = rjudge(root.right, root.val,first,1);
                if(!rjudge){
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }
    public static boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        //这句话的想法是确定当前遍历子树的上下界，如果左子树更小，这会减小下届，
        // 比如根节点为32，左节点为26，则遍历左节点就会更新上届为26
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }



}
