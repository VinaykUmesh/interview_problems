package com.java.problems;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] n = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(n, target)));

        n = new int[]{3,2,4};
        target = 6;
        System.out.println(Arrays.toString(twoSum(n, target)));

        n = new int[]{3,3};
        target = 3;
        System.out.println(Arrays.toString(twoSum(n, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
