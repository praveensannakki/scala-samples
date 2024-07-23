package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {
    public static void main(String[] args) {
        System.out.println("Kids with the greatest number of candies");
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> result = kidsWithCandies(candies, extraCandies);
        System.out.println(result);

        System.out.println("--------------------");

        result = kidsWithCandies(new int[]{4,2,1,1,2}, 1);
        System.out.println(result);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = Arrays.stream(candies).max().getAsInt();
        for (int candy : candies) {
            int sum = candy + extraCandies;
            list.add(sum >= max);
        }
        return list;
    }
}
