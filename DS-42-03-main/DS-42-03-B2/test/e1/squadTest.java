package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class squadTest {

    squad test = new squad();
    squad emptySquad = new squad();
    character charTest1 = new character("Hero1", character.type_en.ELF);
    character charTest2 = new character("Hero2", character.type_en.ORC);
    character charTest3 = new character("Beast", character.type_en.HUMAN);

    @Test
    void setAt() {

        test.setAt(0, charTest1);
            assertEquals(test.getPos(0), charTest1);

        test.setAt(1, charTest2);
            assertEquals(test.getPos(1), charTest2);

        test.setAt(0,charTest3);
            assertEquals(test.getPos(0), charTest3);

    }

    @Test
    void getSize() {

        test.add(charTest1);
        test.add(charTest2);
        test.add(charTest3);

        assertEquals(3, test.getSize());

        test.add(charTest1);
        test.add(charTest2);

        assertEquals(5, test.getSize());

    }

    @Test
    void getLastPos() {

        test.add(charTest1);
        assertEquals(0, test.getLastPos());

        test.add(charTest2);
        assertEquals(1, test.getLastPos());

        test.add(charTest2);
        test.add(charTest3);
        assertEquals(3, test.getLastPos());

    }

    @Test
    void getPos() {

        test.add(charTest1);
        test.add(charTest2);
        test.add(charTest3);

        assertEquals(charTest1, test.getPos(0));
        assertEquals(charTest2, test.getPos(1));
        assertEquals(charTest3, test.getPos(2));

        assertThrows(ArrayIndexOutOfBoundsException.class , ()-> test.getPos(3));
        assertThrows(ArrayIndexOutOfBoundsException.class , ()-> test.getPos(-1));

    }

    @Test
    void getLast() {

        test.add(charTest1);
        assertEquals(charTest1, test.getLast());

        test.add(charTest2);
        assertEquals(charTest2, test.getLast());

        test.add(charTest2);
        test.add(charTest3);
        assertEquals(charTest3, test.getLast());

    }

    @Test
    void add() {

        test.add("Hero1", character.type_en.ELF);
        assertEquals("ELF Hero1 ( health: 160 ) | defense: 50 |", test.getLast().toString());
        assertEquals(1, test.getSize());

        test.add("Hero2", character.type_en.HOBBIT);
        assertEquals("HOBBIT Hero2 ( health: 20 ) | defense: 40 |", test.getLast().toString());
        assertEquals(2, test.getSize());

        test.add("Beast", character.type_en.TROLL);
        assertEquals("TROLL Beast ( health: 220 ) | defense: 20 |", test.getLast().toString());
        assertEquals(3, test.getSize());

    }

    @Test
    void testAdd() {

        test.add(charTest1);
        assertEquals(charTest1, test.getLast());
        assertEquals(1, test.getSize());

        test.add(charTest2);
        assertEquals(charTest2, test.getLast());
        assertEquals(2, test.getSize());

        test.add(charTest3);
        assertEquals(charTest3, test.getLast());
        assertEquals(3, test.getSize());

    }

    @Test
    void remove() {

        test.add(charTest1);
        test.add(charTest2);
        test.add(charTest3);

        test.remove(1);
        assertEquals(2, test.getSize());
        assertEquals(charTest3, test.getPos(1));

        test.remove(0);
        assertEquals(1, test.getSize());
        assertEquals(charTest3, test.getPos(0));

        test.remove(0);
        assertTrue(test.isEmpty());

        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> test.remove(10));
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> test.remove(-1));

    }

    @Test
    void removeLast() {

        test.add(charTest1);
        test.add(charTest2);
        test.add(charTest3);

        test.removeLast();
        assertEquals(2, test.getSize());
        assertEquals(charTest2, test.getLast());

        test.removeLast();
        assertEquals(1, test.getSize());
        assertEquals(charTest1, test.getLast());

        test.removeLast();
        assertTrue(test.isEmpty());

    }

    @Test
    void isEmpty() {

        assertTrue(emptySquad.isEmpty());

    }
}