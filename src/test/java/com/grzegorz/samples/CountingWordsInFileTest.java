package com.grzegorz.samples;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CountingWordsInFileTest {

    private final String PATH = "src/test/resources/sample_input.txt";

    @Test
    public void countingWordsTest() throws IOException {
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String l;
            while ((l = reader.readLine()) != null) {
                String[] words = l.replaceAll("[.,;!?:]", "").split("[ ]");
                System.out.println(Arrays.toString(words));
                wordCount += words.length;
            }
        }

        Assert.assertEquals(79, wordCount);
    }

    @Test
    public void countingWordsWithStream() throws IOException {
        int wordCount;
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            wordCount = reader.lines()
                    .map(CountingWordsInFileTest::countWords)
                    .mapToInt(Integer::intValue)
                    .sum();
        }

        Assert.assertEquals(79, wordCount);
    }

    private static int countWords(String line) {
        String[] words = line.replaceAll("[.,;!?]", "").split(" ");
        return words.length;
    }
}
