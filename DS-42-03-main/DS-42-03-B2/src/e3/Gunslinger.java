package e3;

import java.util.ArrayList;
import java.util.List;

public class Gunslinger {

    private int loads;
    private int rivalLoads;
    private ArrayList<GunslingerAction> rivalActions = new ArrayList<>();
    private Behavior comportamiento;

    public GunslingerAction action() {

        return comportamiento.action(this);
    }

    public int getLoads() {

        return this.loads;

    }

    public void addRivalAction(GunslingerAction action) {

        rivalActions.add(action);

    }

    public List<GunslingerAction> getRivalActions() {

        return rivalActions;

    }

    public int getRivalLoads() {

        return rivalLoads;

    }

    public GunslingerAction getLastRivalAction() {

        return rivalActions.get(rivalActions.size() - 1);

    }

    public void addLoads() {

        this.loads++;

    }

    public void addRivalLoads() {

        this.rivalLoads++;

    }

    public void lessLoads() {

        this.loads--;

    }

    public void lessRivalLoads() {

        this.rivalLoads--;

    }

    public void setBehavior(Behavior behavior) {

        this.comportamiento = behavior;

    }

}

