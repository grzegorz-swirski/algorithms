package com.grzegorz.algorithms.codility;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SubsequenceAmpTest {

    SubsequenceAmp s = new SubsequenceAmp();

    @Test
    public void testEmpty() throws Exception {
        int[] test = new int[]{};
        int result = s.solution(test);
        assertEquals(0, result);
    }

    @Test
    public void testSingular() throws Exception {
        int[] test = new int[]{5};
        int result = s.solution(test);
        assertEquals(1, result);
    }

    @Test
    public void test1() throws Exception {
        int[] test = new int[] {6, 10, 6, 9, 7, 8};
        int result = s.solution(test);
        assertEquals(3, result);
    }

    @Test
    public void test2() throws Exception {
        int[] test = new int[] {6, 6, 9, 6, 6, 6, 6, 6, 6, 8};
        int result = s.solution(test);
        assertEquals(8, result);
    }

    @Test
    public void test3() throws Exception {
        int[] test = new int[] {6, 6, 9, 6, 7, 6, 6, 6, 6, 6, 8};
        int result = s.solution(test);
        assertEquals(9, result);
    }

    @Test
    public void test4() throws Exception {
        int[] test = new int[] {1, 2, 5, 6, 5, 10};
        int result = s.solution(test);
        assertEquals(3, result);
    }
}
