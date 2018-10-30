package com.grzegorz.algorithms.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    private BinarySearch f = new BinarySearch();
    private int[] a = new int[] {12, 15, 15, 19, 24, 31, 53, 59, 60};

    @Test
    public void test() {
        int pos = f.findIndex(19, a);
        assertEquals(3, pos);
    }

    @Test
    public void testNegative() {
        int pos = f.findIndex(13, a);
        assertEquals(-1, pos);
    }

    @Test
    public void testNegativeBigValue() {
        int pos = f.findIndex(565432, a);
        assertEquals(-1, pos);
    }

    @Test
    public void testNegativeSmallValue() {
        int pos = f.findIndex(0, a);
        assertEquals(-1, pos);
    }
}
