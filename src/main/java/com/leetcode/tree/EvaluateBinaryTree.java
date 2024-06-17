package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 2331. Evaluate Boolean Binary Tree
 * <p>
 * You are given the root of a full binary tree with the following properties:
 * Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
 * Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
 * The evaluation of a node is as follows:
 * If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
 * Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
 * Return the boolean result of evaluating the root node.
 * A full binary tree is a binary tree where each node has either 0 or 2 children.
 * <p>
 * A leaf node is a node that has zero children.
 * <p>
 * Example 1:
 * Input: root = [2,1,3,null,null,0,1]
 * Output: true
 * Explanation: The above diagram illustrates the evaluation process.
 * The AND node evaluates to False AND True = False.
 * The OR node evaluates to True OR False = True.
 * The root node evaluates to True, so we return true.
 * <p>
 * Example 2:
 * Input: root = [0]
 * Output: false
 * Explanation: The root node is a leaf node and it evaluates to false, so we return false.
 */
public class EvaluateBinaryTree {
    public static void main(String[] args) {
        EvaluateBinaryTree evaluateBinaryTree = new EvaluateBinaryTree();

        TreeNode root = evaluateBinaryTree.buildTree(new Integer[]{2, 1, 3, null, null, 0, 1});
        System.out.println(evaluateBinaryTree.evaluateTree(root));
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param root
     * @return
     */
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val != 0;
        }

        boolean left = evaluateTree(Objects.requireNonNull(root.left));
        boolean right = evaluateTree(root.right);
        boolean evaluateRoot;
        if (root.val == 2) {
            evaluateRoot = left | right;
        } else {
            evaluateRoot = left & right;
        }
        return evaluateRoot;
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(Integer[] values) {
        if (values.length == 0) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < values.length) {
            TreeNode current = queue.poll();

            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;

            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
}

