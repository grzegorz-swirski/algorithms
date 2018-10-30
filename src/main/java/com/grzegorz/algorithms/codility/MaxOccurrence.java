package com.grzegorz.algorithms.codility;

public class MaxOccurrence {
    int solution(int M, int[] A) {
        int N = A.length;
        int[] count = new int[M + 1];
        for (int i = 0; i <= M; i++)
            count[i] = 0;
        int maxOccurence = 1;
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (count[A[i]] > 0) {
                count[A[i]] += 1;
                int tmp = count[A[i]];
                if (tmp > maxOccurence) {
                    maxOccurence = tmp;
                    index = i;
                }
            } else {
                count[A[i]] = 1;
            }
        }
        return A[index];
    }
}
