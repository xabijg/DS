package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class characterTest {

    character hero = new character("hero", character.type_en.HOBBIT);
    character beast = new character("beast", character.type_en.ORC);

    @Test
    void setDefense() {

        assertEquals(40, hero.getDefense());
        hero.setDefense(30);
        assertEquals(30, hero.getDefense());

        assertEquals(40, beast.getDefense());
        beast.setDefense(90);
        assertEquals(90, beast.getDefense());
    }

    @Test
    void setHealth() {

        assertEquals(20, hero.getHealth());
        hero.setHealth(5);
        assertEquals(5, hero.getHealth());

        assertEquals(220, beast.getHealth());
        beast.setHealth(987);
        assertEquals(987, beast.getHealth());

    }

    @Test
    void getType() {

        assertEquals(character.type_en.HOBBIT, hero.getType());
        assertEquals(character.type_en.ORC, beast.getType());

    }

    @Test
    void getDefense() {

        hero.setDefense(50);
        assertEquals(50, hero.getDefense());

        beast.setDefense(120);
        assertEquals(120, beast.getDefense());

    }

    @Test
    void getHealth() {

        hero.setHealth(120);
        assertEquals(120, hero.getHealth());

        beast.setHealth(0);
        assertEquals(0, beast.getHealth());

    }

    @Test
    void getName() {

        assertEquals("hero", hero.getName());
        assertEquals("beast", beast.getName());

    }

    @Test
    void getSide() {

        assertEquals(character.side_en.HERO, hero.getSide());
        assertEquals(character.side_en.BEAST, beast.getSide());

    }

    @Test
    void makeChar() { // o makechar funciona dentro do constructor, polo que cando se crea un novo personaxe executase

        character test1 = new character("test1", character.type_en.HUMAN);
        character test2 = new character("test2", character.type_en.TROLL);

        assertEquals("test1", test1.getName());
        assertEquals(character.type_en.HUMAN, test1.getType());
        assertEquals(character.side_en.HERO, test1.getSide());
        assertEquals(60, test1.getHealth());
        assertEquals(40, test1.getDefense());

        assertEquals("test2", test2.getName());
        assertEquals(character.type_en.TROLL, test2.getType());
        assertEquals(character.side_en.BEAST, test2.getSide());
        assertEquals(220, test2.getHealth());
        assertEquals(20, test2.getDefense());

    }
}