package com.huang.medium.lowestCommonAncestor;

import com.huang.easy.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static com.huang.easy.util.TreeUtil.createTree;
import static com.huang.easy.util.TreeUtil.prePrinTree;

public class Solution {
    public static void main(String[] args) {
        Integer[] arr={1,2,3,null,4};
        Integer[] arr1={5,4};
        Integer[] arr2={5,4};
        TreeNode tree = createTree(arr);
//        TreeNode tree1 = createTree(arr);
//        TreeNode tree2 = createTree(arr2);
        TreeNode treeNode = lowestCommonAncestor(tree, tree.right, tree.left.right);
        prePrinTree(treeNode);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list = new ArrayList<>();
        find(list, root);
        for (int i = 0; i < list.size() ; i++) {
            if((list.get(i ) == p || list.get(i ) == q)  ){
                List<TreeNode> list1 = new ArrayList<>();
                find(list1, list.get(i));
                if(list1.contains(list.get(i) == p?q:p)){
                    return list.get(i);
                }else {
                    return list.get(i - 1);
                }
//                if()
            }
//            if(list.get(i + 1) == p || list.get(i + 1) == q){
//                return list.get(i);
//            }

        }
        return null;
    }
    public static void find(List<TreeNode> list, TreeNode root){
        if(root == null){
            return ;
        }
        list.add(root);
        find(list, root.left);
        find(list, root.right);
    }


}
