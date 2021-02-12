package e4;

public class TrafficJunction {

    public TrafficLight TRAFFIC_LIGHT_1;
    public TrafficLight TRAFFIC_LIGHT_2;
    public TrafficLight TRAFFIC_LIGHT_3;
    public TrafficLight TRAFFIC_LIGHT_4;


    public enum COLOURS {

        RED,
        GREEN,
        YELLOW;

        boolean BLINK;

    }


    public TrafficJunction() {                          // SE CREA UNHA NUEVA TRAFFIC JUNTION CON LOS VALORES ESPECIFICADOS EN EL ENUNCIADO

        TRAFFIC_LIGHT_1 = new TrafficLight();

        TRAFFIC_LIGHT_1.name = "NORTH";
        TRAFFIC_LIGHT_1.time = 0;
        TRAFFIC_LIGHT_1.colour = COLOURS.GREEN;
        TRAFFIC_LIGHT_1.colour.BLINK = false;

        TRAFFIC_LIGHT_2 = new TrafficLight();

        TRAFFIC_LIGHT_2.name = "SOUTH";
        TRAFFIC_LIGHT_2.time = 0;
        TRAFFIC_LIGHT_2.colour = COLOURS.RED;
        TRAFFIC_LIGHT_2.colour.BLINK = false;

        TRAFFIC_LIGHT_3 = new TrafficLight();

        TRAFFIC_LIGHT_3.name = "EAST";
        TRAFFIC_LIGHT_3.time = 0;
        TRAFFIC_LIGHT_3.colour = COLOURS.RED;
        TRAFFIC_LIGHT_3.colour.BLINK = false;

        TRAFFIC_LIGHT_4 = new TrafficLight();

        TRAFFIC_LIGHT_4.name = "WEST";
        TRAFFIC_LIGHT_4.time = 0;
        TRAFFIC_LIGHT_4.colour = COLOURS.RED;
        TRAFFIC_LIGHT_4.colour.BLINK = false;

    }

    public void timesGoesBy () {        // SE DELEGA EN LA FUNCION TRAFFIC_LIGHT.ADDTIME() PARA AUMENTAR LOS CONTADORES DE LOS SEMÁFOROS

        TRAFFIC_LIGHT_1.AddTime();
        TRAFFIC_LIGHT_2.AddTime();
        TRAFFIC_LIGHT_3.AddTime();
        TRAFFIC_LIGHT_4.AddTime();
        updateJunction();               // SE ACTUALIZA EL ESTADO DE LOS SEMÁFOROS DESPUES DE ACTUALIZAR SU CONTADOR

    }

    public void amberJunction ( boolean active ){

        if (active) {                                   // EN EL CASO ACTIVE = TRUE SE PONEN TODOS LOS SEMÁFOROS EN  AMARILLO PARPADEANTE
            TRAFFIC_LIGHT_1.UnmanagedJunction();
            TRAFFIC_LIGHT_2.UnmanagedJunction();
            TRAFFIC_LIGHT_3.UnmanagedJunction();
            TRAFFIC_LIGHT_4.UnmanagedJunction();

        } else if (!active) {                           // EN EL CASO ACTIVE = FALSE SE RESETEA EL ESTADO DE LOS SEMÁFOROS AL ESTADO INICIAL

            TRAFFIC_LIGHT_1.resetFirst();
            TRAFFIC_LIGHT_2.resetElse();
            TRAFFIC_LIGHT_3.resetElse();
            TRAFFIC_LIGHT_4.resetElse();

        }
    }

