package com.grzegorz.algorithms.queues;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RandomizedQueueTests {

  private RandomizedQueue<String> randomizedQueue;

  @Before
  public void setup() {
    randomizedQueue = new RandomizedQueue<>();
  }

  @Test(expected = IllegalArgumentException.class)
  public void enqueue_nullArgument_throwIllegalArgument() throws Exception {
    randomizedQueue.enqueue(null);
  }

  @Test(expected = NoSuchElementException.class)
  public void sample_emptyQueue_throwNoSuchElement() throws Exception {
    randomizedQueue.sample();
  }

  @Test(expected = NoSuchElementException.class)
  public void dequeue_emptyQueue_throwNoSuchElement() throws Exception {
    randomizedQueue.dequeue();
  }

  @Test(expected = UnsupportedOperationException.class)
  public void getIterator_callRemove_throwUnsupportedOperation() throws Exception {
    randomizedQueue.iterator().remove();
  }

  @Test(expected = NoSuchElementException.class)
  public void iteratorNext_noMoreItems_throwNoSuchElement() throws Exception {
    Iterator<String> it = randomizedQueue.iterator();
    Assert.assertFalse(it.hasNext());
    it.next();
  }

  @Test
  public void enqueue_wasEmpty_containsOne() throws Exception {
    randomizedQueue.enqueue("A");
    Assert.assertEquals(1, randomizedQueue.size());
    Assert.assertFalse(randomizedQueue.isEmpty());
  }

  @Test
  public void dequeue_containedTwo_containsOne() throws Exception {
    Set<String> samples = new HashSet<>();
    samples.add("A");
    samples.add("B");
    for (String s : samples) {
      randomizedQueue.enqueue(s);
    }
    Assert.assertEquals(2, randomizedQueue.size());

    String randomItem = randomizedQueue.dequeue();

    Assert.assertEquals(1, randomizedQueue.size());
    Assert.assertTrue(samples.contains(randomItem));
  }

  @Test
  public void dequeue_manyItems_dequeuedNotPresent() throws Exception {
    for (int i = 0; i < 10; i++) {
      String uniqueStr = UUID.randomUUID().toString();
      randomizedQueue.enqueue(uniqueStr);
    }

    String randomItem = randomizedQueue.dequeue();
    Assert.assertFalse(exists(randomItem, randomizedQueue));
  }

  private boolean exists(String item, RandomizedQueue<String> queue) {
    for (String s : queue) {
      if (item.equals(s)) {
        return true;
      }
    }
    return false;
  }

  @Test
  public void enqueue_exceedsInitialCapacity_capacityIncreases() throws Exception {
    for (int i = 0; i < 11; i++) {
      randomizedQueue.enqueue(UUID.randomUUID().toString());
    }
  }

  @Test
  public void dequeueIntegrationTest() throws Exception {
    int itemsNum = 7;
    Set<String> samples = enqueueUniqueSamples(randomizedQueue, itemsNum);

    Set<String> visited = new HashSet<>();
    for (int i = 0; i < itemsNum; i++) {
      String retrievedSample = randomizedQueue.dequeue();
      Assert.assertFalse(visited.contains(retrievedSample));
      Assert.assertTrue(samples.contains(retrievedSample));
      visited.add(retrievedSample);
    }

    Assert.assertTrue(randomizedQueue.isEmpty());
  }

  @Test
  public void iteratorTest() throws Exception {
    int itemsNum = 7;
    Set<String> samples = enqueueUniqueSamples(randomizedQueue, itemsNum);

    int iterationsNum = 0;
    Set<String> visited = new HashSet<>();
    for (String item : randomizedQueue) {
      Assert.assertFalse(visited.contains(item));
      Assert.assertTrue(samples.contains(item));
      visited.add(item);
      iterationsNum++;
    }

    Assert.assertEquals(itemsNum, randomizedQueue.size());
    Assert.assertEquals(itemsNum, iterationsNum);
  }

  private Set<String> enqueueUniqueSamples(RandomizedQueue<String> queue, int samplesNum) {
    Set<String> samples = new HashSet<>();
    for (int i = 0; i < samplesNum; i++) {
      String sample = UUID.randomUUID().toString();
      queue.enqueue(sample);
      samples.add(sample);
    }
    return samples;
  }

  @Test
  public void sample_returnsRandomElement() throws Exception {
    Set<String> samples = enqueueUniqueSamples(randomizedQueue, 100);
    for (int i = 0; i < 1000; i++) {
      String item = randomizedQueue.sample();
      Assert.assertTrue(samples.contains(item));
    }
    Assert.assertEquals(100, randomizedQueue.size());
  }

  @Test
  public void enqueueAndDequeue() throws Exception {
    RandomizedQueue<Integer> rq = new RandomizedQueue<>();
    rq.enqueue(4);
    Assert.assertEquals(new Integer(4), rq.dequeue());

    rq.enqueue(5);
    Assert.assertEquals(new Integer(5), rq.dequeue());
  }
}
