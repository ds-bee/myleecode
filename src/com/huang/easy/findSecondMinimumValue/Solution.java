package com.huang.easy.findSecondMinimumValue;

import com.huang.easy.util.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Solution {
    static ArrayList<Integer>  nums = new ArrayList<Integer>();

    public static void main(String[] args) {

    }
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        Collections.sort(nums);
        if(nums.get(nums.size()-1) > nums.get(nums.size() -2)){
            return nums.get(nums.size() -2);
        }
        return -1;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left != null){
            dfs(root.left);
        }
        if(root.right != null){
            dfs(root.right);
        }
        if (root.left == null&& root.right == null) {
            nums.add(root.val);
        }
    }

}
