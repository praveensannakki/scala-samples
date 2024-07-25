package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 3062. Winner of the Linked List Game
 *
 * You are given the head of a linked list of even length containing integers.
 *
 * Each odd-indexed node contains an odd integer and each even-indexed node contains an even integer.
 *
 * We call each even-indexed node and its next node a pair, e.g., the nodes with indices 0 and 1 are a pair, the nodes with indices 2 and 3 are a pair, and so on.
 *
 * For every pair, we compare the values of the nodes in the pair:
 *
 * If the odd-indexed node is higher, the "Odd" team gets a point.
 * If the even-indexed node is higher, the "Even" team gets a point.
 * Return the name of the team with the higher points, if the points are equal, return "Tie".
 *
 * Example 1:
 * Input: head = [2,1]
 * Output: "Even"
 * Explanation: There is only one pair in this linked list and that is (2,1). Since 2 > 1, the Even team gets the point.
 * Hence, the answer would be "Even".
 *
 * Example 2:
 * Input: head = [2,5,4,7,20,5]
 * Output: "Odd"
 * Explanation: There are 3 pairs in this linked list. Let's investigate each pair individually:
 * (2,5) -> Since 2 < 5, The Odd team gets the point.
 * (4,7) -> Since 4 < 7, The Odd team gets the point.
 * (20,5) -> Since 20 > 5, The Even team gets the point.
 * The Odd team earned 2 points while the Even team got 1 point and the Odd team has the higher points.
 * Hence, the answer would be "Odd".
 *
 * Example 3:
 * Input: head = [4,5,2,1]
 * Output: "Tie"
 * Explanation: There are 2 pairs in this linked list. Let's investigate each pair individually:
 * (4,5) -> Since 4 < 5, the Odd team gets the point.
 * (2,1) -> Since 2 > 1, the Even team gets the point.
 * Both teams earned 1 point.
 * Hence, the answer would be "Tie".
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [2, 100].
 * The number of nodes in the list is even.
 * 1 <= Node.val <= 100
 * The value of each odd-indexed node is odd.
 * The value of each even-indexed node is even.
 */
public class WinnerOfTheLinkedListGame {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        System.out.println(gameResult(head));
    }
    public static String gameResult(ListNode head) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Odd", 0);
        map.put("Even", 0);

        int odd=0, even=0;

        // Map<String, Integer> map = Stream.of(new object[][] {
        //     {"Odd", 0},
        //     {"Even", 0},
        // }).collect(Collectors.toMap(data -> (String) data[0], (Integer) data[1]));

        while (head != null && head.next !=null) {
            if (head.val < head.next.val) {
                //map.put("Odd", map.get("Odd") + 1);
                odd++;
            } else {
                //map.put("Even", map.get("Even") +1);
                even++;
            }
            head = head.next.next;
        }

        // if (map.get("Odd") > map.get("Even")) {
        //     return "Odd";
        // } else if (map.get("Odd") < map.get("Even")) {
        //     return "Even";
        // }
        if (odd > even) {
            return "Odd";
        } else if (odd < even) {
            return "Even";
        }

        return "Tie";
    }
}
