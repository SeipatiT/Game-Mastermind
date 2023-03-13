package za.co.wethinkcode.mastermind;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MastermindTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private void simulateMastermind() {
    }

    @Test
    public void twoIntsCorrect() {
        /* Checks if two ints are similar to code*/
        Mastermind mastermind = new Mastermind();
        Integer incorrectGuess = mastermind.areCorrectAndCorrectPlace("1111", "1212");

//        System.out.println(incorrectGuess);
        assertEquals(2, incorrectGuess);

    }

    @Test
    public void runMastermind() {
        /* Checks it code and guess are similar*/
        Mastermind mastermind = new Mastermind();
        Integer correctGuess = mastermind.areCorrectAndCorrectPlace("1111", "1111");

//        System.out.println(incorrectGuess);
        assertEquals(4, correctGuess);


    }

    @Test
    public void incorrectPlace() {
        /* Checks it code and guess are similar*/
        Mastermind mastermind = new Mastermind();
        Integer incorrectGuess = mastermind.areInCode("1212","2121");

//        System.out.println(incorrectGuess);
        assertEquals(4, incorrectGuess);


    }

}
