package com.tradeshift.triangle.test;

import com.tradeshift.triangle.Triangle;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.hamcrest.CoreMatchers.not;

/**
 * This is a parameterized class which is in charge of determining the kind of
 * Triangle. it means in case we know three numbers make a triangle this class
 * will test that program return the right type of triangle.
 * <p>
 * ({@link  com.tradeshift.triangle.Triangle#getTriangleType()})
 * <p>
 * this class is responsible to check if triangle is a
 * ({@link  com.tradeshift.triangle.test.TriangleTypeTest.TriangleType#SCALENE})
 * or
 * ({@link  com.tradeshift.triangle.test.TriangleTypeTest.TriangleType#NON_SCALENE}),
 * is a
 * ({@link  com.tradeshift.triangle.test.TriangleTypeTest.TriangleType#ISOSCELES})
 * or
 * ({@link  com.tradeshift.triangle.test.TriangleTypeTest.TriangleType#NON_ISOSCELES})
 * and is an
 * ({@link  com.tradeshift.triangle.test.TriangleTypeTest.TriangleType#EQUILATERAL})
 * or
 * ({@link  com.tradeshift.triangle.test.TriangleTypeTest.TriangleType#NON_EQUILATERAL}).
 * <p>
 * this class is parameterized, because we want to test a list of inputs for
 * each methods.
 *
 * @author Azin
 */
@RunWith(value = Parameterized.class)
public class TriangleTypeTest {

    /**
     * define three types of triangles and 3 more for not being a special kind
     * of triangle.
     */
    public enum TriangleType {

        /**
         * A scalene triangle is a triangle that has three unequal sides.
         *
         */
        /**
         * A scalene triangle is a triangle that has three unequal sides.
         *
         */
        /**
         * A scalene triangle is a triangle that has three unequal sides.
         *
         */
        /**
         * A scalene triangle is a triangle that has three unequal sides.
         *
         */
        /**
         * A scalene triangle is a triangle that has three unequal sides.
         *
         */
        /**
         * A scalene triangle is a triangle that has three unequal sides.
         *
         */
        /**
         * A scalene triangle is a triangle that has three unequal sides.
         *
         */
        /**
         * A scalene triangle is a triangle that has three unequal sides.
         *
         */
        SCALENE,
        /**
         * an isosceles triangle is a triangle that has two sides of equal
         * length.
         *
         */
        ISOSCELES,
        /**
         * an equilateral triangle is a triangle in which all three sides are
         * equal.
         *
         */
        EQUILATERAL,
        /**
         * A non scalene triangle is not a triangle that has three unequal
         * sides.
         *
         */
        NON_SCALENE,
        /**
         * a non isosceles triangle is not a triangle that has two sides of
         * equal length.
         *
         */
        NON_ISOSCELES,
        /**
         * an non equilateral triangle is not a triangle in which all three
         * sides are equal.
         *
         */
        NON_EQUILATERAL
    };

    /**
     * one of three type of Triangle
     */
    private final TriangleType triangleType;

    /**
     * three sides of triangle
     */
    private final Integer sideA;
    private final Integer sideB;
    private final Integer sideC;

