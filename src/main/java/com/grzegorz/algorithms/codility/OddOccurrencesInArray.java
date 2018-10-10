package com.grzegorz.algorithms.codility;


import java.util.Arrays;

class OddOccurrencesInArray {

    public int solution(int a[]) {
        Arrays.sort(a);

        for (int i = 0; i < a.length; i += 2) {
            if (i == a.length - 1) {
                return a[i];
            }

            if (a[i] != a[i + 1]) {
                return a[i];
            }
        }

        return -1;
    }
}