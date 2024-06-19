package com.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 287. Find the Duplicate Number
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 *
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 * Example 3:
 * Input: nums = [3,3,3,3,3]
 * Output: 3
 *
 * Constraints:
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 *
 * Follow up:
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 *
 */
public class FindDuplicate {

    public static void main(String[] args) {
        System.out.println("find duplicate: " + new FindDuplicate().findDuplicate(new int[]{1, 2, 3, 1, 5, 6, 7}));
        System.out.println("find duplicate: " + new FindDuplicate().findDuplicateSort(new int[]{1, 2, 3, 1, 5, 6, 7}));
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    /**
     * Time Complexity: O(nlog⁡n)
     * Space Complexity: O(log⁡n) or O(n)
     *
     * @param nums
     * @return
     */
    public int findDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
