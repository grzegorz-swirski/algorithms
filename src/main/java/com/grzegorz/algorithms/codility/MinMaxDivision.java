package com.grzegorz.algorithms.codility;

class MinMaxDivision {
    public int solution(int K, int M, int[] A) {

        int maxLargeSum = 0; // sum of all elements in A
        int minLargeSum = 0; // max element of A

        for (int i = 0; i < A.length; i++) {
            maxLargeSum = maxLargeSum + A[i];
            minLargeSum = Math.max(minLargeSum, A[i]);
        }

        int min = minLargeSum;
        int max = maxLargeSum;
        int result = maxLargeSum;

        while (min <= max) {
            int candidate = (min + max) / 2; // mid - candidate for smallest large sum

            // each block will have sum smaller than candidate large sum
            if (isDivisible(candidate, A, K)) { // the candidate large sum is big enough so that elements can fit into K blocks of size candidate
                // we can try smaller block size
                result = candidate;
                max = candidate - 1;

            } else { // the candidate large sum is too small, we didn't fit all elements in K blocks of size at most candidate
                // we have to try bigger block size
                min = candidate + 1;
            }
        }

        return result;
    }

    private boolean isDivisible(int maxSum, int[] A, int K) {
        int blocksAvailable = K;
        int currentSum = 0;

        for (int i = 0; i < A.length; i++) {
            currentSum = currentSum + A[i];
            if (currentSum > maxSum) {
                blocksAvailable--;
                currentSum = A[i]; // starting next block
            }

            // all blocks already used and new block started
            // (blocksAvailable must have been decremented in this iteration to
            // pass the condition below)
            if (blocksAvailable == 0) {
                return false;
            }
        }

        return true;
    }
}