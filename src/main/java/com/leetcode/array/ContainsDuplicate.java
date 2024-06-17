package com.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 217. Contains Duplicate
 *
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println("containsDuplicateElement? :" + new ContainsDuplicate().containsDuplicateElement(new int[]{1, 2, 3, 1}));
        System.out.println("containsDuplicateElement? :" + new ContainsDuplicate().containsDuplicateElementBreak(new int[]{1,2,3,4}));
        System.out.println("containsDuplicateElement? :" + new ContainsDuplicate().containsDuplicate(new int[]{1,2,3,4}));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return set.size() < nums.length;
    }

    public boolean containsDuplicateElement(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        return nums.length != set.size();
    }

    public boolean containsDuplicateElementBreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}
