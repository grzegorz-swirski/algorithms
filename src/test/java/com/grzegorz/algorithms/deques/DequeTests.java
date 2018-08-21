package com.grzegorz.algorithms.deques;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DequeTests {

  private Deque<String> stringDeque;

  @Before
  public void setup() {
    stringDeque = new Deque<>();
  }

  @Test
  public void constructDeque_empty() {
    Assert.assertTrue(stringDeque.isEmpty());
    Assert.assertEquals(0, stringDeque.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void addFirst_nullArg_throwIllegalArgument() throws Exception {
    stringDeque.addFirst(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void addLast_nullArg_throwIllegalArgument() throws Exception {
    stringDeque.addLast(null);
  }

  @Test(expected = NoSuchElementException.class)
  public void removeFirst_emptyDeque_noSuchElement() throws Exception {
    stringDeque.removeFirst();
  }

  @Test(expected = NoSuchElementException.class)
  public void removeLast_emptyDeque_noSuchElement() throws Exception {
    stringDeque.removeLast();
  }

  @Test(expected = NoSuchElementException.class)
  public void iteratorNext_emptyDeque_noSuchElement() throws Exception {
    stringDeque.iterator().next();
  }

  @Test(expected = UnsupportedOperationException.class)
  public void iteratorRemove_unsupportedOperation() throws Exception {
    stringDeque.iterator().remove();
  }

  @Test
  public void addFirstAndLast_wasEmpty_containsTwo() throws Exception {
    stringDeque.addFirst("abc");
    stringDeque.addLast("abc");
    Assert.assertEquals(2, stringDeque.size());
    Assert.assertFalse(stringDeque.isEmpty());
  }

  @Test
  public void addFirst_removeFirst_sameElementReturned() {
    stringDeque.addFirst("abc");
    Assert.assertEquals("abc", stringDeque.removeFirst());
  }

  @Test
  public void addFirst_removeLast_sameElementReturned() throws Exception {
    stringDeque.addFirst("abc");
    Assert.assertEquals("abc", stringDeque.removeLast());
  }

  @Test
  public void addFirst_removeFirst_empty() throws Exception {
    stringDeque.addFirst("a");
    stringDeque.removeFirst();
    Assert.assertTrue(stringDeque.isEmpty());
  }

  @Test
  public void addFirst_removeLast_empty() throws Exception {
    stringDeque.addFirst("a");
    stringDeque.removeLast();
    Assert.assertTrue(stringDeque.isEmpty());
  }

  @Test
  public void addFirst_removeLastAndFirst_returningCorrectValues() throws Exception {
    Deque<Integer> deque = new Deque<>();
    Assert.assertEquals(0, deque.size());

    deque.addFirst(2);
    Integer removedLast = deque.removeLast();
    Assert.assertEquals(new Integer(2), removedLast);

    deque.addFirst(4);
    Integer removedFirst = deque.removeFirst();
    Assert.assertEquals(new Integer(4), removedFirst);

    deque.addFirst(6);
    removedLast = deque.removeLast();
    Assert.assertEquals(new Integer(6), removedLast);
  }

  @Test
  public void testLeftStack() throws Exception {
    int stringsNum = 10;
    String[] randomStrings = generateRandomStrings(stringsNum);

    for (int i = 0; i < stringsNum; i++) {
      stringDeque.addFirst(randomStrings[i]);
    }

    for (int i = stringsNum - 1; i > 0; i--) {
      Assert.assertEquals(randomStrings[i], stringDeque.removeFirst());
    }
  }

  @Test
  public void testRightStack() throws Exception {
    int stringsNum = 10;
    String[] randomStrings = generateRandomStrings(stringsNum);

    for (int i = 0; i < stringsNum; i++) {
      stringDeque.addLast(randomStrings[i]);
    }

    for (int i = stringsNum - 1; i > 0; i--) {
      Assert.assertEquals(randomStrings[i], stringDeque.removeLast());
    }
  }

  @Test
  public void testQueue() {
    int stringsNum = 10;
    String[] randomStrings = generateRandomStrings(stringsNum);

    for (int i = 0; i < stringsNum; i++) {
      stringDeque.addFirst(randomStrings[i]);
    }

    for (int i = 0; i < stringsNum; i++) {
      Assert.assertEquals(randomStrings[i], stringDeque.removeLast());
    }
  }

  @Test
  public void testIterator() throws Exception {
    String[] randomStrings = generateRandomStrings(10);
    for (String s : randomStrings) {
      stringDeque.addFirst(s);
    }

    Iterator<String> it = stringDeque.iterator();
    Assert.assertTrue(it.hasNext());
    int i = randomStrings.length - 1;
    while (it.hasNext()) {
      Assert.assertEquals(randomStrings[i], it.next());
      i--;
    }
    Assert.assertEquals(-1, i);
  }

  @Test(expected = NoSuchElementException.class)
  public void testIterator_noNextElement_throwNoSuchElement() throws Exception {
    stringDeque.addFirst("A");
    Iterator<String> it = stringDeque.iterator();
    it.next();
    it.next();
  }

  private String[] generateRandomStrings(int num) {
    String[] randomStrings = new String[num];
    for (int i = 0; i < num; i++) {
      randomStrings[i] = UUID.randomUUID().toString();
    }
    return randomStrings;
  }

  @Test
  public void integrationTest() throws Exception {
    Deque<Integer> deque = new Deque<>();
    deque.addLast(1);
    deque.addFirst(2);
    deque.addFirst(3);
    deque.removeLast();

    Iterator<Integer> it = deque.iterator();
    Assert.assertEquals(new Integer(3), it.next());
    Assert.assertEquals(new Integer(2), it.next());
    Assert.assertFalse(it.hasNext());
  }
}
