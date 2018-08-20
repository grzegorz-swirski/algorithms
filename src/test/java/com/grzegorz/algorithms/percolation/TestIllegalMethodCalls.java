package com.grzegorz.algorithms.percolation;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestIllegalMethodCalls {

  private static final Percolation p = new Percolation(100);

  private int rowNum;
  private int colNum;

  public TestIllegalMethodCalls(int rowNum, int colNum) {
    this.rowNum = rowNum;
    this.colNum = colNum;
  }

  @Parameters
  public static Collection<Integer[]> data() {
    return Arrays.asList(new Integer[][]{
        {-1, -1},
        {-1, 0},
        {0, -1},
        {0, 0},
        {5, -1},
        {-1, 5},
        {5, 0},
        {0, 5},
        {1, 101},
        {101, 1}
    });
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOpen() throws Exception {
    p.open(rowNum, colNum);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIsOpen() {
    p.isOpen(rowNum, colNum);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIsFull() throws Exception {
    p.isFull(rowNum, colNum);
  }
}
