package com.grzegorz.algorithms.codility;

public class BinarySearch {
    public int findIndex(int k, int[] a) {
        int len = a.length;

        int beg = 0;
        int end = len - 1;

        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (a[mid] < k) {
                beg = mid + 1;
            } else if (a[mid] > k) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
