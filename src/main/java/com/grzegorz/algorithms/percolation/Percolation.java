package com.grzegorz.algorithms.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

  private final int gridDim;
  private final boolean[] sites;
  private final int virtualTop;
  private final int virtualBottom;
  private int openSitesNum;
  private WeightedQuickUnionUF uf;
  private WeightedQuickUnionUF ufNoVirtualBottom;

  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException();
    }
    gridDim = n;
    int sitesNum = n * n;
    sites = new boolean[sitesNum];

    uf = new WeightedQuickUnionUF(sitesNum + 2);
    ufNoVirtualBottom = new WeightedQuickUnionUF(sitesNum + 1);

    virtualTop = uf.count() - 2;
    virtualBottom = uf.count() - 1;

    for (int i = 1; i <= gridDim; i++) {
      uf.union(virtualTop, site(1, i));
      ufNoVirtualBottom.union(virtualTop, site(1, i));
      uf.union(virtualBottom, site(gridDim, i));
    }
  }

  public void open(int row, int col) {
    verifyExists(row, col);
    if (!isOpen(row, col)) {
      sites[site(row, col)] = true;
      openSitesNum++;
      unionWithOpenAdjacentSites(row, col);
    }
  }

  private void verifyExists(int row, int col) {
    if (!exists(row, col)) {
      throw new IllegalArgumentException();
    }
  }

  private boolean exists(int row, int col) {
    return row > 0 && col > 0 && row <= gridDim && col <= gridDim;
  }

  private void unionWithOpenAdjacentSites(int row, int col) {
    int currentSite = site(row, col);
    unionIfExistsAndOpen(currentSite, row - 1, col);
    unionIfExistsAndOpen(currentSite, row + 1, col);
    unionIfExistsAndOpen(currentSite, row, col - 1);
    unionIfExistsAndOpen(currentSite, row, col + 1);
  }

  private void unionIfExistsAndOpen(int site, int otherRow, int otherCol) {
    if (exists(otherRow, otherCol) && isOpen(otherRow, otherCol)) {
      uf.union(site, site(otherRow, otherCol));
      ufNoVirtualBottom.union(site, site(otherRow, otherCol));
    }
  }

  private int site(int row, int col) {
    verifyExists(row, col);
    return gridDim * (row - 1) + col - 1;
  }

  public boolean isOpen(int row, int col) {
    verifyExists(row, col);
    return sites[site(row, col)];
  }

  public boolean isFull(int row, int col) {
    verifyExists(row, col);
    return isOpen(row, col)
        && ufNoVirtualBottom.connected(site(row, col), virtualTop);
  }

  public int numberOfOpenSites() {
    return openSitesNum;
  }

  public boolean percolates() {
    return uf.connected(virtualBottom, virtualTop);
  }
}
