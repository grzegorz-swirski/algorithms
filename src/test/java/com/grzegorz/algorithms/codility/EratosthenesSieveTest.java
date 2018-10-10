package com.grzegorz.algorithms.codility;

import org.junit.Assert;
import org.junit.Test;

public class EratosthenesSieveTest {

    @Test
    public void sieveTest() throws Exception {
        Integer[] expected = new Integer[]{
                2, 3, 5, 7, 11, 13, 17, 19, 23,
                29, 31, 37, 41, 43, 47, 53, 59,
                61, 67, 71, 73, 79, 83, 89, 97
        };

        Integer[] actual = new EratosthenesSieve().primes(97);

        Assert.assertArrayEquals(expected, actual);
    }
}
