package com.grzegorz.algorithms.codility;

import java.util.ArrayList;
import java.util.List;

public class EratosthenesSieve {

    public List<Integer> primes(int max) {
        int count = max + 1;
        boolean[] isPrime = new boolean[count];

        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < count; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < count; i++) {
            for (int j = i * i; j < count; j += i) {
                isPrime[j] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
