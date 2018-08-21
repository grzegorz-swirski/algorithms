package com.grzegorz.algorithms.client;

import com.grzegorz.algorithms.queues.RandomizedQueue;
import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator;

public class Permutation {

  public static void main(String[] args) {

    int k = Integer.parseInt(args[0]);

    RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
    for (int i = 0; i < k; i++) {
      randomizedQueue.enqueue(StdIn.readString());
    }

    int i = 0;
    Iterator<String> it = randomizedQueue.iterator();
    while (i < k) {
      System.out.println(it.next());
      i++;
    }
  }
}
