package com.tradeshift.triangle;

import java.util.List;

/**
 * This program will determine the type of a triangle and this is main class to
 * run triangle project, it is also runnable from CMD. It takes the lengths of
 * the triangle's three sides as input from user, and return the type of
 * triangle. There is three kind of triangle :Equilateral, Isosceles or Scalene.
 *
 * @author Azin
 * @version 1.0 Build July, 3 , 2016.
 */
public class TriangleRunner {

    /**
     * get three integer numbers from User
     * ({@link  com.tradeshift.triangle.UserInput#getInput() }) and determine if
     * it could be a triangle and is yes, what kind of triangle it is and it
     * will print out the name of triangle type
     * ({@link  com.tradeshift.triangle.Triangle#getTriangleType()}). in case
     * there be less than three numbers, it will return an error message to
     * user.
     *
     * @param args get three integer numbers from user.
     * @exception IndexOutOfBoundsException in case
     * ({@link com.tradeshift.triangle.UserInput#getInput()}) return less than
     * three numbers.
     */
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        List<Integer> triangleSides = userInput.getInput();
        try {
            Triangle triangle = new Triangle(triangleSides.get(0), triangleSides.get(1), triangleSides.get(2));
            System.out.println(triangleSides.get(0) + "," + triangleSides.get(1) + " and " + triangleSides.get(2) + " are a  triangle of type : " + triangle.getTriangleType().name());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("There is less than 3 valid number !!" + ex.getMessage());

        }
    }

}
