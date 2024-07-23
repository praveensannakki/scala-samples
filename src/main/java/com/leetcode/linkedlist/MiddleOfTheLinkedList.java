package com.leetcode.linkedlist;

import java.util.ArrayList;

/**
 * 876. Middle of the Linked List
 *
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 *
 * Example 2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 */

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        System.out.println(middleNode(head).val);
        System.out.println(middleOfLinkedList(head).val);
    }

    private static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode middleOfLinkedList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        int len = 0;
        while (head != null) {
            list.add(head);
            head = head.next;
            len++;
        }
        return list.get(len/2);
    }
}
