package com.grzegorz.algorithms.other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OtherTests {

    @Test
    public void testMaxArraySize() throws Exception {

        // [0 : k) OK
        // [k : l) Java heap space error
        // [l : Integer.MAX_VALUE - 1] Not allowed by VM <--- searching for l
        // > Integer.MAX_VALUE compiler error (array size is initialized with int)

        MaxArraySize test = new MaxArraySize();
        System.out.println("Maximum allowed by compiler is " + Integer.MAX_VALUE);

        int firstExceedingVmLimit = test.findMaxArrayLimit();
        System.out.println("Maximum integer array size found is " + firstExceedingVmLimit);
        System.out.println("Megabytes = " + intsNumToMegabytes(firstExceedingVmLimit));


        // verify previous fails because of heap space
        try {
            int[] bigArray = new int[firstExceedingVmLimit - 1];
        } catch (OutOfMemoryError e) {
            assertEquals("Java heap space", e.getMessage());
        }

        // verify found if first failing because of VM limit
        try {
            int[] bigArray = new int[firstExceedingVmLimit];
        } catch (OutOfMemoryError e) {
            assertEquals("Requested array size exceeds VM limit", e.getMessage());
        }

        // verify all in range of found to Integer.MAX_VALUE fail because of VM limit
        for (int i = firstExceedingVmLimit; i >= 0 && i <= Integer.MAX_VALUE; i++) {
            try {
                int[] bigArray = new int[i];
            } catch (OutOfMemoryError e) {
                assertEquals("Requested array size exceeds VM limit", e.getMessage());
                System.out.println("Exceeding VM limit: " + i);
            }
        }

    }

    private double intsNumToMegabytes(int num) {
        double dNum = (double) num;
        double bytesNum = dNum * 4;
        double kilobytesNum = bytesNum / 1000;
        return kilobytesNum / 1000;
    }
}
