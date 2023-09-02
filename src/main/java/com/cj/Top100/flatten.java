package com.cj.Top100;

import com.cj.utils.TreeNode;

public class flatten {
    static TreeNode root = new TreeNode(1);
    static TreeNode root_r = new TreeNode(5);

    static {
        TreeNode root_left = new TreeNode(2);
        root.left=root_left;
        root_left.left=new TreeNode(3);
        root_left.right=new TreeNode(4);
        root.right = root_r;
        root_r.right = new TreeNode(6);
    }
    public static void main(String[] args) {
       TreeNode list = new TreeNode();
        add(list, root);
        //这里不能直接给root赋值，因为root是传过来的
        if(root!=null){
            root.right=list.right;
            root.left=null;
        }

        while (root!=null){
            System.out.println(root.val);
            root=root.right;
        }
    }

    public static TreeNode add(TreeNode list, TreeNode treeNode) {
        if(treeNode==null) {
            return list;
        }
        list.val=treeNode.val;

        if(treeNode.left!=null) {
            list.right=new TreeNode();
            list= add(list.right, treeNode.left);
        }

        if(treeNode.right!=null) {
            list.right=new TreeNode();
            list=add(list.right, treeNode.right);
        }
        return list;
    }
}
