package com.cj.Top100;

import com.cj.utils.TreeNode;

import java.util.ArrayList;

/**
 * 中序遍历
 *
 * @author CJ_CA
 * @date 2023/08/12
 */
public class inorderTraversal {

    static TreeNode root = new TreeNode(1);
    static TreeNode root_r = new TreeNode(2);

    static {
        root.right = root_r;
        root_r.left = new TreeNode(3);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        add(list, root);
        list.forEach(v -> {
            System.out.print(v + " ");
        });
    }

    public static ArrayList<Integer> getInorder(TreeNode treeNode){
        root=treeNode;
        ArrayList<Integer> list = new ArrayList<>();
        add(list, root);
        return list;
    }

    public static void PrintInorder(ArrayList<Integer> list){
        list.forEach(v -> {
            System.out.print(v + " ");
        });
    }

    public static void add(ArrayList<Integer> list, TreeNode treeNode) {
        if (treeNode.left != null) {
            add(list, treeNode.left);
        }
        list.add(treeNode.val);
        if (treeNode.right != null) {
            add(list, treeNode.right);
        }
    }
}
