package e2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EquipoTest {

    Trabajador t1 = new Trabajador("t1", 60, 1800);
    Trabajador t2 = new Trabajador("t2", 80, 2100);
    Trabajador t3 = new Trabajador("t3", 20, 600);

    @Test
    void getElementos() {

        Equipo e1 = new Equipo("e1");
        Equipo e2 = new Equipo("e2");

        e1.anadir(t1);
        e2.anadir(t2);
        e2.anadir(t3);
        e1.anadir(e2);

        ArrayList<Trabajador> resultado= new ArrayList<>();
            resultado.add(t1);
            resultado.add(t2);
            resultado.add(t3);

        assertEquals(resultado, e1.getElementos());

    }

    @Test
    void testEquals() {

        Equipo e1 = new Equipo("e1");
        Equipo e1b = new Equipo("e1");
        Equipo e2 = new Equipo("e2");
        Equipo e3 = new Equipo("e3");

        assertTrue(e1.equals(e1b)); // se está vacío e teñen o mesmo nome son iguais
        assertFalse(e1.equals(e2));
        assertFalse(e1.equals(e3));

        e1.anadir(t1);
        e1b.anadir(t2);
        e2.anadir(t1);

        assertFalse(e1.equals(e1b)); // cando deixan de ter os mesmos elementos son diferentes
        assertFalse(e1.equals(e2)); // aínda que teñan os mesmos elementos, cun nome diferente son distintas

        assertTrue(e1.equals(e1)); // unha matriz é igual a sí mesma


    }
}