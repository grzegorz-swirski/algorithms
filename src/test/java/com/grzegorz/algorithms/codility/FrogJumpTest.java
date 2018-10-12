package com.grzegorz.algorithms.codility;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FrogJumpTest {

    @Test
    public void test1() throws Exception {
        FrogJump s = new FrogJump();
        int X = 10;
        int Y = 85;
        int D = 30;

        int result = s.solution(X, Y, D);

        assertEquals(3, result);
    }

    @Test
    public void test2() throws Exception {
        FrogJump s = new FrogJump();
        int X = 0;
        int Y = 100;
        int D = 10;

        int result = s.solution(X, Y, D);

        assertEquals(10, result);
    }

    @Test
    public void test3() throws Exception {
        FrogJump s = new FrogJump();
        int X = 50;
        int Y = 100;
        int D = 10;

        int result = s.solution(X, Y, D);

        assertEquals(5, result);
    }

    @Test
    public void test4() throws Exception {
        FrogJump s = new FrogJump();
        int X = 50;
        int Y = 100;
        int D = 1;

        int result = s.solution(X, Y, D);

        assertEquals(50, result);
    }


    @Test
    public void test5() throws Exception {
        FrogJump s = new FrogJump();
        int X = 0;
        int Y = 1000_000_000;
        int D = 1;

        int result = s.solution(X, Y, D);

        assertEquals(1000_000_000, result);
    }


    @Test
    public void test6() throws Exception {
        FrogJump s = new FrogJump();
        int X = 0;
        int Y = 1000_000_000;
        int D = 1000;

        int result = s.solution(X, Y, D);

        assertEquals(1000_000, result);
    }
}
