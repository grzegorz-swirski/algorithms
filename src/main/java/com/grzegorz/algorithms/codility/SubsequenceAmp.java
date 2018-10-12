package com.grzegorz.algorithms.codility;

import java.util.Arrays;

public class SubsequenceAmp {
    public int solution(int[] a) {
        int len = a.length;
        if (len == 0 || len == 1) {
            return len;
        }

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        int maxQuasiConstSeq = 1;
        int currentQuasiConstSeq = 1;
        int amp = a[0];
        for (int i = 1; i < len; i++) {
            if (a[i] - amp <= 1) {
                currentQuasiConstSeq += 1;
                if (currentQuasiConstSeq > maxQuasiConstSeq) {
                    maxQuasiConstSeq = currentQuasiConstSeq;
                }
            } else {
                amp = a[i];
                currentQuasiConstSeq = 1;
            }
        }

        return maxQuasiConstSeq;
    }
}
