package com.huang.easy.isSymmetric;

import com.huang.easy.util.TreeNode;

import java.util.ArrayList;

import static com.huang.easy.util.TreeUtil.createTree;

public class solution2 {
    public static void main(String[] args) {
//        Integer[] arr={1,2,2,3,4,4,3};
//        Integer[] arr={1,2,2,2,null,2};
//        Integer[] arr={2,3,3,4,5,null,4};
//        Integer[] arr={1,null,2};
        Integer[] arr={1,2,3};
//        Integer[] arr={1,2,2,null,3,null,3};
        TreeNode tree = createTree(arr);
        System.out.println(isSymmetric(tree));
    }
    static boolean flag = false;

    public static boolean isSymmetric(TreeNode root) {
//        ArrayList<Integer> arrl = new ArrayList<>();
//        ArrayList<Integer> arrr = new ArrayList<>();
//        findl(root.left, arrl);
//        findr(root.right, arrr);
//        for (int i = 0; i < arrl.size(); i++) {
//            if(arrl.get(i) != arrr.get(i)){
//                return false;
//            }
//        }
        if(root == null || root.left == null && root.right == null){
            return true;
        }
        if(root.left != null && root.right != null){
            find(root.left, root.right);
            return flag;
        }
        return false;

//        return true;
    }

        public static void find(TreeNode rootleft,TreeNode rootright){
        if(rootleft == null && rootright == null){
            flag = true;
            return ;
        }
        if(rootleft.left != null && rootright.right != null){
            find(rootleft.left, rootright.right);
        }
        if(rootleft.left == null && rootright.right == null){
            find(rootleft.left, rootright.right);
        }
        if(rootleft.left != null && rootright.right == null || rootleft.left == null && rootright.right !=null){
            flag = false;
            return;
        }

        if(rootleft.val != rootright.val){
            flag = false;
            return ;
        }
        if(rootleft.right != null && rootright.left != null){
            find(rootleft.right, rootright.left);
        }
        if(rootleft.right == null && rootright.left == null){
            find(rootleft.right, rootright.left);
        }
        if(rootleft.right != null && rootright.left == null || rootleft.right == null && rootright.left !=null){
            flag = false;
        }

//        return false;
    }

//    public static void findl(TreeNode root, ArrayList<Integer> arrl){
//        if(root == null){
//            return;
//        }
//        findl(root.left, arrl);
//        arrl.add(root.val);
//        findl(root.right, arrl);
//    }
//    public static void findr(TreeNode root, ArrayList<Integer> arrr){
//        if(root == null){
//            return;
//        }
//        findl(root.right, arrr);
//        arrr.add(root.val);
//        findl(root.left, arrr);
//    }

    boolean dfs(TreeNode left, TreeNode right) {
        //递归的终止条件是两个节点都为空
        //或者两个节点中有一个为空
        //或者两个节点的值不相等
        if(left==null && right==null) {
            return true;
        }
        if(left==null || right==null) {
            return false;
        }
        if(left.val!=right.val) {
            return false;
        }
        //再递归的比较 左节点的左孩子 和 右节点的右孩子
        //以及比较  左节点的右孩子 和 右节点的左孩子
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }

}
