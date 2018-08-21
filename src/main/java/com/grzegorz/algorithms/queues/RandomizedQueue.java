package com.grzegorz.algorithms.queues;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

  private static final int INITIAL_CAPACITY = 10;

  private int capacity;
  private int size;
  private int currentIndex;
  private Item[] elements;

  public RandomizedQueue() {
    capacity = INITIAL_CAPACITY;
    elements = (Item[]) new Object[capacity];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void enqueue(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }

    if (capacity == currentIndex) {
      resize(capacity * 2);
    }

    elements[currentIndex] = item;
    currentIndex++;
    size++;
  }

  private void resize(int max) {
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < elements.length; i++) {
      temp[i] = elements[i];
    }
    elements = temp;
    capacity = max;
  }

  // removes and returns a random element
  public Item dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    int index = StdRandom.uniform(size);
    Item value = elements[index];
    elements[index] = elements[size - 1];
    elements[size - 1] = null;
    size--;
    currentIndex--;
    return value;
  }

  // returns a random element
  public Item sample() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    int index = StdRandom.uniform(size);
    return elements[index];
  }

  // iterates over the elements in random order
  public Iterator<Item> iterator() {
    return new RandomizedQueueIterator();
  }

  private class RandomizedQueueIterator implements Iterator<Item> {

    int currentIndex;
    private final Item[] elementsCopy = (Item[]) new Object[size];

    public RandomizedQueueIterator() {
      System.arraycopy(elements, 0, elementsCopy, 0, size);
      StdRandom.shuffle(elementsCopy);
    }

    @Override
    public boolean hasNext() {
      return currentIndex <= size - 1;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      Item element = elementsCopy[currentIndex];
      currentIndex++;
      return element;
    }
  }
}
