package com.grzegorz.algorithms.codility;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CountingExerciseTest {

    CountingExercise c = new CountingExercise();

    @Test
    public void countTest() throws Exception {
        int[] a = new int[]{2, 5, 3, 2};

        int[] result = c.count(a, 5);

        int[] expected = new int[]{0, 0, 2, 1, 0, 1};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void swapTest() throws Exception {
        int[] a = {2, 5, 3, 2};
        int[] b = {4, 5, 0, 1};
        assertTrue(c.canSwapToSum(a, b, 5));
    }


    @Test
    public void swapTestNegative1() throws Exception {
        int[] a = {2, 5, 3, 2};
        int[] b = {2, 5, 3, 1};
        assertFalse(c.canSwapToSum(a, b, 5));
    }

    @Test
    public void swapTestNegative2() throws Exception {
        int[] a = {1, 2, 3, 5};
        int[] b = {10, 20, 30, 41};
        assertFalse(c.canSwapToSum(a, b, 41));
    }

    @Test
    public void swapTestNegative3() throws Exception {
        int[] a = {10, 20, 30, 41};
        int[] b = {1, 2, 3, 5};
        assertFalse(c.canSwapToSum(a, b, 41));
    }
}

