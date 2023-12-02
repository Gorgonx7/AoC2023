package aoc23;

import static org.junit.Assert.assertEquals;

import javax.sound.sampled.Line;

import org.junit.Test;

public class LineUtilTest {
    @Test
    public void testReturnsZero(){
        int result = LineUtil.parse("00");
        assertEquals(0, result);
    }
    @Test
    public void testReturnsTen(){
        int result = LineUtil.parse("10");
        assertEquals(10, result);
    }
    @Test
    public void testReturnsEleven(){
        int result = LineUtil.parse("11");
        assertEquals(11, result);
    }
    @Test
    public void testSkipsChars(){
        int result = LineUtil.parse("1abc1");
        assertEquals(11, result);
    }
    @Test
    public void testSkipsMiddleNumber(){
        int result = LineUtil.parse("1b2b1");
        assertEquals(11, result);
    }
    @Test
    public void testOneDiget(){
        int result = LineUtil.parse("nftdkmtmcz4");
        assertEquals(44, result);
    }
    @Test
    public void testOneDigetAndWord(){
        int result = LineUtil.parse("onenftdkmtmcz4");
        assertEquals(14, result);
    }
    /* 
     * findFirstWordIndex tests
    */
    @Test
    public void testOneReturnsOne(){
        String result = LineUtil.findFirstWord("one");
        assertEquals("one", result);
    }
    @Test
    public void testabconeReturnsOne(){
        String result = LineUtil.findFirstWord("abcone");
        assertEquals("one", result);
    }
    @Test
    public void testabcOneReturnsOne(){
        String result = LineUtil.findFirstWord("abcOne");
        assertEquals("one",result);
    }
    @Test
    public void testTwoOneTwoReturnsTwo(){
        String result = LineUtil.findFirstWord("twoOnetwo");
        assertEquals("two",result);
    }
    /* 
     * findLastWordIndex tests
    */
    @Test
    public void testLastOneReturnsOne(){
        String result = LineUtil.findLastWord("one");
        assertEquals("one", result);
    }
    @Test
    public void testLastabconeReturnsOne(){
        String result = LineUtil.findLastWord("abcone");
        assertEquals("one", result);
    }
    @Test
    public void testLastabcOneReturnsOne(){
        String result = LineUtil.findLastWord("abcOne");
        assertEquals("one",result);
    }
    @Test
    public void testLastTwoOneThreeReturnsThree(){
        String result = LineUtil.findLastWord("twoOnethree");
        assertEquals("three",result);
    }
}
