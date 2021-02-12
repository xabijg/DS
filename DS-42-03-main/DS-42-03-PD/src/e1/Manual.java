package e1;

public class Manual implements ModoTermostato{

    String name = "Manual";

    @Override
    public String getScreenInfo (Termostato termostato) {
        return termostato.temperatura + " " +  termostato.estado + " M";
    }

    @Override
    public String getName() {
        return name;
    }

    public void recordEvent (Termostato termostato) {
        termostato.log.add(termostato.temperatura + " Modo Manual - Calefacción " + termostato.printEstado() );
    }

    @Override
    public void changeto(Termostato termostato) {
        termostato.modo = this;
        this.recordChange(termostato);
        termostato.estado = Termostato.state_en.ON;
    }

    @Override
    public void recordChange(Termostato termostato) {
        termostato.log.add ("Se activa el modo " + this.getName());
    }

}
