package com.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2215. Find the Difference of Two Arrays
 *
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 * Note that the integers in the lists may be returned in any order.
 *
 * Example 1:
 * Input: nums1 = [1,2,3], nums2 = [2,4,6]
 * Output: [[1,3],[4,6]]
 * Explanation:
 * For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
 * For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
 *
 *
 * Example 2:
 * Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
 * Output: [[3],[]]
 * Explanation:
 * For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
 * Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
 */
public class FindTheDifferenceOfTwoArrays {
    public static void main(String[] args) {
        List<List<Integer>> differencList = differenceOfTwoArray(new int[] {1,2,3}, new int[] {2,4,6});
        System.out.println(differencList);

        differencList = differenceOfTwoArraySet(new int[] {1,2,3,3}, new int[] {1,1,2,2});
        System.out.println(differencList);
    }

    private static List<List<Integer>> differenceOfTwoArraySet(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        return Arrays.asList(findDifference(set1, set2), findDifference(set2, set1));
    }

    private static List<Integer> findDifference(Set<Integer> set1, Set<Integer> set2) {
        List<Integer> result = new ArrayList<>();
        set1.forEach(num -> {
            if(!set2.contains(num)) {
                result.add(num);
            }
        });
        return result;
    }

    private static List<List<Integer>> differenceOfTwoArray(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(findDifference(nums1, nums2));
        list.add(findDifference(nums2, nums1));

        return list;
    }

    public static List<Integer> findDifference(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> nums2List = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        for (int num : Arrays.stream(nums1).boxed().collect(Collectors.toSet())) {
            if (!nums2List.contains(num)) {
                list.add(num);
            }
        }

        return list;
    }
}
