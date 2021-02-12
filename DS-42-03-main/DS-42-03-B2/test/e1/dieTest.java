package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class dieTest {

    die normalDie = new die();
    die seedDie = new die(10);
    die seedDie2 = new die(10);

    character hero = new character("hero", character.type_en.HOBBIT);
    character beast = new character("beast", character.type_en.ORC);

    @Test
    void throwDie() {

        for (int i = 0; i < 200; i++) {

            normalDie.throwDie(hero);

            assertTrue( (normalDie.getValue() < 100) || (normalDie.getValue() >= 0) );

        }

        for (int i = 0; i < 200; i++) {

            normalDie.throwDie(beast);

            assertTrue( (normalDie.getValue() < 90) || (normalDie.getValue() >= 0) );

        }

        for (int i = 0; i < 200; i++) {

            seedDie.throwDie(hero);
            seedDie2.throwDie(hero);

            assertEquals(seedDie.getValue(), seedDie2.getValue());

        }

    }
}