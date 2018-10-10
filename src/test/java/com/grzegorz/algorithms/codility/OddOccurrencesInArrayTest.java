package com.grzegorz.algorithms.codility;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;

public class OddOccurrencesInArrayTest {

    private final OddOccurrencesInArray s = new OddOccurrencesInArray();

    @Test
    public void test1() throws Exception {
        int[] test = new int[]{1};
        int res = s.solution(test);
        Assert.assertEquals(1, res);
    }

    @Test
    public void test2() throws Exception {
        int[] test = new int[]{1, 1, 1};
        int res = s.solution(test);
        Assert.assertEquals(1, res);
    }


    @Test
    public void test3() throws Exception {
        int[] test = new int[]{1, 1, 2};
        int res = s.solution(test);
        Assert.assertEquals(2, res);
    }

    @Test
    public void test4() throws Exception {
        int[] test = new int[]{9, 3, 9, 3, 9, 7, 9};
        int res = s.solution(test);
        Assert.assertEquals(7, res);
    }

    @Test
    public void test5() throws Exception {
        int[] test = new int[]{1, 1, 1, 2, 2};
        int res = s.solution(test);
        Assert.assertEquals(1, res);
    }


    @Test
    public void test6() throws Exception {
        int[] test = new int[]{2, 2, 1, 1, 1};
        int res = s.solution(test);
        Assert.assertEquals(1, res);
    }

    @Test
    public void test7() throws Exception {
        Integer[] test = new Integer[]{1, 1, 2, 2, 2, 2, 3};
        List<Integer> testList = Arrays.asList(test);
        Collections.shuffle(testList);

        assertEquals(3, s.solution(toArray(testList)));
    }

    @Test
    public void test8() throws Exception {
        Integer[] test = new Integer[]{1, 1, 2, 2, 2, 2, 3, 3, 3};
        List<Integer> testList = Arrays.asList(test);
        Collections.shuffle(testList);

        assertEquals(3, s.solution(toArray(testList)));
    }

    @Test
    public void testRandom1() throws Exception {
        Random r = new Random();

        int bound = 1000_000_000;
        int expected = r.nextInt(bound);
        int[] test = randomWithOdd(3, expected, bound);

        System.out.println(Arrays.toString(test));
        assertEquals(expected, s.solution(test));
    }

    @Test
    public void testRandom2() throws Exception {
        Random r = new Random();
        int bound = 1000_000_000;
        int expected = r.nextInt(bound);

        int[] test = randomWithOdd(3, expected, bound);

        System.out.println(Arrays.toString(test));
        assertEquals(expected, s.solution(test));
    }


    @Test
    public void testRandom3() throws Exception {
        Random r = new Random();
        int bound = 1000_000_000;
        int expected = r.nextInt(bound);

        int[] test = randomWithOdd(100, expected, bound);

        System.out.println(Arrays.toString(test));
        assertEquals(expected, s.solution(test));
    }


    private int[] randomWithOdd(int num, int oddValue, int bound) {
        Random r = new Random();

        List<Integer> test = new ArrayList<>();
        for (int i = 0; i < num * 2 - 1; i += 2) {
            int k = r.nextInt(bound);
            test.add(k);
            test.add(k);
        }

        test.add(oddValue);
        Collections.shuffle(test);
        return toArray(test);
    }

    private int[] toArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
