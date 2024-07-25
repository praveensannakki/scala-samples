package com.leetcode.linkedlist;

import static com.leetcode.linkedlist.ListNode.printLinkedList;

/**
 * 21. Merge Two Sorted Lists
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {
    //write code to call mergeTwoList method
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = mergeTwoLists(list1, list2);
        printLinkedList(result);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // if(list1 == null) return list2;
        // if(list2 == null) return list1;

        // ListNode head;
        // if (list1.val > list2.val) {
        //     head = list2;
        //     list2 = list2.next;
        // } else {
        //     head = list1;
        //     list1 = list1.next;
        // }
        // head.next = mergeTwoLists(list1, list2);

        // return head;

        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(list1!= null && list2!=null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = list1 == null ? list2 : list1;

        return dummyHead.next;
    }
}
