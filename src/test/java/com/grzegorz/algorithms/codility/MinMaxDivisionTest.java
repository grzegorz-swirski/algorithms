package com.grzegorz.algorithms.codility;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MinMaxDivisionTest {

    @Test
    public void test1() throws Exception {
        int k = 3;
        int m = 5;
        int[] a = new int[]{2, 1, 5, 1, 2, 2, 2};

        MinMaxDivision s = new MinMaxDivision();

        assertEquals(6, s.solution(k, m, a));
    }
}
