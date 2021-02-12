package e1;

import java.util.ArrayList;

public class squad {

    private ArrayList<character> members;

    // constructor

    public squad () {

        members = new ArrayList<>();

    }

    // setters

    public void setAt ( int pos, character example ) {

        this.members.add(pos, example);

    }

    // getters

    public int getSize () {

        return members.size();

    }

    public int getLastPos () {

        return members.size()-1;

    }

    public character getPos (int i) {

        if ( i > this.getLastPos() || i < 0) {

            throw new ArrayIndexOutOfBoundsException();

        } else {

            return members.get(i);

        }

    }

    public character getLast () {

        return members.get(members.size()-1);

    }

    // functions

    public void add ( String name, character.type_en type ) {

        character example = new character(name, type);
        this.members.add(example);

    }

    public void add (character example) {

        this.members.add(example);

    }

    public void remove ( int pos ) {

        if (pos > this.getLastPos() || pos < 0) {

            throw new ArrayIndexOutOfBoundsException();

        } else {

            members.remove(members.get(pos));
        }
    }

    public void removeLast () {

        this.members.remove(this.getLastPos());

    }

    public boolean isEmpty () {

        return this.members.isEmpty();

    }

    // javaElements

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.getSize(); i++) {

            result.append(this.getPos(i).toString()).append("\n");;

        }

        return result.toString();

    }

}
