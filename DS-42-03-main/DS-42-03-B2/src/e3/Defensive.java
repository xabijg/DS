package e3;

public class Defensive implements Behavior{

    @Override
    public GunslingerAction action(Gunslinger g) {

        if (g.getLoads() == 0) {

            return GunslingerAction.RELOAD;

        } else {

            if (g.getLoads() == 5) {

                return GunslingerAction.MACHINE_GUN;

            } else if (g.getLastRivalAction().equals(GunslingerAction.SHOOT)) {

                return GunslingerAction.SHOOT;

            } else if (g.getRivalLoads() >= 3){

                return GunslingerAction.SHOOT;

            }else if ((g.getRivalLoads() > 0) && (g.getRivalLoads() < 3)) {

                return GunslingerAction.PROTECT;

            } else if (g.getRivalLoads() == 0) {

                return GunslingerAction.RELOAD;

            }  else {

                return GunslingerAction.PROTECT;

            }
        }

    }
}
