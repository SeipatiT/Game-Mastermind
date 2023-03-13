package za.co.wethinkcode.mastermind;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @Test
    public void checkLengthUserGuess() {
        Player player = new Player(new ByteArrayInputStream("5555\n".getBytes()));
        String userGuess = player.getGuess();
        System.out.println(userGuess);
        int guessLength = userGuess.length();
        assertEquals(4, guessLength);
    }

    @Test
    public void tryNumberOutOfRange() {
        Player player = new Player(new ByteArrayInputStream("9999\n1234\n".getBytes()));
        String incorrectGuess = player.getGuess();
//        System.out.println(incorrectGuess);
        assertEquals("1234", incorrectGuess);
    }


    @Test
    public void shouldStartWith12Chances() {
        Player player = new Player();
        assertEquals(12, player.getChances());
    }

    @Test
    public void canLoseAChance() {
        Player player = new Player();
        int chances = player.getChances();
        player.lostChance();
        assertEquals(chances - 1, player.getChances());
    }

    @Test
    public void noMoreChances() {
        Player player = new Player();
        int chances = player.getChances();
        for (int i = 0; i < chances; i++) {
            assertFalse(player.hasNoChances());
            player.lostChance();
        }
        assertTrue(player.hasNoChances());
    }

    @Test
    public void cannotLoseChanceIfNoneAvailable() {
        Player player = new Player();
        int chances = player.getChances();
        for (int i = 0; i < chances + 1; i++) {
            player.lostChance();
        }
        assertEquals(0, player.getChances());
    }
}