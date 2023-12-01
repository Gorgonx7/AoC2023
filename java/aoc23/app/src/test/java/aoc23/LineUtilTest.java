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
    public void testReturnsOne(){
        int result = LineUtil.parse("10");
        assertEquals(1, result);
    }
    @Test
    public void testReturnsTwo(){
        int result = LineUtil.parse("11");
        assertEquals(2, result);
    }
    @Test
    public void testReturnsTwoSkipsChars(){
        int result = LineUtil.parse("1abc1");
        assertEquals(2, result);
    }
    @Test
    public void testReturnsTwoSkipsMiddleNumber(){
        int result = LineUtil.parse("1b2b1");
        assertEquals(2, result);
    }
    @Test
    public void testOneDiget(){
        int result = LineUtil.parse("nftdkmtmcz4");
        assertEquals(8, result);
    }
}
