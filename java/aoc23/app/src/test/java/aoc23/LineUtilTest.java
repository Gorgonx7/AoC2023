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
    public void testOneReturnsZero(){
        int result = LineUtil.findFirstWordIndex("one");
        assertEquals(0, result);
    }
    @Test
    public void testabconeReturnsThree(){
        int result = LineUtil.findFirstWordIndex("abcone");
        assertEquals(3, result);
    }
    @Test
    public void testabcOneReturnsThree(){
        int result = LineUtil.findFirstWordIndex("abcOne");
        assertEquals(3,result);
    }
    @Test
    public void testTwoOneTwoReturnsZero(){
        int result = LineUtil.findFirstWordIndex("twoOnetwo");
        assertEquals(0,result);
    }
    /* 
     * findLastWordIndex tests
    */
    @Test
    public void testLastOneReturnsZero(){
        int result = LineUtil.findLastWordIndex("one");
        assertEquals(0, result);
    }
    @Test
    public void testLastabconeReturnsThree(){
        int result = LineUtil.findLastWordIndex("abcone");
        assertEquals(3, result);
    }
    @Test
    public void testLastabcOneReturnsThree(){
        int result = LineUtil.findLastWordIndex("abcOne");
        assertEquals(3,result);
    }
    @Test
    public void testLastTwoOneTwoReturns6(){
        int result = LineUtil.findLastWordIndex("twoOnetwo");
        assertEquals(6,result);
    }
}
