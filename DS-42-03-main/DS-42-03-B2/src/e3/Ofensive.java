package e3;

public class Ofensive implements Behavior{

    @Override
    public GunslingerAction action(Gunslinger g) {
        if ( g.getLoads() == 0 ) {

            return GunslingerAction.RELOAD;

        } else {

            return GunslingerAction.SHOOT;

        }
    }
}
