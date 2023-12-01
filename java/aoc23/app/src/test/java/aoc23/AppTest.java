package aoc23;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

public class AppTest {
    @Test
    public void testFileIsReadCorrectly(){
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("testInput");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        int result = 0;
        try {
            result = App.run(reader);
        } catch(Exception e) {
            System.err.println(e.toString());
            return;
        }
        assertEquals(20, result);
    }
}
