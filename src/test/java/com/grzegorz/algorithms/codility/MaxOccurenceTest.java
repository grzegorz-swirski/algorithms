package com.grzegorz.algorithms.codility;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class MaxOccurenceTest {

    MaxOccurrence s = new MaxOccurrence();

    @Test
    public void test1() throws Exception {
        int m = 3;
        int[] test = new int[]{1, 2, 3, 3, 1, 3, 1};
        int result = s.solution(3, test);
        assertTrue(result == 1 || result == 3);
    }

    @Test
    public void test2() throws Exception {
        int m = 7;
        int[] test = new int[]{3, 3, 7, 7, 7, 2, 5, 6};
        int result = s.solution(m, test);
        assertEquals(7, result);
    }

    @Test
    public void test3() throws Exception {
        int m = 7;
        int[] test = new int[]{3, 3, 4, 4, 4, 2, 5, 7};
        int result = s.solution(m, test);
        assertEquals(4, result);
    }

    @Test
    public void test4() throws Exception {
        int m = 1;
        int[] test = new int[]{1};
        int result = s.solution(m, test);
        assertEquals(1, result);
    }

    @Test
    public void test5() throws Exception {
        int m = 3;
        int[] test = new int[]{1, 2, 3};
        int result = s.solution(m, test);
        assertTrue(result == 1 || result == 2 || result == 3);
    }

    @Test
    public void test6() throws Exception {
        int m = 5;
        int[] test = new int[]{5, 5, 5, 5, 5, 5, 4, 4, 4};
        int result = s.solution(m, test);
        assertEquals(5, result);
    }


    @Test
    public void test7() throws Exception {
        int m = 5;
        int[] test = new int[]{4, 4, 4, 5, 5, 5, 5, 5, 5};
        int result = s.solution(m, test);
        assertEquals(5, result);
    }

    @Test
    public void test8() throws Exception {
        int m = 2;
        int[] test = new int[]{1, 1, 1, 2, 2, 2};
        int result = s.solution(m, test);
        assertEquals(1, result);
    }


    @Test
    public void test9() throws Exception {
        int m = 2;
        int[] test = new int[]{2, 2, 2, 1, 1, 1};
        int result = s.solution(m, test);
        assertEquals(2, result);
    }


    @Test
    public void countTest() throws Exception {
        int[] a = new int[]{2, 5, 3, 2};

        int result = s.solution(5, a);

        int[] expected = new int[]{0, 0, 2, 1, 0, 1};
//        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void test10() throws Exception {
        int m = 5;
        int[] test = new int[]{5};
        int result = s.solution(m, test);
        assertEquals(5, result);
    }

    @Test
    public void test11() throws Exception {
        int m = 30;
        int[] test = new int[]{0, 0, 0, 0, 2};
        int result = s.solution(m, test);
        assertEquals(0, result);
    }


    @Test
    public void test12() throws Exception {
        int m = 30;
        int[] test = new int[]{10, 30, 30};
        int result = s.solution(m, test);
        assertEquals(30, result);
    }

    @Test
    public void test13() throws Exception {
        int m = 7;
        int[] test = new int[]{1, 2, 3, 4, 6, 5, 6, 7};
        int result = s.solution(m, test);
        assertEquals(6, result);
    }

    @Test
    public void test14() throws Exception {
        int m = 7;
        int[] test = new int[]{5, 6, 7};
        int result = s.solution(m, test);
        assertEquals(5, result);
    }
}
