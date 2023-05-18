package com.huang.easy.binaryTreePaths;

import com.huang.easy.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static com.huang.easy.util.TreeUtil.createTree;

public class Solution {
    public static void main(String[] args) {
        Integer[] arr={1,2,3,null,5};
        TreeNode tree = createTree(arr);
        List<String> list = binaryTreePaths(tree);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return null;
        }
        List<String> list = new ArrayList<>();
        String string = new String();
        List<String> findlistleft = findlistleft(list, string, root);
        return findlistleft;

    }

    public static List<String>  findlistleft(List<String> list, String s, TreeNode root){
        if(root == null){
            return list;
        }
        if(root.left == null && root.right == null){
            s = s + root.val;
        }else {
            s = s +root.val + "->";
        }
        if(root.left!=null){
            findlistleft(list, s, root.left);
        }
        if(root.right != null){
            findlistleft(list, s, root.right);
        }
        if(root.left == null && root.right == null){
            list.add(s);
        }
        return list;
    }

//    public static String findlistright(List<String> list, String s, TreeNode root){
//        if(root == null){
//            return s;
//        }
//        if(root.left == null && root.right == null){
//            list.add(s);
//        }
//        s = String.valueOf(root.val) + "->";
//        if(root.left!=null){
//            findlistleft(list, s, root.left);
//        }
//        if(root.right != null){
//            findlistright(list, s, root.right);
//        }
//        return s;
//    }


}
