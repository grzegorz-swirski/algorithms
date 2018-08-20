package com.grzegorz.algorithms.percolation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPercolation {

  private static final int GRID_DIM = 10;
  private Percolation percolation;

  @Before
  public void setup() {
    percolation = new Percolation(GRID_DIM);
  }

  @Test
  public void instantiate_zeroOpenSites() {
    Assert.assertEquals(0, percolation.numberOfOpenSites());
  }

  @Test
  public void openSite_siteOpened() throws Exception {
    percolation.open(1, 1);
    Assert.assertTrue(percolation.isOpen(1, 1));
  }

  @Test
  public void openSite_numberOfOpenSitesCorrect() throws Exception {
    Assert.assertEquals(0, percolation.numberOfOpenSites());
    percolation.open(2, 3);
    percolation.open(1, 8);

    Assert.assertEquals(2, percolation.numberOfOpenSites());
  }

  @Test
  public void openSite_alreadyOpen_numberOfOpenSitesNotChanged() throws Exception {
    percolation.open(1, 1);
    percolation.open(1, 1);
    Assert.assertEquals(1, percolation.numberOfOpenSites());
  }

  @Test
  public void allSitesOpen_percolates() {
    for (int i = 0; i < GRID_DIM; i++) {
      for (int j = 0; j < GRID_DIM; j++) {
        percolation.open(i + 1, j + 1);
      }
    }

    Assert.assertTrue(percolation.percolates());
  }

  @Test
  public void allSitesInColumnOpen_percolates() throws Exception {
    openAllInFirstColumn();
    Assert.assertTrue(percolation.percolates());
    Assert.assertTrue(percolation.isFull(GRID_DIM, 1));
  }

  private void openAllInFirstColumn() {
    for (int i = 0; i < GRID_DIM; i++) {
      percolation.open(i + 1, 1);
    }
  }

  @Test
  public void percolates_doesNotBackwash() {
    openAllInFirstColumn();
    percolation.open(GRID_DIM, 3);
    Assert.assertFalse(percolation.isFull(GRID_DIM, 3));
  }
}
