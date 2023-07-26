package com.huang.medium.flatten;

import com.huang.easy.util.TreeNode;

import static com.huang.easy.util.TreeUtil.createTree;
import static com.huang.easy.util.TreeUtil.prePrinTree;

public class solution {
    public static void main(String[] args) {
        Integer[] arr={1,2,5,3,4,null,6};
//        Integer[] arr={1,2};
//        Integer[] arr={1,null,2};
//        Integer[] arr={1,null,2,3};
        TreeNode tree = createTree(arr);
        flatten(tree);
        prePrinTree(tree);
    }
    public static void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        change(root);
//        if(root.right != null){
//            change(root.right);
//        }
    }
    public static void change(TreeNode root){
        if(root == null){
            return;
        }
        change(root.left);
        if(root.right != null){
            TreeNode tem = root.right;
//            if(root.left != null){
//
//            }
            root.right = root.left;
            root.left = null;
            TreeNode tem1 =root;
            if(tem1.right!= null) {
                while (tem1.right != null) {
                    if (tem1.right.right == null) {
                        tem1.right.right = tem;
                        break;
                    }
                    tem1 = tem1.right;
                }
            }else {
                root.right = tem;
            }
        }else {
            root.right = root.left;
            root.left = null;
        }
        change(root.right);

    }


}
