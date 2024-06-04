package com.java.practice;

import java.io.File;
import java.util.Arrays;

public class RainWaterTrap {
    public static void main(String[] args) {

    }

    private static int totalWater(int[] height) {

        int left = 0, right = height.length - 1;
        int l_max = 0, r_max = 0;

        int res = 0;
        while (left < right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);

            if (l_max < r_max) {
                res += l_max - height[left];
                left++;
            } else {
                res += r_max - height[right];
                right--;
            }
        }
        return res;
    }

    private static long getLastModifiedTime(File files) {
        long lModified = 0L;
        if(files.isDirectory()){
            File[] file = files.listFiles();
            lModified = Arrays.stream(files.listFiles()).mapToLong(File::lastModified).filter(f -> f >= 0L).max().orElse(0L);
        } else {
            if(files.lastModified() > lModified) {
                lModified = files.lastModified();
            }
        }
        return 0;
    }

}
