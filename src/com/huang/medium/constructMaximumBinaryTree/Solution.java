package com.huang.medium.constructMaximumBinaryTree;

import com.huang.easy.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static com.huang.easy.util.TreeUtil.createTree;
import static com.huang.easy.util.TreeUtil.prePrinTree;

public class Solution {
    public static void main(String[] args) {
        int[] arr={3,2,1,6,0,5};
//        TreeNode tree = createTree(arr);
        TreeNode treeNode = constructMaximumBinaryTree(arr);
        prePrinTree(treeNode);
    }
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode treeNode = new TreeNode();
        TreeNode max = findMax(nums,0, nums.length-1, treeNode);
        return max;

    }
    public static TreeNode findMax(int[] nums, int start, int end, TreeNode root){
        if(nums.length == 1){
            root.val = nums[0];
            return root;
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
//        int[] arr = Arrays.copyOfRange(nums,left,right);

        root.val = max;

        root.left = new TreeNode();
        if(index > start){
            findMax(Arrays.copyOfRange(nums,start,index),start, index - 1, root.left);
        }
        if(index == start){
            findMax(Arrays.copyOfRange(nums,index+1 ,end+1),index+1,end, root.left);
        }
        root.right = new TreeNode();
        if(index < end){
            findMax(Arrays.copyOfRange(nums,index + 1,end),index+1, end, root.right);
        }
        if(index == end){
            findMax(Arrays.copyOfRange(nums,start,index-1 ),start,index -1, root.left);
        }


        return root;
    }

}
