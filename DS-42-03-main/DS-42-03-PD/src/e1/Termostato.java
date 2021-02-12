package e1;

import java.util.ArrayList;

public class Termostato {

    enum state_en {

        ON, OFF

    }
    float temperatura;
    state_en estado;
    ModoTermostato modo;
    ArrayList<String> log = new ArrayList<>();

    //------------------------//

    Termostato (float temperatura) {
        this.temperatura = 0;
        new Off().changeto(this);
        this.newTemperature(temperatura);
    }

    //------------------------//

    void newTemperature ( float currentTemperature ) {
        this.modo.newTemperature(this, currentTemperature);
    }

    void changeMode ( ModoTermostato example ) {
        example.changeto(this);
    }

    public String printEstado () {
        if (this.estado.equals(state_en.OFF)) {
            return "apagada";

        } else {
            return "encendida";
        }
    } // devolve encendida ou apagada dependendo do estado do termosotato

    public String screenInfo() {
        return modo.getScreenInfo(this);
    }

}

