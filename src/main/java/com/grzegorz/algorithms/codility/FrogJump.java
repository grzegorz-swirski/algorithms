package com.grzegorz.algorithms.codility;

class FrogJump {
    public int solution(int X, int Y, int D) {
        int distance = Y - X;
        if (distance % D == 0) {
            return distance / D;
        }
        return (distance / D) + 1;
    }
}