package e3;

public class Gunfight {

    public void duel(Gunslinger g1 , Gunslinger g2){

        boolean end=false;
        int i=1;

        while(!end && i < 50 ){

            GunslingerAction g1Last = g1.action();
            GunslingerAction g2Last = g2.action();

            g1.addRivalAction(g2Last);
            g2.addRivalAction(g1Last);

                if (g1Last.equals(GunslingerAction.RELOAD)) { g1.addLoads(); g2.addRivalLoads(); }
                if (g2Last.equals(GunslingerAction.RELOAD)) { g2.addLoads(); g1.addRivalLoads(); }
                if (g1Last.equals(GunslingerAction.SHOOT)) { g1.lessLoads(); g2.lessRivalLoads(); }
                if (g2Last.equals(GunslingerAction.SHOOT)) { g2.lessLoads(); g1.lessRivalLoads(); }

            System.out.println("Round "+i+"------------------------------");
            System.out.println("Gunslinger 1 : " + g1Last.toString());
            System.out.println("Gunslinger 2 : " + g2Last.toString());

            if ( g1Last.equals(GunslingerAction.MACHINE_GUN) && g2Last.equals(GunslingerAction.MACHINE_GUN) ) {

                System.out.println("<< The duel has ended >>\n");
                System.out.println("Tie \n");
                end = true;

            } else if ( g1Last.equals(GunslingerAction.MACHINE_GUN) ) {

                System.out.println("The duel has ended \n");
                System.out.println("<< Winner: G1 >>\n");
                end = true;

            } else if ( g2Last.equals(GunslingerAction.MACHINE_GUN) ) {

                System.out.println("The duel has ended \n");
                System.out.println("<< Winner: G2 >>\n");
                end = true;

            } else if ( g1Last.equals(GunslingerAction.SHOOT) && ( g2Last.equals(GunslingerAction.SHOOT) )) {

                System.out.println("The duel has ended \n");
                System.out.println("Tie \n");
                end = true;

            } else if ( g1Last.equals(GunslingerAction.SHOOT) && !g2Last.equals(GunslingerAction.PROTECT) ) {

                System.out.println("The duel has ended \n");
                System.out.println("<< Winner: G1 >>\n");
                end = true;

            } else if ( g2Last.equals(GunslingerAction.SHOOT) && !g1Last.equals(GunslingerAction.PROTECT) ) {

                System.out.println("The duel has ended \n");
                System.out.println("<< Winner: G2 >>\n");
                end = true;

            } else {

                System.out.println("\n Fight continues... \n");

            }

            i++;

        }

        if (i == 50) {

            System.out.println("\n Too many round ~ << Tie >>");

        }

    }

}