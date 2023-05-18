package com.huang.easy.postorderTraversal;

import com.huang.easy.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        if(root != null){
            back(integers, root);
        }
        return integers;

    }
    public static List<Integer> back(List<Integer> list, TreeNode root){
        if(root == null)return list;
        if(root.right != null){
            back(list, root.right);
        }
        list.add(root.val);
        if(root.left != null){
            back(list, root.left);
        }
        return list;
    }


}
