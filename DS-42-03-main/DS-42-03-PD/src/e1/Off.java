package e1;

public class Off implements ModoTermostato {

    String name = "Off";

    //------------------------//

    @Override
    public String getScreenInfo (Termostato termostato) {
        return termostato.temperatura + " " + termostato.estado + " O";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void recordEvent (Termostato termostato) {
        termostato.log.add(termostato.temperatura + " Modo Off - Calefacción " + termostato.printEstado() );
    }

    @Override
    public void changeto(Termostato termostato) {
        termostato.modo = this;
        this.recordChange(termostato);
        termostato.estado = Termostato.state_en.OFF;
    }

    @Override
    public void recordChange(Termostato termostato) {
        termostato.log.add("Se activa el modo " + this.getName());
    }

}
