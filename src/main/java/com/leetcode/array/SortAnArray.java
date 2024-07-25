package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 912. Sort an Array
 *
 * Given an array of integers nums, sort the array in ascending order and return it.
 *
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 *
 * Example 1
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
 *
 * Example 2:
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Explanation: Note that the values of nums are not necessairly unique.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        // Implement your solution here
        //initialize map to collect the counts of each elements
        Map<Integer, Integer> map = new HashMap<>();
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE, index=0;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //sort the elements from min value to max value
        for(int i=min; i<=max; i++) {
            if (map.containsKey(i)) {
                int count = map.get(i); // get the occurrence to fill the array
                while(count>0) {
                    nums[index++] = i;
                    count--;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 1};
        System.out.println(Arrays.toString(nums));
        SortAnArray sortAnArray = new SortAnArray();
        sortAnArray.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
