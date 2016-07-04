package com.tradeshift.triangle;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class is responsible to get 3 integer numbers from user as triangle's
 * sides, it will ignore all non integer values.
 *
 * @author Azin
 */
public class UserInput {

    public UserInput() {
    }

    /**
     * it will get user's input, and count only first three numbers which user
     * enter. it will ignore all letters or special characters. if input has
     * less than 3 number , then NoSuchElementException catch in while loop.
     *
     * @return list of maximum three integer numbers of user inputs as a
     * triangle's sides.
     * @exception InputMismatchException if user enter non integer value
     * @exception NoSuchElementException if user does not enter enough number
     *
     */
    public List<Integer> getInput() {
        List<Integer> triangleSides = new ArrayList<>();
        Scanner userInputs = new Scanner(System.in);
        System.out.println(" Enter 3 numbers as sides of triangle: ");

        /**
         * it uses for get no more than 3 numbers of user.
         */
        int count = 0;

        while (count < 3) {

            try {
                triangleSides.add(count, userInputs.nextInt());
                count++;

            } catch (InputMismatchException e) {
                System.out.println(userInputs.next() + " is not a valid number !!");

            } catch (NoSuchElementException e) {
                System.out.println("There is less than 3 valid number !!");
                break;
            }
        }

        return triangleSides;
    }

}
