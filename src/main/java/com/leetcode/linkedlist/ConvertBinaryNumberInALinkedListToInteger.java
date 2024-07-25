package com.leetcode.linkedlist;

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 * The most significant bit is at the head of the linked list.
 *
 * Example 1:
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 *
 * Example 2:
 * Input: head = [0]
 * Output: 0
 *
 * Constraints:
 *
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(0, new ListNode(1)));
        int result = getDecimalValue(list);
        System.out.println(result);
    }
    public static int getDecimalValue(ListNode head) {
        //int decimalValue = head.val;
        String s = Integer.toString(head.val);
        while (head.next != null) {
            //decimalValue = decimalValue *2 + head.next.val;
            s = s + Integer.toString(head.next.val);
            head = head.next;
        }
        //return decimalValue;
        return Integer.parseInt(s, 2);
    }
}
