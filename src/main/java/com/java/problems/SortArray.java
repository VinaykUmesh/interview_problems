package com.java.problems;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 0};
        sortArray(arr);
    }

    private static void sortArray(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
