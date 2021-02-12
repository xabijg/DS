package e1;

import java.util.Random;

public class die {

    private int value;
    private final Random generator = new Random();

    // constructor

    public die () {

        this.value = 0;

    }

    public die ( int seed ) {

        this.generator.setSeed(seed);

    }

    // getter

    public int getValue () {

        return this.value;

    }

    // functions

    public void throwDie(character example) {

        int d1, d2;

        if (example.getSide() != null) {

            if (example.getSide().equals(character.side_en.HERO)) {

                d1 = (int) (generator.nextDouble() * 101);
                d2 = (int) (generator.nextDouble() * 101);

                this.value = Math.max(d1, d2);

            } else if (example.getSide().equals(character.side_en.BEAST)) {

                this.value = (int) (generator.nextDouble() * 91);

            }
        }
    }

}
