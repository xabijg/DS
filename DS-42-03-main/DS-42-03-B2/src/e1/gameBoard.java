package e1;

public class gameBoard {

    private final die die;
    private final squad Heros;
    private final squad Beasts;

    // constructors

    public gameBoard () {

        this.Heros = new squad ();
            this.Heros.add("Hero1", character.type_en.HOBBIT);
            this.Heros.add("Hero2", character.type_en.ELF);
            this.Heros.add("Hero3", character.type_en.HUMAN);

        this.Beasts = new squad ();
            this.Beasts.add("Beast1", character.type_en.TROLL);
            this.Beasts.add("Beast2", character.type_en.ORC);

        this.die = new die();

    }
    
    public gameBoard (int seed) {

        this.Heros = new squad ();
            this.Heros.add("Hero1", character.type_en.HOBBIT);
            this.Heros.add("Hero2", character.type_en.ELF);
            this.Heros.add("Hero3", character.type_en.HUMAN);

        this.Beasts = new squad ();
            this.Beasts.add("Beast1", character.type_en.TROLL);
            this.Beasts.add("Beast2", character.type_en.ORC);

        this.die = new die( seed );
        
    }

    // functions

    public String fight(character attacker, character defender ) {

        StringBuilder result = new StringBuilder();

        result.append("Fight between ").append(attacker.toString()).append(" and ").append(defender.toString()).append("\n");

        int damage = 0;
        int damage_made = 0;
        int tmp = -1;
        die.throwDie(attacker);
        damage = die.getValue();

        if (attacker.getType().equals(character.type_en.ELF) && defender.getType().equals(character.type_en.ORC)) {

            damage = damage + 10;

        } else if (attacker.getType().equals(character.type_en.HOBBIT) && defender.getType().equals(character.type_en.TROLL)) {

            damage = damage - 5;

        } else if (attacker.getType().equals(character.type_en.ORC)) {

            tmp = (int) (defender.getDefense() * 0.1);

            defender.setDefense(defender.getDefense() - tmp);

        }

        if (damage > defender.getDefense()) {

            damage_made = (damage - defender.getDefense());
            defender.setHealth(defender.getHealth() - damage_made);

            if (defender.getHealth() <= 0) {

                defender.setHealth(0);

            }

        }

        if (tmp != -1) {

            defender.setDefense(defender.getDefense() + tmp);

        }

        if (defender.getHealth() == 0) {

            result.append(defender.getName()).append(" has been killed by ").append(attacker.getName()).append("\n");

        }

        return result.toString();

    }

    public String battle() {

        int turn = 1;
        boolean end = false;
        boolean beastCheck = false;
        StringBuilder result = new StringBuilder();

        while ( !end ) {

            int min = Math.min(this.Heros.getSize(), this.Beasts.getSize());

            switch ( min ) {

                case 1:

                    if ( !beastCheck ) {

                        result.append("\n Turn ").append(turn).append("\n"); turn++;
                        result.append(fight(this.Heros.getPos(0), this.Beasts.getPos(0)));

                        if (this.Beasts.getPos(0).getHealth() == 0) {

                            this.Beasts.remove(0);

                        }

                        if (Math.min(this.Heros.getSize(), this.Beasts.getSize()) < 1) {
                            break;
                        }

                        result.append("\n Turn ").append(turn).append("\n");
                        turn++;
                        result.append(fight(this.Beasts.getPos(0), this.Heros.getPos(0)));

                        if (this.Heros.getPos(0).getHealth() == 0) {

                            this.Heros.remove(0);

                        }

                        break;

                    } else if ( beastCheck ) {

                        result.append("\n Turn ").append(turn).append("\n");
                        turn++;
                        result.append(fight(this.Beasts.getPos(0), this.Heros.getPos(0)));

                        if (this.Heros.getPos(0).getHealth() == 0) {

                            this.Heros.remove(0);

                        }

                        beastCheck = false;
                        break;

                    }

                case 2:

                    result.append("\n Turn ").append(turn).append("\n");
                    result.append(fight( this.Heros.getPos(0), this.Beasts.getPos(0))); // H1 VS B1

                    if ( this.Beasts.getPos(0).getHealth() == 0 ) {

                        if ( this.Beasts.getSize() == 3 ) {

                            this.Beasts.setAt(0, this.Heros.getLast());
                            this.Beasts.remove(this.Heros.getLastPos());

                        } else {

                            this.Beasts.remove(0);
                            this.Heros.setAt(this.Heros.getLastPos()+1, this.Heros.getPos(0));
                            this.Heros.remove(0);

                        }
                    }

                    if (Math.min(this.Heros.getSize(), this.Beasts.getSize()) <= 1) { beastCheck = true; break; }

                    result.append(fight( this.Heros.getPos(1), this.Beasts.getPos(1))); // H2 VS B2

                    if ( this.Beasts.getPos(1).getHealth() == 0 ) {

                        this.Beasts.remove(1);

                    }

                    if (Math.min(this.Heros.getSize(), this.Beasts.getSize()) <= 1) { beastCheck = true; break; }

                    result.append("\n Turn ").append(turn).append("\n");
                    result.append(fight(this.Beasts.getPos(0), this.Heros.getPos(0))); // B1 VS H1

                    if ( this.Heros.getPos(0).getHealth() == 0 ) {

                        if ( this.Heros.getSize() == 3 ) {

                            character tmp = this.Heros.getLast();
                            this.Heros.removeLast();
                            this.Heros.remove(0);
                            this.Heros.setAt(0, tmp);

                        } else {

                            this.Heros.remove(0);
                            this.Beasts.setAt(this.Beasts.getLastPos()+1, this.Beasts.getPos(0));
                            this.Beasts.remove(0);

                        }
                    }

                    if (Math.min(this.Heros.getSize(), this.Beasts.getSize()) <= 1) { break; }

                    result.append(fight( this.Beasts.getPos(1), this.Heros.getPos(1))); // B2 VS H2

                    if ( this.Heros.getPos(1).getHealth() == 0 ) {

                        this.Heros.remove(1);

                    }

                    break;

            }

            if ( this.Heros.isEmpty() || this.Beasts.isEmpty() ) { end = true; }

        }

        if ( !this.Heros.isEmpty() ) {

            result.append("\n \t << Heros win >>");

        } else if ( !this.Beasts.isEmpty() ) {

            result.append("\n \t << Beasts win >>");
        }

        return result.toString();

    }

    // javaElement

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        result.append(this.Heros.toString());

        result.append("---------------------------------------------------- \n");

        result.append(this.Beasts.toString());

        return result.toString();

    }

}
