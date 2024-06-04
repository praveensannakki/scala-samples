package com.scala.leetcode.array.test

object MaxDepthBinaryTree {
  //https://alvinalexander.com/java/jwarehouse/scala/test/files/shootout/binarytrees.scala.shtml
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def maxDepth(root: TreeNode): Int = {
    if (root == null)
      return 0

    var ldepth = maxDepth(root.left)
    var rdepth = maxDepth(root.right)
    if (ldepth > rdepth) {
      ldepth + 1
    } else {
      rdepth + 1
    }
  }

  def maxDepth2(root: TreeNode): Int = {
    if (root == null) {
      0
    } else {
      Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1
    }
  }

  def maxDepth3(root: TreeNode): Int = {
    findDepth(root, 0)
  }
  def findDepth(root: TreeNode, count: Int): Int = {
    if (root == null) {
      count
    } else if (root.left == null && root.right == null) {
      count + 1
    } else if (root.left == null) {
      return findDepth(root.right, count + 1)
    } else if (root.right == null) {
      return findDepth(root.left, count + 1)
    } else {
      val incremented = count + 1
      return findDepth(root.left, incremented) max findDepth(root.right, incremented)
    }
  }

  var max_level = 0

  def lefViewofTree(root: TreeNode, level: Int): Unit = {
    if (root == null)
      return ;

    // If this is the first node of its level
    if (max_level < level) {
      println(" " + root.value);
      max_level = level;
    }

    // Recur for left and right subtrees
    lefViewofTree(root.left, level + 1);
    lefViewofTree(root.right, level + 1);
  }

 import scala.collection.mutable.ListBuffer
 
 var rightside = new ListBuffer[Int]()
  
  def rightViewofTree(root: TreeNode, level: Int): List[Int] = {
    if (root == null)
      return rightside.toList
    helper(root, 0)
    rightside.toList
  }

  def helper(node: TreeNode, level: Int) {
    println("level " + level + " size " + rightside.size)
    if (level == rightside.size)
      rightside += node.value

    if (node.right != null)
      helper(node.right, level + 1);
    if (node.left != null)
      helper(node.left, level + 1);
  }

  def main(args: Array[String]): Unit = {
    var root = new TreeNode(5);
    root.left = new TreeNode(10);
    root.right = new TreeNode(15);
    root.left.left = new TreeNode(20);
    root.left.right = new TreeNode(25);
    root.left.left.left = new TreeNode(30);
    root.left.right.left = new TreeNode(35);
    root.left.right.left.left = new TreeNode(40);
    root.left.right.left.left.right = new TreeNode(45);
    root.left.right.left.left.right.left = new TreeNode(50);
    //println(root.left.value)

    println("Tree Height: " + maxDepth(root));
    println("Tree Height: " + maxDepth2(root));

    var root2 = new TreeNode(4);
    root2.left = new TreeNode(5);
    root2.right = new TreeNode(2);
    root2.right.left = new TreeNode(3);
    root2.right.right = new TreeNode(1);
    root2.right.left.left = new TreeNode(6);
    root2.right.left.right = new TreeNode(7);

    //println(lefViewofTree(root2, 1))
    //    println(TreeNode.right)
    //    println(maxDepth(TreeNode))

    println(rightViewofTree(root2, 0).size)
    rightViewofTree(root2, 0).foreach(println)
  }

}