package edu.yu.intro.test;

import edu.yu.intro.JUnit4SqrtApproximation;
import org.junit.*;

import static org.junit.Assert.*;


public class SqrtApproximationTest{
    @Test(expected = RuntimeException.class)
    public void sqrtRootCalculationInputCantBeNegative(){
        JUnit4SqrtApproximation.sqrt(-1);
    }

    @Test(expected = RuntimeException.class)
    public void calculateSquareRootsInputCantBeNegative(){
        JUnit4SqrtApproximation.calculateSquareRoots(-1);
    }

    @Test 
    public void sqrt0(){
        assertEquals("Testing sqrt of 0", Math.sqrt(0), JUnit4SqrtApproximation.sqrt(0), 0.1);
    }

    @Test 
    public void sqrt2(){
        assertEquals("Testing sqrt of 2", Math.sqrt(2), JUnit4SqrtApproximation.sqrt(2), 0.1);
    }

    @Test
    public void sqrt42(){
        assertEquals("Testing sqrt of 42", Math.sqrt(42), JUnit4SqrtApproximation.sqrt(42), 0.1);
    }

    @Test
    public void sqrt10(){
        assertEquals("Testing sqrt of 10", Math.sqrt(10), JUnit4SqrtApproximation.sqrt(10), 0.1);
    }

    /** Verify that the implementation code
    * supplies the correct Array for the
    * smallest valid ‘‘ square root array ’’
    * ( under the API ’s assumptions ).
    *
    * In other words : this is a test that
    * the implementation code handles an
    * ‘‘edge case ’’ correctly
    */
    @Test
    public void calculateSquareRootsMinimalLength(){
        assertArrayEquals("Testing calculateSqrts with 0", new double[]{Math.sqrt(0)}, JUnit4SqrtApproximation.calculateSquareRoots(0), 0.1);
    }

    /** Verify that the implementation code
    * supplies the correct Array for some
    * reasonable (non-edge-case) input
    * parameter.
    */
    @Test
    public void calculateSquareRootsHappyPaths(){
        assertArrayEquals("Testing calculateSqrts with 3", new double[]{Math.sqrt(0), Math.sqrt(1), Math.sqrt(2), Math.sqrt(3)}, JUnit4SqrtApproximation.calculateSquareRoots(3), 0.1);
    }

}