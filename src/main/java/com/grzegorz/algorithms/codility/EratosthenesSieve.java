package com.grzegorz.algorithms.codility;

import java.util.ArrayList;
import java.util.List;

public class EratosthenesSieve {

    public Integer[] primes(int max) {
        int count = max + 1;
        boolean[] isPrime = new boolean[count];

        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < count; i++) {
            isPrime[i] = true;
        }

        int opsCount = 0;
        for (int i = 2; i * i < count; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < count; j += i) {
                    isPrime[j] = false;
                    opsCount += 1;
                }
            }
        }
        System.out.println("OPERATIONS COUNT = " + opsCount);


        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int primesCount = primes.size();
        System.out.println("PRIMES COUNT: " + primesCount);
        System.out.println("COMPOSITES COUNT: " + (count - primesCount));

        Integer[] result = new Integer[primesCount];
        return primes.toArray(result);
    }
}
