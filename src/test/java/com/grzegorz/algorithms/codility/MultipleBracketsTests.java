package com.grzegorz.algorithms.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultipleBracketsTests {

    private final MultipleBrackets solution = new MultipleBrackets();

    @Test
    public void testEmpty() throws Exception {
        assertEquals(1, solution.solution(""));
    }

    @Test
    public void testNested() throws Exception {
        String nested = "{[()()]}";
        assertEquals(1, solution.solution(nested));
    }

    @Test
    public void testNestedVW() throws Exception {
        String nested = "{[()()]}{[()()]}";
        assertEquals(1, solution.solution(nested));
    }

    @Test
    public void testUneven() throws Exception {
        String uneven = "{[()]";
        assertEquals(0, solution.solution(uneven));
    }

    @Test
    public void testNotNested() throws Exception {
        String notNested = "{[)[)}";
        assertEquals(0, solution.solution(notNested));
    }

    @Test
    public void moreOpeningThanClosing() throws Exception {
        String moreOpening = "({[({[]})]";
        assertEquals(0, solution.solution(moreOpening));
    }

    @Test
    public void moreClosingThanOpening() throws Exception {
        String moreClosing = "([{}])}]";
        assertEquals(0, solution.solution(moreClosing));
    }
}
