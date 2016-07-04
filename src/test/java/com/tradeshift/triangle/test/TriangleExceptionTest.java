package com.tradeshift.triangle.test;

import com.tradeshift.triangle.Triangle;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Assume;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * This is a parameterized class which is in charge of checking if all the
 * exceptions which are except from the code throw properly or not. this class
 * is parameterized to pass a collections of different data to methods and
 * define what kind of exception class are expected.
 *
 * @author Azin
 */
@RunWith(value = Parameterized.class)
public class TriangleExceptionTest {

    /**
     * To define what kind of exception is expected.
     */
    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     *
     * Two different exceptions are expected in program.
     * <p>
     * 1)nullPointerException :
     * {@link  com.tradeshift.triangle.test.TriangleExceptionTest.ExceptionType#IS_NULL}
     * <p>
     * 2)illegalArgumentException
     * {@link  com.tradeshift.triangle.test.TriangleExceptionTest.ExceptionType#NOT_TRIANGLE},or
     * {@link  com.tradeshift.triangle.test.TriangleExceptionTest.ExceptionType#NOT_POSITIVE}.
     */
    public enum ExceptionType {

        /**
         * At least one of sides has not positive value
         */
        NOT_POSITIVE,
        /**
         * At least one of sides are equal or bigger than sum of two others.
         */
        NOT_TRIANGLE,
        /**
         * At least one of sides has null value
         */
        IS_NULL
    };

    /**
     * Type of exception which is used to define what collection of data should
     * pass to test method.
     */
    public final ExceptionType exceptionType;

    /**
     * Sides of triangle.
     */
    public final Integer sideA;
    public final Integer sideB;
    public final Integer sideC;

    /**
     * The type of exception class which are expected as a result of the method
     * under test.
     */
    public Class<? extends Exception> expectedResultException;

    /**
     *
     * @param exceptionType to determine what collections of data should pass to
     * a certain test method
     * @param sideA side A of triangle
     * @param sideB side B of triangle
     * @param sideC side C of triangle
     * @param expectedResultException exception class we are expected to be
     * return by the method under test
     */
    public TriangleExceptionTest(ExceptionType exceptionType, Integer sideA, Integer sideB, Integer sideC, Class<? extends Exception> expectedResultException) {
        this.exceptionType = exceptionType;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.expectedResultException = expectedResultException;
    }

    /**
     *
     * @return collections of data base on different ExceptionType and expected
     * exception class as a result of the under test method.
     */
    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {ExceptionType.NOT_POSITIVE, -5, 5, 5, IllegalArgumentException.class},
            {ExceptionType.NOT_POSITIVE, 5, -5, 5, IllegalArgumentException.class},
            {ExceptionType.NOT_POSITIVE, 5, 5, -5, IllegalArgumentException.class},
            {ExceptionType.NOT_POSITIVE, 0, 5, 5, IllegalArgumentException.class},
            {ExceptionType.NOT_POSITIVE, 5, 0, 5, IllegalArgumentException.class},
            {ExceptionType.NOT_POSITIVE, 5, 5, 0, IllegalArgumentException.class},
            {ExceptionType.NOT_POSITIVE, 0, 0, 5, IllegalArgumentException.class},
            {ExceptionType.NOT_POSITIVE, 5, 0, 0, IllegalArgumentException.class},
            {ExceptionType.NOT_POSITIVE, 0, 5, 0, IllegalArgumentException.class},
            {ExceptionType.NOT_POSITIVE, 0, 0, 0, IllegalArgumentException.class},
            {ExceptionType.NOT_POSITIVE, 0, -5, 5, IllegalArgumentException.class},
            {ExceptionType.NOT_TRIANGLE, 25, 5, 5, IllegalArgumentException.class},
            {ExceptionType.NOT_TRIANGLE, 2, 4, 6, IllegalArgumentException.class},
            {ExceptionType.NOT_TRIANGLE, 4, 9, 5, IllegalArgumentException.class},
            {ExceptionType.NOT_TRIANGLE, 2, 5, 1, IllegalArgumentException.class},
            {ExceptionType.IS_NULL, null, 5, 1, NullPointerException.class},});
    }

    /**
     * Check {@link  com.tradeshift.triangle.Triangle#isNotPositive()}if create
     *
     * @throw IllegalArgumentException.class in case having any zero or negative
     * sides
     */
    @Test()
    public void notPositiveSideShouldThrowIllegalArgumentException() {
        Assume.assumeTrue(exceptionType == ExceptionType.NOT_POSITIVE);
        if (expectedResultException != null) {
            exception.expect(expectedResultException);
        }
        assertEquals(sideA + "," + sideB + " and " + sideC + " at least one should be negetive!!", expectedResultException, new Triangle(sideA, sideB, sideC));

    }

    /**
     * Check if {@link  com.tradeshift.triangle.Triangle#isNotTriangle()} create
     *
     * @throws NullPointerException in case having any side with null value.
     */
    @Test()
    public void notTriangleShouldThrowRuntimeException() {
        Assume.assumeTrue(exceptionType == ExceptionType.NOT_TRIANGLE);
        if (expectedResultException != null) {
            exception.expect(expectedResultException);
        }

        assertEquals(sideA + "," + sideB + " and " + sideC + " sum of 2 sides should be greater than the last one!!", expectedResultException, new Triangle(sideA, sideB, sideC));

    }

    /**
     * Check if {@link  com.tradeshift.triangle.Triangle#isAnySideNull()} create
     *
     * @throw IllegalArgumentException in case having any null sides
     *
     */
    @Test()
    public void nullSideShouldThrowNullPointerException() {
        Assume.assumeTrue(exceptionType == ExceptionType.IS_NULL);
        if (expectedResultException != null) {
            exception.expect(expectedResultException);
        }
        assertEquals(sideA + "," + sideB + " and " + sideC + " one of sides should be Null!!", expectedResultException, new Triangle(sideA, sideB, sideC));

    }

}
