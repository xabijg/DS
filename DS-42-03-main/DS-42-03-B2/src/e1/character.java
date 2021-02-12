package e1;

public class character {

    private String name;
    private int health;
    private int defense;
    private side_en side;
    private type_en type;

    // enums

    public enum side_en {

        HERO,
        BEAST

    }

    public enum type_en {

        ELF,
        HOBBIT,
        HUMAN,
        ORC,
        TROLL

    }

    // constructors

    public character ( String name, type_en type ) {

        this.name = name;
        this.type = type;
        makeChar();

    }

    // setters

    public void setDefense (int defense) {

        this.defense = defense;

    }

    public void setHealth ( int health ) {

        this.health = health;

    }

    // getters

    public type_en getType () {

        return this.type;

    }

    public int getDefense () {

        return this.defense;

    }

    public int getHealth () {

        return this.health;

    }

    public String getName () {

        return this.name;

    }

    public side_en getSide () {

        return this.side;

    }

    // functions

    public void makeChar() {

        if (this.type != null) {

            if (this.type.equals(type_en.ELF)) {

                this.side = side_en.HERO;
                this.health = 160;
                this.defense = 50;

            } else if (this.type.equals(type_en.HUMAN)) {

                this.side = side_en.HERO;
                this.health = 60;
                this.defense = 40;

            } else if (this.type.equals(type_en.HOBBIT)) {

                this.side = side_en.HERO;
                this.health = 20;
                this.defense = 40;

            } else if (this.type.equals(type_en.ORC)) {

                this.side = side_en.BEAST;
                this.health = 220;
                this.defense = 40;

            } else if (this.type.equals(type_en.TROLL)) {

                this.side = side_en.BEAST;
                this.health = 220;
                this.defense = 20;

            }

        } else {

            this.name = "";
            this.side = null;
            this.health = -1;
            this.defense = -1;

        }
    }

    // javaElements

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        result.append(this.type).append(" ").append(this.name).append(" ( health: ").append(this.health).append(" ) | defense: ").append(this.defense).append(" |");

        return result.toString();

    }


}
