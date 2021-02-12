package e1;

public class Timer implements ModoTermostato {

    String name = "Timer";
    private int tiempo;

    Timer (int time_left) { this.tiempo = time_left; }

    //------------------------//

    @Override
    public void newTemperature(Termostato termostato, float temperatura) {
        termostato.temperatura = temperatura;
        tiempo = tiempo - 5;

        if (tiempo <= 0) {
            termostato.log.add("Se desactiva el modo Timer");
            termostato.changeMode(new Off());
        }

        termostato.modo.recordEvent(termostato);
    }

    @Override
    public void recordEvent(Termostato termostato) {
        termostato.log.add(termostato.temperatura + " Modo Timer (faltan " + this.tiempo + " minutos) - Calefacción " + termostato.printEstado());
    }

    @Override
    public void changeto (Termostato termostato) {
        if (termostato.modo.getName().equals("Program")) {
            throw new IllegalArgumentException("Can't change directly from Timer to Program");

        } else {
            termostato.modo = this;
            this.recordChange(termostato);
            termostato.estado = Termostato.state_en.ON;
        }
    }

    @Override
    public void recordChange(Termostato termostato) {
        termostato.log.add("Se activa el modo " + this.getName() + " " + this.tiempo + " minutos");
    }

    @Override
    public String getScreenInfo(Termostato termostato) {
        return termostato.temperatura + " " + termostato.estado + " T " + tiempo;
    }

    @Override
    public String getName() {
        return name;
    }

}
