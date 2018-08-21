package com.grzegorz.algorithms.deques;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

  private int size;
  private Node first = null;
  private Node last = null;

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void addFirst(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    Node oldFirst = first;
    first = new Node(item);
    if (oldFirst != null) {
      oldFirst.previous = first;
      first.next = oldFirst;
    }
    if (last == null) {
      last = first;
    }
    size++;
  }

  public void addLast(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    Node oldLast = last;
    last = new Node(item);
    if (oldLast != null) {
      oldLast.next = last;
      last.previous = oldLast;
    }
    if (first == null) {
      first = last;
    }
    size++;
  }

  public Item removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    size--;
    Node oldFirst = first;

    if (last == first) {
      first = null;
      last = null;
      return oldFirst.item;
    }

    first = oldFirst.next;
    return oldFirst.item;
  }

  public Item removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    size--;
    Node oldLast = last;

    if (first == last) {
      last = null;
      first = null;
      return oldLast.item;
    }

    last = oldLast.previous;
    last.next = null;
    return oldLast.item;
  }

  @Override
  public Iterator<Item> iterator() {
    return new DequeIterator();
  }

  private class DequeIterator implements Iterator<Item> {

    private Node nextNode;

    public DequeIterator() {
      nextNode = first;
    }

    @Override
    public boolean hasNext() {
      return nextNode != null;
    }

    @Override
    public Item next() {
      if (isEmpty() || !hasNext()) {
        throw new NoSuchElementException();
      }
      Item item = nextNode.item;
      nextNode = nextNode.next;
      return item;
    }
  }

  private class Node {

    private Node previous;
    private Node next;
    private final Item item;

    public Node(Item item) {
      this.item = item;
    }
  }
}
