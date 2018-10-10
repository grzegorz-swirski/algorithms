package com.grzegorz.algorithms.other;

public class MaxArraySize {

    public int findMaxArrayLimit() throws Exception {

        int min = 0;
        int max = Integer.MAX_VALUE;

        while (min != max) {
            int mid = min + ((max - min) / 2);
            try {
                int[] bigArray = new int[mid];
                min = mid + 1;
            } catch (OutOfMemoryError e) {
                if (e.getMessage().equals("Java heap space")) {
                    min = mid + 1;
                } else {
                    max = mid;
                }

            }
        }

        assert min == max;
        return min;
    }
}
