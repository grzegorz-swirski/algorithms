package com.grzegorz.algorithms.codility;

import java.util.HashMap;
import java.util.Map;

public class SubsequenceAmpMap {
    public int solution(int[] a) {
        int maxSubsequenceLen = 0;

        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer i : a) {
            Integer val = counts.get(i);
            if (val != null) {
                counts.put(i, ++val);
            } else {
                counts.put(i, 1);
            }

        }

        for (Integer i : counts.keySet()) {
            maxSubsequenceLen = Math.max(maxSubsequenceLen, leftNeighbourSum(counts, i));
        }

        return maxSubsequenceLen;
    }

    private int leftNeighbourSum(Map<Integer, Integer> counts, Integer key) {
        Integer val = counts.get(key);
        if (counts.containsKey(key - 1)) {
            return val + counts.get(key - 1);
        }
        return val;
    }
}
