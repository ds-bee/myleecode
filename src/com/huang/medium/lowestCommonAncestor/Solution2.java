//package com.huang.medium.lowestCommonAncestor;
//
//import com.huang.easy.util.TreeNode;
//
//public class Solution2 {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root == null || root == p || root == q){
//            return root;
//        }
//        if(root.val > p.val && root.val > q.val){
//            TreeNode left = lowestCommonAncestor(root.left, p, q);
//        }
//        if(root.val < p.val && root.val < q.val ){
//            TreeNode right = lowestCommonAncestor(root.right, p, q);
//        }
////        if(left != null && right != null){
////            return root;
////        }else if(left != null){
////            return left;
////        }else if(right != null){
////            return right;
////        }else {
////            return null;
////        }
//    }
//}
