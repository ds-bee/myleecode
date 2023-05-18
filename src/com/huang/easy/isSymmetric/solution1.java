package com.huang.easy.isSymmetric;

import com.huang.easy.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static com.huang.easy.util.TreeUtil.createTree;
import static com.huang.easy.util.TreeUtil.prePrinTree;

public class solution1 {
    public static void main(String[] args) {
//        Integer[] arr={1,2,2,null,3,null,3};
        Integer[] arr={1,2,2,3,4,4,3};
        TreeNode tree = createTree(arr);
        boolean symmetric = isSymmetric(tree);
        System.out.println(symmetric);
//        prePrinTree(tree);

    }
    public static boolean isSymmetric(TreeNode root) {
        if(root == null ){
            return false;
        }
//        TreeNode treeNode1 = root.left;
//        TreeNode treeNode2 = root.right;
//        Stack<TreeNode> treeleft = new Stack<>();
//        Stack<TreeNode> treeright = new Stack<>();
        Queue<TreeNode> treeNodeStackleft = new LinkedList<>();
        Queue<TreeNode> treeNodeStackright = new LinkedList<>();
//        if(root.left != null){
//            treeNodeStack.push(root.left);
//        }
//        if(root.right != null){
//            treeNodeStack.push(root.right);
//        }
        treeNodeStackleft.add(root.left);
        treeNodeStackright.add(root.right);
//        addleft(treeNodeStack, root);
        boolean flag = true;
        while (!treeNodeStackleft.isEmpty() ){
            TreeNode popleft = treeNodeStackleft.poll();
            TreeNode popright = treeNodeStackright.poll();
//            if(!(popright == popleft || popleft.val == popright.val)){
//                flag = false;
//                break;
//            }
            if(popleft != null && popright != null || popleft == popright ){
                if(popleft.val != popright.val){
                    flag = false;
                    break;
                }
            }else {
                return false;
            }
            if(popleft != null){
                addleft(treeNodeStackleft,popleft);
                addright(treeNodeStackright,popright);
            }

        }
        return flag;
    }

    public static void addleft(Queue<TreeNode> treeNodeStack , TreeNode root ){
//        if(root.left != null){
            treeNodeStack.add(root.left);
//        }
//        if(root.right != null){
            treeNodeStack.add(root.right);
//        }
    }
    public static void addright(Queue<TreeNode> treeNodeStack , TreeNode root ){
//        if(root.left != null){
        treeNodeStack.add(root.right);
//        }
//        if(root.right != null){
        treeNodeStack.add(root.left);
//        }
    }


//    public static boolean judge(TreeNode treeNode1, TreeNode treeNode2){
//        //        if(treeNode1 == null && treeNode2 == null ){
////            return true;
////        }
//
//
////        if(treeNode1 == null && treeNode2 == null ){
////            return true;
////        }
////        assert treeNode1 != null;
////        if(treeNode1.val == treeNode2.val ){
////            return true;
////        }
//////        if(treeNode1.left != null){
//////        }
//////        assert treeNode1 != null;
////        TreeNode tem1 = treeNode1.left;
////        TreeNode tem2 = treeNode1.right;
////        TreeNode tem3 = treeNode2.left;
////        TreeNode tem4 = treeNode2.right;
////        boolean judge1 = true;
////        boolean judge2 = true;
////        if(tem1 != null && tem4!=null ){
////            judge1 = judge(tem1, tem4);
////        }
////        if(tem2 != null && tem3!=null ){
////            judge2 = judge(tem2, tem3);
////        }
////        return judge1&&judge2;
//////        return judge(tem1, tem4) && judge(tem2,tem3);
//    }

}
