package e1;

public interface ModoTermostato {

    String getScreenInfo (Termostato termostato);
    String getName();
    void recordEvent (Termostato termostato);
    void changeto (Termostato termostato);
    void recordChange (Termostato termostato);
    default void newTemperature (Termostato termostato, float temperatura) {
        termostato.temperatura = temperatura;
        termostato.modo.recordEvent(termostato);
    }

}
