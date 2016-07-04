package com.tradeshift.triangle;

import java.util.Objects;

/**
 * This class is responsible to check if input can be a triangle and if yes what
 * type of triangle it is.
 * <p>
 * There is three kind of triangle :Equilateral, Isosceles or
 * Scalene.{@link com.tradeshift.triangle.Triangle.TriangleType}
 *
 * <p>
 * To be a triangle it should satisfy 3 conditions :
 * <p>
 * 1)All three sides should have values.
 * <p>
 * 2)All tree sides should have positive values.
 * <p>
 * 3)All side should be less than sum of two others sides.
 *
 * @author Azin
 */
public class Triangle {

    /**
     * There is three kind of triangles : Scalene,Isosceles and Equilateral.
     *
     */
    public enum TriangleType {

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
        EQUILATERAL
    }

    /**
     * sideA , sideB and sideC are 3 sides of triangle.
     *
     */
    private final Integer sideA, sideB, sideC;

    /**
     * This is constructor of triangle and check all conditions for a right
     * triangle, if all conditions will satisfy, it will create an object of
     * Triangle class.
     *
     * @param sideA side A of triangle
     * @param sideB side B of triangle
     * @param sideC side C of triangle
     * @throws NullPointerException in case at least one side is null
     * {@link #isAnySideNull()}
     * @throws IllegalArgumentException in case at least one of side is not
     * positive , or at least one of side are equal or bigger than sum of 2
     * others {@link  #isNotPositive() } {@link  #isNotTriangle() }
     *
     */
    public Triangle(Integer sideA, Integer sideB, Integer sideC) {

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;

        if (isAnySideNull()) {
            throw new NullPointerException("None of the sides can be null!!");
        }

        if (isNotPositive()) {
            throw new IllegalArgumentException("Sides " + sideA + " , " + sideB
                    + " and " + sideC + "  each must be greater than zero.");

        }
        if (isNotTriangle()) {
            throw new IllegalArgumentException("Sides " + sideA + " , " + sideB
                    + " and " + sideC + "  can not create a triangle. each side should be less than sum of two other sides.");

        }

    }

    /**
     * check if any side is null. for a triangle all sides should have value.
     *
     * @return true if at least one of sides is null, false if all sides have
     * their own value.
     */
    public final boolean isAnySideNull() {
        return sideA == null || sideB == null || sideC == null;
    }

    /**
     * check if any side is zero or negative. for a triangle all sides should
     * have positive value.
     *
     * @return true if at least one of sides has zero or negative value.
     */
    public final boolean isNotPositive() {
        return sideA <= 0 || sideB <= 0 || sideC <= 0;
    }

    /**
     * check if any side has greater value than sum of two other sides.
     *
     * @return true if any side has a greater or equal value with sum of 2 other
     * sides.
     */
    public final boolean isNotTriangle() {
        return sideA >= sideB + sideC || sideB >= sideA + sideC || sideC >= sideA + sideB;
    }

    /**
     * get value of sides from constructor.
     *
     * @return true if all sides are equal.
     */
    public boolean isEquilateral() {
        return Objects.equals(sideA, sideB) && Objects.equals(sideB, sideC);
    }

    /**
     * get value of sides from constructor.
     *
     * @return true if at least two sides are equal.
     */
    public boolean isIsosceles() {
        return Objects.equals(sideA, sideB) || Objects.equals(sideB, sideC) || Objects.equals(sideC, sideA);
    }

    /**
     * get value of sides from constructor,if a triangle is not Equilateral or
     * Isosceles, then it is Scalene.
     *
     * @return one of the Equilateral({@link  #isEquilateral() }), Isosceles ({@link  #isIsosceles()
     * })or Scalene type of TriangleType.
     */
    public TriangleType getTriangleType() {
        if (isEquilateral()) {
            return TriangleType.EQUILATERAL;
        }
        if (isIsosceles()) {
            return TriangleType.ISOSCELES;
        }
        return TriangleType.SCALENE;
    }

}
