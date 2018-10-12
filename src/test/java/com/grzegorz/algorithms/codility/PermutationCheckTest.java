package com.grzegorz.algorithms.codility;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PermutationCheckTest {

    PermutationCheck s = new PermutationCheck();

    @Test
    public void test1() throws Exception {
        int[] test = new int[] {2, 4, 1, 3};
        assertEquals(1, s.solution(test));
    }

    @Test
    public void test2() throws Exception {
        int[] test = new int[] {2, 5, 1, 3};
        assertEquals(0, s.solution(test));
    }

    @Test
    public void test3() throws Exception {
        int[] test = new int[] {2, 2, 1, 3};
        assertEquals(0, s.solution(test));
    }

    @Test
    public void test4() throws Exception {
        int[] test = new int[] {4, 1, 3};
        assertEquals(0, s.solution(test));
    }

    @Test
    public void test5() throws Exception {
        int[] test = new int[] {4, 1, 3, 2, 5, 1};
        assertEquals(0, s.solution(test));
    }


    @Test
    public void test6() throws Exception {
        int[] test = new int[] {4, 1, 3, 2, 5};
        assertEquals(1, s.solution(test));
    }
}
