package e3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GunslingerTest {

    Gunslinger test1 = new Gunslinger();
    Gunslinger test2 = new Gunslinger();

    @Test
    void action() {

        Behavior defensive = new Defensive();
        test1.setBehavior(defensive);

        assertEquals(GunslingerAction.RELOAD, test1.action());

        test1.addLoads();
        test1.addLoads();
        test1.addLoads();
        test1.addLoads();
        test1.addLoads();

        assertEquals(GunslingerAction.MACHINE_GUN, test1.action());

        test1.addRivalAction(GunslingerAction.SHOOT);
        test1.lessLoads();
        test1.lessLoads();

        assertEquals(GunslingerAction.SHOOT, test1.action());

        test1.addRivalAction(GunslingerAction.RELOAD);
        test1.addRivalLoads();

        assertEquals(GunslingerAction.PROTECT, test1.action());

        test1.lessRivalLoads();

        assertEquals(GunslingerAction.RELOAD, test1.action());



    }

    @Test
    void getLoads() {

        test1.addLoads();
        test1.addLoads();
        test2.addLoads();
        test2.addLoads();
        test2.addLoads();

        assertEquals(2, test1.getLoads());
        assertEquals(3, test2.getLoads());
    }

    @Test
    void addRivalAction() {

        test1.addRivalAction(GunslingerAction.MACHINE_GUN);
        test1.addRivalAction(GunslingerAction.RELOAD);
        test2.addRivalAction(GunslingerAction.PROTECT);

        assertEquals(GunslingerAction.RELOAD, test1.getLastRivalAction());
        assertEquals(GunslingerAction.PROTECT, test2.getLastRivalAction());

    }

    @Test
    void getRivalActions() {

        ArrayList<GunslingerAction> ArrayTest1 = new ArrayList<>();
        ArrayList<GunslingerAction> ArrayTest2 = new ArrayList<>();

        test1.addRivalAction(GunslingerAction.MACHINE_GUN);
        test1.addRivalAction(GunslingerAction.RELOAD);
        test2.addRivalAction(GunslingerAction.PROTECT);
        test2.addRivalAction(GunslingerAction.SHOOT);

        ArrayTest1.add(GunslingerAction.MACHINE_GUN);
        ArrayTest1.add(GunslingerAction.RELOAD);
        ArrayTest2.add(GunslingerAction.PROTECT);
        ArrayTest2.add(GunslingerAction.SHOOT);

        assertEquals(test1.getRivalActions(), ArrayTest1);
        assertEquals(test2.getRivalActions(), ArrayTest2);

    }

    @Test
    void getRivalLoads() {

        test1.addRivalLoads();
        test1.addRivalLoads();
        test1.addRivalLoads();
        test2.addRivalLoads();
        test2.addRivalLoads();
        test2.addRivalLoads();
        test2.addRivalLoads();

        assertEquals(3, test1.getRivalLoads());
        assertEquals(4, test2.getRivalLoads());

    }

    @Test
    void getLastRivalAction() {

        test1.addRivalAction(GunslingerAction.MACHINE_GUN);
        test1.addRivalAction(GunslingerAction.RELOAD);
        test2.addRivalAction(GunslingerAction.PROTECT);
        test2.addRivalAction(GunslingerAction.SHOOT);

        assertEquals(GunslingerAction.RELOAD, test1.getLastRivalAction());
        assertEquals(GunslingerAction.SHOOT, test2.getLastRivalAction());
    }

    @Test
    void addLoads() {

        test1.addLoads();
        test1.addLoads();
        test1.addLoads();
        test2.addLoads();
        test2.addLoads();
        test2.addLoads();
        test2.addLoads();

        assertEquals(3, test1.getLoads());
        assertEquals(4, test2.getLoads());

    }

    @Test
    void addRivalLoads() {

        test1.addRivalLoads();
        test1.addRivalLoads();
        test1.addRivalLoads();
        test2.addRivalLoads();
        test2.addRivalLoads();
        test2.addRivalLoads();
        test2.addRivalLoads();

        assertEquals(3, test1.getRivalLoads());
        assertEquals(4, test2.getRivalLoads());

    }

    @Test
    void lessLoads() {

        test1.addLoads();
        test1.addLoads();
        test1.lessLoads();
        test2.addLoads();
        test2.lessLoads();

        assertEquals(1, test1.getLoads());
        assertEquals(0, test2.getLoads());

    }

    @Test
    void lessRivalLoads() {

        test1.addRivalLoads();
        test1.addRivalLoads();
        test1.lessRivalLoads();
        test2.addRivalLoads();
        test2.lessRivalLoads();

        assertEquals(1, test1.getRivalLoads());
        assertEquals(0, test2.getRivalLoads());

    }

}