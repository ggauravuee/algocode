package com.leetcode.problem.logic.medium.tree;

// Valid Binary Search Tree - https://www.youtube.com/watch?v=yEwSGhSsT0U
/*
https://leetcode.com/problems/validate-binary-search-tree/

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Input: [2,1,3]
Output: true


Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's val is 5 but its right child's val is 4.

 */

public class BinaryTreeHelper
{
//  TreeNode root;

/*  public BinaryTreeHelper(TreeNode root)
  {
    this.root = root;
  }*/

  public boolean isValidBST(TreeNode root)
  {
    return isValidBST(root, null,null);
  }

  private boolean isTreeBST(TreeNode node, Integer lowerValue, Integer upperValue){
    if (node == null) return true;
//    if (node.val <= lowerValue || node.val > upperValue ) return false;
    if (lowerValue != null && node.val <= lowerValue) return false;
    if (upperValue != null && node.val >= upperValue ) return false;

    return isValidBST(node, lowerValue, upperValue);
  }

  private boolean isValidBST(TreeNode node, Integer lowerValue, Integer upperValue)
  {
    if (node == null) return true;

    int value = node.val; //20

    if (!isTreeBST(node.left, lowerValue, value))
      return false;

    if (!isTreeBST(node.right, value, upperValue))
      return false;

    return Boolean.TRUE;
  }

}

class TreeNode
{
  int val;
  TreeNode left;
  TreeNode right;

  public TreeNode(int value)
  {
    this.val = value;
    this.left = null;
    this.right =null;
  }

/*  public TreeNode(int value, TreeNode left, TreeNode right)
  {
    this.val = value;
    this.left = left;
    this.right = right;
  }*/
}
