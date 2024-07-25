package com.leetcode.linkedlist;

import static com.leetcode.linkedlist.ListNode.printLinkedList;

/**
 * 19. Remove Nth Node From End of List
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 *
 * Follow up: Could you do this in one pass?
 */
public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        ListNode list = ListNode.createLinkedList(new int[] {1,2,3,4,5});
        printLinkedList(list);
        ListNode result = removeNthFromEnd(list, 2);
        printLinkedList(result);
        result = removeNthFromEndSinglePass(list, 2);
        printLinkedList(result);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode nodeToGetCount = head;
        while(nodeToGetCount != null) {
            nodeToGetCount = nodeToGetCount.next;
            len++;
        }

        int indexToDelete = len - n;
        ListNode nodeToDelete = dummy;
        while(indexToDelete > 0) {
            indexToDelete--;
            nodeToDelete = nodeToDelete.next;
        }
        nodeToDelete.next = nodeToDelete.next.next;

        return dummy.next;
    }

    public static ListNode removeNthFromEndSinglePass(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
