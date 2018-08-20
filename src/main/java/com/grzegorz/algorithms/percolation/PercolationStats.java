package com.grzegorz.algorithms.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

  private final int trialsNum;
  private final double[] results;

  private double mean;
  private double stddev;
  private double confidenceLo;
  private double confidenceHi;

  public PercolationStats(int n, int trials) {
    if (n <= 0 || trials <= 0) {
      throw new IllegalArgumentException(
          "Number of experiments and number of trials must be greater than 0");
    }

    this.trialsNum = trials;
    this.results = new double[trials];

    for (int i = 0; i < trialsNum; i++) {
      results[i] = calculatePercolationThreshold(n);
    }
  }

  private double calculatePercolationThreshold(int n) {
    Percolation p = new Percolation(n);
    while (!p.percolates()) {
      int randomRow = StdRandom.uniform(1, n + 1);
      int randomCol = StdRandom.uniform(1, n + 1);
      p.open(randomRow, randomCol);
    }

    int totalSites = n * n;
    return (double) p.numberOfOpenSites() / (double) totalSites;
  }

  public double mean() {
    if (mean == 0.0) {
      mean = StdStats.mean(results);
    }
    return mean;
  }

  public double stddev() {
    if (stddev == 0.0) {
      stddev = StdStats.stddev(results);
    }
    return stddev;
  }

  public double confidenceLo() {
    if (confidenceLo == 0.0) {
      confidenceLo = mean() - ((1.96 * stddev()) / Math.sqrt(trialsNum));
    }
    return confidenceLo;
  }

  public double confidenceHi() {
    if (confidenceHi == 0.0) {
      confidenceHi = mean() + ((1.96 * stddev()) / Math.sqrt(trialsNum));
    }
    return confidenceHi;
  }

  public static void main(String[] args) {
    if (args.length < 2) {
      throw new IllegalArgumentException("Provide 2 arguments n and t, "
          + "representing n by n grid with t computational experiments.");
    }
    int gridDim = Integer.parseInt(args[0]);
    int trialsNum = Integer.parseInt(args[1]);

    PercolationStats stats = new PercolationStats(gridDim, trialsNum);
    System.out.println(String.format("mean                    = %s", stats.mean()));
    System.out.println(String.format("stddev                  = %s", stats.stddev()));
    System.out.println(String.format("95%% confidence interval = [%s, %s]",
        stats.confidenceLo(), stats.confidenceHi()));
  }
}
