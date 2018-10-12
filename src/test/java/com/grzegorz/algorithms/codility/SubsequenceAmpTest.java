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

    @Test
    public void test5() throws Exception {
        int[] test = new int[] {1, 4, 65, 34, 65, 34, 2, 5, 4};
        int result = s.solution(test);
        assertEquals(3, result);
    }

    @Test
    public void test6() throws Exception {
        int[] test = new int[] {4, 4};
        int result = s.solution(test);
        assertEquals(2, result);
    }


    @Test
    public void test7() throws Exception {
        int[] test = new int[] {4, 6};
        int result = s.solution(test);
        assertEquals(1, result);
    }

    @Test
    public void test12() throws Exception {
        int[] test = new int[] {4, 5};
        int result = s.solution(test);
        assertEquals(2, result);
    }


    @Test
    public void test8() throws Exception {
        int[] test = new int[] {4, 6, 8};
        int result = s.solution(test);
        assertEquals(1, result);
    }

    @Test
    public void test13() throws Exception {
        int[] test = new int[] {4, 5, 6};
        int result = s.solution(test);
        assertEquals(2, result);
    }


    @Test
    public void test9() throws Exception {
        int[] test = new int[] {4, 6, 8, 5};
        int result = s.solution(test);
        assertEquals(2, result);
    }


    @Test
    public void test10() throws Exception {
        int[] test = new int[] {4, 5, 6, 7, 8};
        int result = s.solution(test);
        assertEquals(2, result);
    }

    @Test
    public void test11() throws Exception {
        int[] test = new int[] {3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5};
        int result = s.solution(test);
        assertEquals(9, result);
    }

    @Test
    public void test14() throws Exception {
        int[] test = new int[] {5, 5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3};
        int result = s.solution(test);
        assertEquals(9, result);
    }

    @Test
    public void test15() throws Exception {
        int[] test = new int[] {5, 5, 9, 9, 9};
        int result = s.solution(test);
        assertEquals(3, result);
    }

    @Test
    public void test16() throws Exception {
        int[] test = new int[] {5, 5, 6, 6, 6, 7, 7, 7, 10};
        int result = s.solution(test);
        assertEquals(6, result);
    }

    @Test
    public void test17() throws Exception {
        int[] test = new int[] {5, 5, 6, 6, 6, 7, 7, 7, 10, Integer.MAX_VALUE - 1};
        int result = s.solution(test);
        assertEquals(6, result);
    }

    @Test
    public void testWithNegatives() throws Exception {
        int[] test = new int[] {-3, -3, -2, 1, 1};
        int result = s.solution(test);
        assertEquals(3, result);
    }

    @Test
    public void testWithNegatives2() throws Exception {
        int[] test = new int[] {-3, -3, -2, 1, 1, 2, 2};
        int result = s.solution(test);
        assertEquals(4, result);
    }
}
