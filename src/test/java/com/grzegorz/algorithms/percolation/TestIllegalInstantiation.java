package com.grzegorz.algorithms.percolation;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestIllegalInstantiation {

  private int param;

  public TestIllegalInstantiation(int param) {
    this.param = param;
  }

  @Parameters
  public static Collection<Integer[]> data() {
    return Arrays.asList(
        new Integer[]{-100},
        new Integer[]{-1},
        new Integer[]{0});
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalInstantiation() throws Exception {
    new Percolation(param);
  }
}
