package com.leetcode.array;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] nums) {
        Map<Integer, Integer> occurrenceMap = Arrays.stream(nums)
                                            .boxed()
                                            .collect(Collectors.toMap(
                                                Function.identity(),
                                                v -> 1,
                                                Integer::sum
                                            ));
        return occurrenceMap.size() == Arrays.stream(occurrenceMap.values().toArray()).distinct().count();
    }
}
