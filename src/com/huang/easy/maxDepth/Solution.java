package com.huang.easy.maxDepth;


import com.huang.easy.util.TreeNode;

import static com.huang.easy.util.TreeUtil.createTree;
import static com.huang.easy.util.TreeUtil.prePrinTree;

public class Solution {
    public static void main(String[] args) {
        Integer[] arr={5,4};
        TreeNode tree = createTree(arr);
        int i = maxDepth(tree);
        System.out.println(i);
//        prePrinTree(tree);

    }

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int recordlen = 0, truthlen = 0;
        int i = recordDepth(recordlen, truthlen, root);
        return i;

//        return length;
    }
    public static int recordDepth(int recordlen, int truthlen, TreeNode root){
        if(root == null){
            return recordlen;
        }
        if(truthlen > recordlen){
            recordlen = truthlen;
        }
        if(root.left != null){
            recordlen = recordDepth(recordlen, truthlen + 1, root.left);
        }
        if(root.right != null){
            recordlen = recordDepth(recordlen, truthlen + 1, root.right);
        }
        return recordlen;
    }


}
