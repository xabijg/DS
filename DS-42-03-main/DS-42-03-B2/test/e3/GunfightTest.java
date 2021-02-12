package e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GunfightTest {

    @Test
    void duel() {

        Gunfight gunfight = new Gunfight();

        Gunslinger test1 = new Gunslinger();
        Gunslinger test2 = new Gunslinger();

        Behavior defensive = new Defensive();
        Behavior ofensive = new Ofensive();

        test1.setBehavior(defensive);
        test2.setBehavior(ofensive);

        gunfight.duel(test1,test2);

    }
}