package edu.yu.intro.test;

import org.junit.*;
import static org.junit.Assert.*;

import edu.yu.intro.AckermannFn;

public class AckermannFnTest{
    @Test
    public void test0_2(){
        assertEquals("Testing (0, 2) is 3", 3, AckermannFn.ackermann(0, 2));
    }

    @Test
    public void test1_2(){
        assertEquals("Testing (1, 2) is 3", 4, AckermannFn.ackermann(1, 2));
    }
    
    @Test
    public void test2_2(){
        assertEquals("Testing (2, 2) is 3", 7, AckermannFn.ackermann(2, 2));
    }
}