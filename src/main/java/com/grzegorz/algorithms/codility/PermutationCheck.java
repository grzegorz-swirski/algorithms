package com.grzegorz.algorithms.codility;

public class PermutationCheck {

    public int solution(int[] A) {
        int maxValue = A.length;
        int[] count = new int[maxValue + 1];

        for (int i = 0; i < A.length; i++) {
            if (A[i] > maxValue || count[A[i]] != 0) {
                return 0;
            }
            count[A[i]] += 1;
        }
        return 1;
    }


}
