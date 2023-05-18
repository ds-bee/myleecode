package com.huang.easy.mergeTrees;

import com.huang.easy.util.TreeNode;

import static com.huang.easy.util.TreeUtil.createTree;
import static com.huang.easy.util.TreeUtil.prePrinTree;

public class Solution {
    public static void main(String[] args) {
        Integer[] arr={1,3,2,5};
        Integer[] arr1={2,1,3,null,4,null,7};
        TreeNode tree = createTree(arr);
        TreeNode tree1 = createTree(arr1);
        TreeNode treeNode = mergeTrees(tree, tree1);
        prePrinTree(treeNode);


    }
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root2 == null && root1 == null){
            return null;
        }
        TreeNode treeNode = new TreeNode();
        if(root1 != null && root2 == null){
            return root2;
        } else if(root2 != null && root1 == null){
            root1.val = root1.val + root2.val;
        }else {

        }
//        assert root2 != null;
        root1 = mergeTrees(root1.left,root2.left);
        root1 = mergeTrees(root1.right,root2.right);
        return root1;
    }

//    public static TreeNode add(TreeNode root1, TreeNode root2, TreeNode root3){
//        if ()
////        assert root2 != null;
//        if(root1.left!=null && null!=root2.left ){
//            root1.left = mergeTrees(root1.left,root2.left);
//        }
//        if(root1.left==null && null!=root2.left){
//            root1.left = mergeTrees(null,root2.left);
//        }
//        if(root1.left!=null && null!=root2.left){
//            root1.left = mergeTrees(root1.left,null);
//        }
//        if(root1.right!=null && null!=root2.right){
//            root1.right = mergeTrees(root1.right,root2.right);
//        }
//        if(root1.right==null && null!=root2.right){
//            root1.right = mergeTrees(null,root2.right);
//        }
//        if(root1.right!=null && null!=root2.right){
//            root1.right = mergeTrees(root1.right,null);
//        }
//    }

}
