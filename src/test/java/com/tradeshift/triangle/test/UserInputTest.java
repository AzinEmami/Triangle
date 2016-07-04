package com.tradeshift.triangle.test;

import com.tradeshift.triangle.UserInput;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.Assert;
import org.junit.Test;

/**
 * This class is responsible to check getting input of user. it will check if
 * scanner ignores non integer values properly and check if scanner works
 * correct in case user enter less than 3 number.
 *
 * @author Azin
 */
public class UserInputTest {

    /**
     * Check if ({@link  com.tradeshift.triangle.UserInput#getInput() }) will
     * return first three number of user input and will handle
     * InputMismatchException in case user enter any non integer value.
     */
    @Test
    public void shouldGetUserInput() {
        UserInput userInput = new UserInput();
        String mockInput = "a @ 3 4 bb 6a % 5 z k 8 9 ";
        InputStream in = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(in);
        List<Integer> results = userInput.getInput();
        Assert.assertThat("it should get 3 integer !!", results.size(), is(3));
        Assert.assertThat(results.get(0), is(3));
        Assert.assertThat(results.get(1), is(4));
        Assert.assertThat(results.get(2), is(5));

    }

    /**
     * check if ({@link  com.tradeshift.triangle.UserInput#getInput() }) will
     * handle NoSuchElementException in case user enter less than 3 numbers.
     */
    @Test
    public void getLessThanThreeSidesLenght() {
        UserInput userInput = new UserInput();
        String mockInput = "a @ 1";
        InputStream in = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(in);
        List<Integer> results = userInput.getInput();
        Assert.assertThat("it should get 3 integer !!", results.size(), not(3));
        Assert.assertThat(results.get(0), is(1));

    }

}
