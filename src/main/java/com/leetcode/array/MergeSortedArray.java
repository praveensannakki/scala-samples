package com.leetcode.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] joined = IntStream.concat(IntStream.of(nums1), IntStream.of(nums2)).toArray();
//        Arrays.sort(joined);
//        System.out.println(Arrays.toString(joined));

        for (int i = 0; i < n; i++) {
            nums1[i+m] = nums2[i];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

}