    public void updateJunction(){

        if( COLOURS.GREEN.equals(TRAFFIC_LIGHT_1.colour) && TRAFFIC_LIGHT_1.time == 16){        // CUANDO EL CONTADOR SUPERA 15 Y EL COLOR ES VERDE, SE CAMBIA EL COLOR A AMARILLO NO PARPADEANTE Y SE RESETEA EL CONTADOR

            TRAFFIC_LIGHT_1.colour = COLOURS.YELLOW;
            TRAFFIC_LIGHT_1.colour.BLINK = false;
            TRAFFIC_LIGHT_1.time = 0;

        } else if (COLOURS.YELLOW.equals(TRAFFIC_LIGHT_1.colour) && !TRAFFIC_LIGHT_1.colour.BLINK && TRAFFIC_LIGHT_1.time == 6    ){    // CUANDO EL CONTADOR SUPERA 5 Y EL COLOR ES AMARILLO NO PARPADEANTE, SE PONE EL SEMÁFORO ACTUAL EN ROJO Y EN VERDE EL SIGUIENTE, PONIENDO A 0 AMBOS CONTADORES

            TRAFFIC_LIGHT_1.colour = COLOURS.RED;
            TRAFFIC_LIGHT_1.time = 0;

            TRAFFIC_LIGHT_2.colour = COLOURS.GREEN;
            TRAFFIC_LIGHT_2.time = 0;

        } else if( COLOURS.GREEN.equals(TRAFFIC_LIGHT_2.colour) && TRAFFIC_LIGHT_2.time == 16){

            TRAFFIC_LIGHT_2.colour = COLOURS.YELLOW;
            TRAFFIC_LIGHT_2.colour.BLINK = false;
            TRAFFIC_LIGHT_2.time = 0;

        } else if (COLOURS.YELLOW.equals(TRAFFIC_LIGHT_2.colour) && !TRAFFIC_LIGHT_2.colour.BLINK && TRAFFIC_LIGHT_2.time == 6){

            TRAFFIC_LIGHT_2.colour = COLOURS.RED;
            TRAFFIC_LIGHT_2.time = 0;

            TRAFFIC_LIGHT_3.colour = COLOURS.GREEN;
            TRAFFIC_LIGHT_3.time = 0;

        } else if( COLOURS.GREEN.equals(TRAFFIC_LIGHT_3.colour) && TRAFFIC_LIGHT_3.time == 16){

            TRAFFIC_LIGHT_3.colour = COLOURS.YELLOW;
            TRAFFIC_LIGHT_3.colour.BLINK = false;
            TRAFFIC_LIGHT_3.time = 0;

        } else if (COLOURS.YELLOW.equals(TRAFFIC_LIGHT_3.colour) && !TRAFFIC_LIGHT_3.colour.BLINK && TRAFFIC_LIGHT_3.time == 6){

            TRAFFIC_LIGHT_3.colour = COLOURS.RED;
            TRAFFIC_LIGHT_3.time = 0;

            TRAFFIC_LIGHT_4.colour = COLOURS.GREEN;
            TRAFFIC_LIGHT_4.time = 0;

        } else if( COLOURS.GREEN.equals(TRAFFIC_LIGHT_4.colour) && TRAFFIC_LIGHT_4.time == 16){

            TRAFFIC_LIGHT_4.colour = COLOURS.YELLOW;
            TRAFFIC_LIGHT_4.colour.BLINK = false;
            TRAFFIC_LIGHT_4.time = 0;

        } else if (COLOURS.YELLOW.equals(TRAFFIC_LIGHT_4.colour) && !TRAFFIC_LIGHT_4.colour.BLINK && TRAFFIC_LIGHT_4.time == 6){

            TRAFFIC_LIGHT_4.colour = COLOURS.RED;
            TRAFFIC_LIGHT_4.time = 0;

            TRAFFIC_LIGHT_1.colour = COLOURS.GREEN;
            TRAFFIC_LIGHT_1.time = 0;

        }

    }

    @Override
    public String toString(){           // SE HACE USO DE LA FUNCION TRAFFIC_LIGHT.TOSTRING PARA OBTENER EL NOMBRE Y ESTADO DE CADA SEMÁFORO Y SE CONCATENAN LOS 4 QUE FORMAN LA INTERSECCIÓN

        return TRAFFIC_LIGHT_1.toString() + TRAFFIC_LIGHT_2.toString() + TRAFFIC_LIGHT_3.toString() + TRAFFIC_LIGHT_4.toString();
    }

}
