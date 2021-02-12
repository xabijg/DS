package e1;

public class Program implements ModoTermostato {

    String name = "Program";
    float programmed_temp;

    //------------------------//

    Program (float temperature) { this.programmed_temp = temperature; }

    //------------------------//

    public void newTemperature (Termostato termostato, float temperatura) {
        termostato.temperatura = temperatura;
        updateState(termostato);
        termostato.modo.recordEvent(termostato);
    }

    @Override
    public String getScreenInfo(Termostato termostato) {
        return termostato.temperatura + " " + termostato.estado + " P " + programmed_temp;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void recordEvent(Termostato termostato) {
        termostato.log.add( termostato.temperatura + " Modo Program (a " + programmed_temp + " grados) - Calefacción "
                + termostato.printEstado() );
    }

    @Override
    public void changeto (Termostato termostato) {
        if (termostato.modo.getName().equals("Timer")){
            throw new IllegalArgumentException("Can't change directly from Timer to Program");

        } else {
            termostato.modo = this;
            this.recordChange (termostato);
            if (programmed_temp <= termostato.temperatura) {
                termostato.estado = Termostato.state_en.OFF;

            } else {
                termostato.estado = Termostato.state_en.ON;
            }
        }
    }

    private void updateState(Termostato termostato) {
        if ( termostato.temperatura >= programmed_temp ) {
            termostato.estado = Termostato.state_en.OFF;

        } else {
            termostato.estado = Termostato.state_en.ON;
        }
    }

    @Override
    public void recordChange(Termostato termostato) {
        termostato.log.add("Se activa el modo " + this.getName() + " a " + this.programmed_temp + " grados");
    }

}
