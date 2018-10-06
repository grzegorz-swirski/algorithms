package com.grzegorz.algorithms.codility;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SingleBracketsTests {

    private final SingleBrackets brackets = new SingleBrackets();

    @Test
    public void testEmpty() throws Exception {
        String empty = "";
        assertEquals(1, brackets.solution(empty));
    }

    @Test
    public void samplePositive() throws Exception {
        String pos = "(()(())())";
        assertEquals(1, brackets.solution(pos));
    }

    @Test
    public void sampleNegative() throws Exception {
        String neg = "())";
        assertEquals(0, brackets.solution(neg));
    }

    @Test
    public void testNestedVW() throws Exception {
        String nested = "((()()))((()()))";
        assertEquals(1, brackets.solution(nested));
    }

    @Test
    public void testUneven() throws Exception {
        String uneven = "((())";
        assertEquals(0, brackets.solution(uneven));
    }


    @Test
    public void moreOpeningThanClosing() throws Exception {
        String moreOpening = "(((((())))";
        assertEquals(0, brackets.solution(moreOpening));
    }

    @Test
    public void moreClosingThanOpening() throws Exception {
        String moreClosing = "((()))))))";
        assertEquals(0, brackets.solution(moreClosing));
    }

}
