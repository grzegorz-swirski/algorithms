package com.grzegorz.algorithms.codility;


import java.util.Arrays;

class OddOccurrencesInArray {

    public int solution(int a[]) {

        Arrays.sort(a);

        int prev = a[0];
        int count = 1;

        for (int i = 1; i < a.length; i++) {
            int cur = a[i];
            if (cur != prev) {
                if (count % 2 != 0) {
                    return prev;
                } else {
                    count = 1;
                }
            } else {
                count += 1;
            }
            prev = cur;
        }

        return prev;
    }
}