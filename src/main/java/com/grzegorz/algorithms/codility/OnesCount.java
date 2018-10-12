package com.grzegorz.algorithms.codility;

public class OnesCount {
    public int solution(int A, int B) {
        int product = A * B;
        String binaryString = Integer.toBinaryString(product);
        System.out.println(binaryString);

        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                count += 1;
            }
        }

        System.out.println("count = " + count);
        return count;
    }
}
