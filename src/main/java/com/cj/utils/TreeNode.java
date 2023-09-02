package com.cj.utils;

/**
 * 树节点
 * Definition for a binary tree node.
 * @author CJ_CA
 * @date 2023/08/12
 */
public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }