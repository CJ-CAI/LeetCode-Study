package com.cj.Top100;

import com.cj.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 构建树
 *
 * @author CJ_CA
 * @date 2023/08/16
 */
public class buildTree {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        if (preorder == null) {
            System.out.println(0);
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int inorder_index = 0;

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
            if (node.val != inorder[inorder_index]) {
                node.left=new TreeNode(preorder[i]);
                stack.push(node.left);
            } else {
                //重点在此处peek和poll的搭配用法
                while (!stack.isEmpty()&&stack.peek().val==inorder[inorder_index]){
                    node=stack.poll();
                    inorder_index++;
                }
                node.right=new TreeNode(preorder[i]);
                stack.push(node.right);
            }
        }

        ArrayList<Integer> list = inorderTraversal.getInorder(root);
        inorderTraversal.PrintInorder(list);


    }

}
