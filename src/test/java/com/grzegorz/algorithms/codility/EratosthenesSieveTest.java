package com.grzegorz.algorithms.codility;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EratosthenesSieveTest {

    @Test
    public void sieveTest() throws Exception {
        List<Integer> expected = new ArrayList<>(Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23,
                29, 31, 37, 41, 43, 47, 53, 59,
                61, 67, 71, 73, 79, 83, 89, 97));

        List<Integer> actual = new EratosthenesSieve().primes(97);

        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i), actual.get(i));
        }
    }
}
