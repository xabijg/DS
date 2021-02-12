package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TermostatoTest {

    ModoTermostato off = new Off();
    ModoTermostato manual = new Manual();
    ModoTermostato timer = new Timer(19);
    ModoTermostato program = new Program((float)20.0);


    @Test
    void newTemperature() {

        Termostato termostatoTemperature = new Termostato((float)20.0);
        int j = 4;

        termostatoTemperature.changeMode(off);
        termostatoTemperature.newTemperature((float) 21.0);
        assertEquals((float)21.0, termostatoTemperature.temperatura);
        assertEquals(j, termostatoTemperature.log.size()); j = j+2; // comprobamos que o log se actualiza

        termostatoTemperature.changeMode(manual);
        termostatoTemperature.newTemperature((float) 21.0);
        assertEquals((float)21.0, termostatoTemperature.temperatura);
        assertEquals(j, termostatoTemperature.log.size()); // comprobamos que o log se actualiza

    }

    @Test
    void changeMode() {

        int j = 2;
        Termostato termostatoModo = new Termostato((float)20.4);
        assertEquals(j, termostatoModo.log.size()); j++;

        termostatoModo.changeMode(off);
        assertEquals(off, termostatoModo.modo);
        assertEquals(Termostato.state_en.OFF, termostatoModo.estado);
        assertEquals(j, termostatoModo.log.size()); j++;// comprobamos que o tamaño do log aumenta, que se están gardando os eventos

        termostatoModo.changeMode(manual);
        assertEquals(manual, termostatoModo.modo);
        assertEquals(Termostato.state_en.ON, termostatoModo.estado);
        assertEquals(j, termostatoModo.log.size()); j=j+7;// neste aumentase 7 porque son 4 do bucle e 3 de activarse e desactivarse o modo timer

        termostatoModo.changeMode(timer);
        assertEquals(timer, termostatoModo.modo);
        assertEquals(Termostato.state_en.ON, termostatoModo.estado);
        for (int i = 0; i < 4; i++) {
            termostatoModo.newTemperature((float)19.2); // Simulamos o que pasan máis de 19 minutos, neste caso 20, para comprobar que se apaga automáticamente
        }
        assertEquals(Termostato.state_en.OFF, termostatoModo.estado);
        assertEquals(j, termostatoModo.log.size()); j=j+3; // sumamos 3 porque a proxima comprobación ten 2 iteracións e 1 do cambio de modo

        termostatoModo.changeMode(program);
        assertEquals(program, termostatoModo.modo);
        termostatoModo.newTemperature((float)19.0);
        assertEquals(Termostato.state_en.ON, termostatoModo.estado); // Como a temperatura actual é menor que a programada o termostato encende
        termostatoModo.newTemperature((float)21.0);
        assertEquals(Termostato.state_en.OFF, termostatoModo.estado); // Como a temperatura actual é maior que a programada o termostato apaga
        assertEquals(j, termostatoModo.log.size());

        assertThrows(IllegalArgumentException.class, ()-> termostatoModo.changeMode(timer));
        termostatoModo.changeMode(off);
        termostatoModo.changeMode(timer);
        assertThrows(IllegalArgumentException.class, ()-> termostatoModo.changeMode(program));


    }

    @Test
    void printEstado() { // función moi simple que se usa para rexistrar no log, solo devolve "apagada" ou "encendida"

        Termostato termostatoEstado = new Termostato((float)19.1);

        termostatoEstado.changeMode(manual);
        assertEquals("encendida", termostatoEstado.printEstado());
        termostatoEstado.changeMode(off);
        assertEquals("apagada", termostatoEstado.printEstado());

    }

    @Test
    void screenInfo() {

        Termostato termostatoScreenInfo = new Termostato((float)20.1);

        termostatoScreenInfo.changeMode(off);
        assertEquals("20.1 OFF O", termostatoScreenInfo.screenInfo());
        termostatoScreenInfo.changeMode(timer);
        assertEquals("20.1 ON T 19", termostatoScreenInfo.screenInfo());
        termostatoScreenInfo.changeMode(manual);
        assertEquals("20.1 ON M", termostatoScreenInfo.screenInfo());
        termostatoScreenInfo.changeMode(program);
        assertEquals("20.1 OFF P 20.0", termostatoScreenInfo.screenInfo());
        termostatoScreenInfo.newTemperature((float)19.2);
        assertEquals("19.2 ON P 20.0", termostatoScreenInfo.screenInfo());

    }

}