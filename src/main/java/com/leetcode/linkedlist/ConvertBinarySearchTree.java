package com.leetcode.linkedlist;

/**
 * 426. Convert Binary Search Tree to Sorted Doubly Linked List
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
 *
 * You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
 *
 * We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.
 *
 * Example 1:
 * Input: root = [4,2,5,1,3]
 * Output: [1,2,3,4,5]
 * Explanation: The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.
 *
 * Example 2:
 * Input: root = [2,1,3]
 * Output: [1,2,3]
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 * All the values of the tree are unique.
 */

class DLLNode {
    public int val;
    public DLLNode left;
    public DLLNode right;

    public DLLNode() {}

    public DLLNode(int _val) {
        val = _val;
    }

    public DLLNode(int _val, DLLNode _left, DLLNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class ConvertBinarySearchTree {
    static DLLNode first = null;
    static DLLNode last = null;

    public static DLLNode treeToDoublyList(DLLNode root) {
        if (root == null) return null;
        sort(root);
        last.right = first;
        first.left = last;

        return first;
    }

    public static void sort(DLLNode node) {
        if (node !=null) {
            //find the minmum element by going to left tree and sort
            sort(node.left);

            if(last !=null) {
                //link the prev node with current node
                last.right = node;
                node.left = last;
            } else {
                //keep the smallest node
                first = node;
            }

            last = node;

            //itereate the right tree and apply same logic
            sort(node.right);

        }
    }

    public static void main(String[] args) {
        DLLNode root = new DLLNode(4);
        root.left = new DLLNode(2);
        root.right = new DLLNode(5);
        root.left.left = new DLLNode(1);
        root.left.right = new DLLNode(3);

        DLLNode result = treeToDoublyList(root);
        printList(result);
    }

    public static void printList(DLLNode node) {
        if (node == null) {
            return;
        }

        DLLNode current = node;
        DLLNode firstNode = current;

        System.out.print(current.val + " ");
        current = current.right;

        while (current != firstNode) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }
}
