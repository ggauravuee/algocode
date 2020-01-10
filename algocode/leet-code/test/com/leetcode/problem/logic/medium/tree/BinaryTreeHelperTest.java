package com.leetcode.problem.logic.medium.tree;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeHelperTest
{
  private static BinaryTreeHelper binaryTreeHelper = new BinaryTreeHelper();


  @Test
  public void isValidBST_1()
  {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(6);

    Assert.assertFalse("Tree is not BST" , binaryTreeHelper.isValidBST(root));
  }

  @Test
  public void isValidBST_2()
  {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);

    Assert.assertTrue("Tree is a BST" , binaryTreeHelper.isValidBST(root));
  }

  @Test
  public void isValidBST_3()
  {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(1);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(5);

    Assert.assertFalse("Tree is not BST" , binaryTreeHelper.isValidBST(root));
  }

  @Test
  public void isValidBST_4()
  {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(1);

    Assert.assertFalse("Tree is not BST" , binaryTreeHelper.isValidBST(root));
  }

  //[10,5,15,null,null,6,20]
  @Test
  public void isValidBST_5()
  {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(15);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(20);

    Assert.assertFalse("Tree is not BST" , binaryTreeHelper.isValidBST(root));
  }

  @Test
  // [1,1]
  public void isValidBST_6()
  { TreeNode root = new TreeNode(1);
    root.left = new TreeNode(1);

    Assert.assertFalse("Tree is not (strict) BST" , binaryTreeHelper.isValidBST(root));
  }

  @Test
  // [-2147483648,null,2147483647]
  public void isValidBST_7_boundryCase()
  { TreeNode root = new TreeNode(-2147483648);
  root.right = new TreeNode(2147483647);

  Assert.assertTrue("Tree is BST" , binaryTreeHelper.isValidBST(root));
  }

}