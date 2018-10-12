package com.grzegorz.algorithms.codility;

import java.util.Arrays;

public class CountingExercise {

    public boolean canSwapToSum(int[] a, int[] b, int maxValue) {
        int[] countA = count(a, maxValue);
        int sumA = Arrays.stream(a).sum();
        int sumB = Arrays.stream(b).sum();
        int diff = sumB - sumA;
        if (diff % 2 != 0) {
            return false;
        }

        diff = diff / 2; // difference between swapped elements

        for (int i = 0; i < b.length; i++) {
            int x = b[i] - diff;
            if (x >= 0 && x <= maxValue && countA[x] > 0) {
                return true;
            }
        }
        return false;
    }

    public int[] count(int[] numbers, int maxValue) {
        int[] result = new int[maxValue + 1];
        for (int i = 0; i < numbers.length; i++) {
            result[numbers[i]] += 1;
        }
        return result;
    }
}
