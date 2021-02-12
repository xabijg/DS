package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class gameBoardTest {

    @Test
    void war() {

        gameBoard Seed1 = new gameBoard(10);
        gameBoard Seed2 = new gameBoard(10);

        gameBoard noSeed1 = new gameBoard();
        gameBoard noSeed2 = new gameBoard();

        assertEquals(Seed1.battle(), Seed2.battle());
        assertEquals(Seed1.toString(), Seed2.toString());

        assertNotEquals(noSeed1.battle(), noSeed2.battle());
        assertNotEquals(noSeed1.toString(), noSeed2.toString());

    }
}
