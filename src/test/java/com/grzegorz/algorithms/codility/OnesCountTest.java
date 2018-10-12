package com.grzegorz.algorithms.codility;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class OnesCountTest {

    OnesCount s = new OnesCount();

    @Test
    public void test1() throws Exception {
        int a = 3;
        int b = 7;
        int result = s.solution(a, b);

        assertEquals(3, result);
    }


    @Test
    public void test2() throws Exception {
        int a = 323;
        int b = 7545;
        int result = s.solution(a, b);

        assertEquals(13, result);
    }


    @Test
    public void test3() throws Exception {
        int a = 0;
        int b = 0;
        int result = s.solution(a, b);

        assertEquals(0, result);
    }


    @Test
    public void test4() throws Exception {
        int a = 1000_000_000;
        int b = 1000_000_000;
        int result = s.solution(a, b);

        assertEquals(8, result);
    }

    @Test
    public void test5() throws Exception {
        int a = 123;
        int b = 0;
        int result = s.solution(a, b);

        assertEquals(0, result);
    }
}
