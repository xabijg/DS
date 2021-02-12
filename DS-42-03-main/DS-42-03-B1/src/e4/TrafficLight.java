package e4;

public class TrafficLight {

    public String name;
    public int time;
    public TrafficJunction.COLOURS colour;

    public void AddTime(){ // SI EL SEMÁFORO ESTÁ EN VERDE O AMARILLO NO PARPADEANTE SE AÑADE 1 AL CONTADOR

        if ( this.colour == TrafficJunction.COLOURS.GREEN || TrafficJunction.COLOURS.YELLOW.equals(TrafficJunction.COLOURS.YELLOW) && !this.colour.BLINK){

            this.time = time +1;

        }
        
    }

    public void UnmanagedJunction(){        // ESTABLECE EL ESTADO DEL SEMAFORO A AMARILLO PARPADEANTE

        this.colour = TrafficJunction.COLOURS.YELLOW;
        this.colour.BLINK = true;

    }

    public void resetFirst(){               // SE PONE EL SEMÁFORO EN EL ESTADO INICIAL ( VÁLIDO PARA EL PRIMER SEMÁFORO DE LA INTERSECCIÓN )

        this.time = 0;
        this.colour = TrafficJunction.COLOURS.GREEN;
        this.colour.BLINK = false;

    }

    public void resetElse(){                // SE PONE EL SEMÁFORO EN EL ESTADO INICIAL ( VÁLIDO PARA EL RESTO DE SEMÁFOROS DE LA INTERSECCIÓN )

        this.time = 0;
        this.colour = TrafficJunction.COLOURS.RED;
        this.colour.BLINK = false;

    }

    public String toString(){           // SE IMPRIME EL ESTADO DEL SEMÁFORO EN UNA STRING

        StringBuilder result = new StringBuilder();

        if ( colour.equals(TrafficJunction.COLOURS.GREEN) ) {

            result.append("[").append(name).append(": GREEN ").append(time).append("]");

        } else if ( colour.equals(TrafficJunction.COLOURS.RED) ) {

            result.append("[").append(name).append(": RED]");

        } else if ( colour.equals(TrafficJunction.COLOURS.YELLOW) ) {

            if (!colour.BLINK) {

                result.append("[").append(name).append(": AMBER ").append("OFF ").append(time).append("]");

            } else if (colour.BLINK){

                result.append("[").append(name).append(": AMBER ON]");
            }

        }

        return result.toString();

    }

}
