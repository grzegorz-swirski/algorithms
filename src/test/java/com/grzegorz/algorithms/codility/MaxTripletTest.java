package com.grzegorz.algorithms.codility;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MaxTripletTest {

    MaxTriplet s = new MaxTriplet();

    @Test
    public void test1() throws Exception {
        int[] test = new int[]{-3, 1, 2, -2, 5, 6};
        assertEquals(60, s.solution(test));
    }

    @Test
    public void test2() throws Exception {
        int[] test = new int[]{2, 2, 3, 4, 1};
        assertEquals(24, s.solution(test));
    }

    @Test
    public void test3() throws Exception {
        int[] test = new int[]{1, 1, 1};
        assertEquals(1, s.solution(test));
    }

    @Test
    public void test4() throws Exception {
        int[] test = new int[]{2, 2, 3, 4, 1, -5, -6};
        assertEquals(120, s.solution(test));
    }

    @Test
    public void test5() throws Exception {
        int[] test = new int[]{2, 2, 3, 4, 1, -6, -7, -5};
        assertEquals(168, s.solution(test));
    }


    @Test
    public void test6() throws Exception {
        int[] test = new int[]{2, 2, 3, 4, 1, -6, -7, -5, 6};
        assertEquals(252, s.solution(test));
    }
}
