package com.huang.medium.levelOrder;

import com.huang.easy.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class solution {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arrs = new ArrayList<>();
//        List<Integer> arr = new ArrayList<>();
//        int[] a = {};
//        int  b = a.length;
        find(arrs, 0, root);
        return arrs;
    }
    public static void find(List<List<Integer>> arrs,  int level,TreeNode root){
        if(root == null){
            return;
        }
        if(level> arrs.size() - 1){
            arrs.add(new ArrayList<>());
        }
        List<Integer> list = arrs.get(level);
        list.add(root.val);
        find(arrs,level+1,root.left);
        find(arrs,level+1,root.right);
    }
    //看看递归的终止条件，这里有些模糊了
    public static int findlevel(TreeNode root , int level,int max){
        if(root == null){
            return max;
        }
        if(level > max){
            max = level;
        }
        findlevel(root.left,level+1,max);
        findlevel(root.left,level+ 1,max);
        return max;
    }


}