    /**
     *
     * @param triangleType is a parameter , which is used to determine which
     * collection of data should pass to a certain test method, based on type of
     * triangle.
     * @param sideA sideA of triangle
     * @param sideB side B of triangle
     * @param sideC side C of triangle
     */
    public TriangleTypeTest(TriangleType triangleType, Integer sideA, Integer sideB, Integer sideC) {
        this.triangleType = triangleType;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     *
     * @return a collection of data based on TriangleType
     */
    @Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {TriangleType.SCALENE, 3, 4, 5},
            {TriangleType.SCALENE, 3, 5, 4},
            {TriangleType.SCALENE, 5, 4, 3},
            {TriangleType.ISOSCELES, 3, 3, 5},
            {TriangleType.ISOSCELES, 3, 5, 5},
            {TriangleType.ISOSCELES, 5, 5, 3},
            {TriangleType.EQUILATERAL, 5, 5, 5},
            {TriangleType.NON_SCALENE, 5, 5, 5},
            {TriangleType.NON_ISOSCELES, 6, 4, 5},
            {TriangleType.NON_EQUILATERAL, 1, 5, 5},});
    }

    /**
     * check if ({@link  com.tradeshift.triangle.Triangle#getTriangleType()})
     * will return Triangle.TriangleType.SCALENE type for scalene type based the
     * collection of inputs.
     */
    @Test
    public void scaleneTypeTest() {
        Assume.assumeTrue(triangleType == TriangleType.SCALENE);
        Triangle trianle = new Triangle(sideA, sideB, sideC);
        Assert.assertEquals(sideA + "," + sideB + " and " + sideC + " are not a Scalene triangle", Triangle.TriangleType.SCALENE, trianle.getTriangleType());
    }

    /**
     * check if ({@link  com.tradeshift.triangle.Triangle#getTriangleType()})
     * will NOT return Triangle.TriangleType.SCALENE type for scalene type based
     * the collection of inputs.
     */
    @Test
    public void notScaleneTypeTest() {
        Assume.assumeTrue(triangleType == TriangleType.NON_SCALENE);
        Triangle trianle = new Triangle(sideA, sideB, sideC);
        Assert.assertThat(sideA + "," + sideB + " and " + sideC + " are a Scalene triangle, it should Not!!", trianle.getTriangleType(), not(Triangle.TriangleType.SCALENE));

    }

    /**
     * check if ({@link  com.tradeshift.triangle.Triangle#getTriangleType()})
     * will return Triangle.TriangleType.ISOSCELES type for scalene type based
     * the collection of inputs.
     */
    @Test
    public void isoscelesTypeTest() {
        Assume.assumeTrue(triangleType == TriangleType.ISOSCELES);
        Triangle trianle = new Triangle(sideA, sideB, sideC);
        Assert.assertEquals(sideA + "," + sideB + " and " + sideC + " are not an Isosceles triangle", Triangle.TriangleType.ISOSCELES, trianle.getTriangleType());
    }

    /**
     * check if ({@link  com.tradeshift.triangle.Triangle#getTriangleType()})
     * will NOT return Triangle.TriangleType.ISOSCELES type for scalene type
     * based the collection of inputs.
     */
    @Test
    public void notIsoscelesTypeTest() {
        Assume.assumeTrue(triangleType == TriangleType.NON_ISOSCELES);
        Triangle trianle = new Triangle(sideA, sideB, sideC);
        Assert.assertThat(sideA + "," + sideB + " and " + sideC + " are a Scalene triangle, it should Not!!", trianle.getTriangleType(), not(Triangle.TriangleType.EQUILATERAL));

    }

    /**
     * check if ({@link  com.tradeshift.triangle.Triangle#getTriangleType()})
     * will return Triangle.TriangleType.EQUILATERAL type for scalene type based
     * the collection of inputs.
     */
    @Test
    public void equilateralTypeTest() {
        Assume.assumeTrue(triangleType == TriangleType.EQUILATERAL);
        Triangle trianle = new Triangle(sideA, sideB, sideC);
        Assert.assertEquals(sideA + "," + sideB + " and " + sideC + " are not an Equilateral triangle", Triangle.TriangleType.EQUILATERAL, trianle.getTriangleType());
    }

    /**
     * check if ({@link  com.tradeshift.triangle.Triangle#getTriangleType()})
     * will NOT return Triangle.TriangleType.EQUILATERAL type for scalene type
     * based the collection of inputs.
     */
    @Test
    public void notEquilateralTypeTest() {
        Assume.assumeTrue(triangleType == TriangleType.NON_EQUILATERAL);
        Triangle trianle = new Triangle(sideA, sideB, sideC);
        Assert.assertThat(sideA + "," + sideB + " and " + sideC + " are a Scalene triangle, it should Not!!", trianle.getTriangleType(), not(Triangle.TriangleType.EQUILATERAL));

    }

}
