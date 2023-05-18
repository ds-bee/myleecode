package com.huang.easy.getMinimumDifference;

import com.huang.easy.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.huang.easy.util.TreeUtil.createTree;

public class Solution {
    public static void main(String[] args) {
        Integer[] arr={543,384,652,null,445,null,699};
        TreeNode tree = createTree(arr);

    }

    public static int getMinimumDifference(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> integers = find(list, root);
        int record = Integer.MAX_VALUE;
        for (int i = 0; i < integers.size() - 1; i++) {
            Integer integer1 = integers.get(i);
            Integer integer2 = integers.get(i + 1);
            if(record > integer2 - integer1){
                record = integer2 - integer1;
            }

        }
        return record;

    }
    public static List<Integer> find(List<Integer> list, TreeNode root){
        if(root == null){
            return list;
        }
        find(list, root.left);
        list.add(root.val);
        find(list, root.right);
        return list;

    }

}
