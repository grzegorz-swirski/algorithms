package com.grzegorz.algorithms.codility;

import java.util.Arrays;

public class MaxTriplet {

    public int solution(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int candidateWithNegs = a[0] * a[1] * a[n - 1];
        int candidateWithoutNegs = a[n - 1] * a[n - 2] * a[n - 3];
        return Math.max(candidateWithNegs, candidateWithoutNegs);
    }
}
