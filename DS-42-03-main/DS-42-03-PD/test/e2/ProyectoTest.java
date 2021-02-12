package e2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.PropertyResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {

    Trabajador t1 = new Trabajador("t1", 70, 1800);
    Trabajador t2 = new Trabajador("t2", 90, 2100);

    ArrayList<ElementoProyecto> trabajadores = new ArrayList<>();

    @Test
    void anadir() {

        Proyecto proyectoAnadir = new Proyecto("proyectoAnadir");
        Equipo equipo1 = new Equipo("Equipo1");
        Equipo equipo2 = new Equipo("Equipo2");

        equipo1.anadir(t1);
        proyectoAnadir.anadir(equipo1);
        proyectoAnadir.anadir(t2);
        equipo2.anadir(equipo1);

        ArrayList<ElementoProyecto> trabajadores = new ArrayList<>();
            trabajadores.add(t1);
        ArrayList<ElementoProyecto> proyecto = new ArrayList<>();
            proyecto.add(equipo1);
            proyecto.add(t2);

        assertEquals( proyecto, proyectoAnadir.elementos );
        assertEquals( trabajadores, equipo1.elementos );

        assertThrows( IllegalArgumentException.class, () -> proyectoAnadir.anadir(t1) );
        assertThrows( IllegalArgumentException.class, () -> proyectoAnadir.anadir(t2) );
        assertThrows( IllegalArgumentException.class, () -> proyectoAnadir.anadir(equipo1) );
        assertThrows( IllegalArgumentException.class, () -> proyectoAnadir.anadir(equipo2) );

    }

    @Test
    void getHoras() {

        Proyecto proyectoHoras = new Proyecto("proyectoAnadir");
        Equipo equipo1 = new Equipo("Equipo1");

        equipo1.anadir(t1);
        proyectoHoras.anadir(t2);
        proyectoHoras.anadir(equipo1);

        assertEquals(t1.getHoras() + t2.getHoras(), proyectoHoras.getHoras());
        assertEquals(t1.getHoras(), equipo1.getHoras());

    }

    @Test
    void getDinero() {

        Proyecto proyectoHoras = new Proyecto("proyectoAnadir");
        Equipo equipo1 = new Equipo("Equipo1");

        equipo1.anadir(t1);
        proyectoHoras.anadir(t2);
        proyectoHoras.anadir(equipo1);

        assertEquals(t2.getDinero() + t1.getDinero(), proyectoHoras.getDinero());
        assertEquals(t1.getDinero(), equipo1.getDinero());

    }

    @Test
    void imprimir() { // crease unha estructura de proxecto complexa, con equipos dentro de equipos, e comprobase que sexa correcta. Neste caso a xerarcía do String é a misma que se introduciu anteriormente

        Proyecto proyectoImprimir = new Proyecto("imprimir");
        Equipo e1 = new Equipo("e1");
        Equipo e2 = new Equipo("e2");
        Trabajador t3 = new Trabajador("t3", 60, 1300);
        Trabajador t4 = new Trabajador("t4", 80, 2300);

        e1.anadir(t1);
        e1.anadir(t2);
        e2.anadir(t3);
        e2.anadir(e1);

        proyectoImprimir.anadir(e2);
        proyectoImprimir.anadir(t4);

        System.out.println(proyectoImprimir.imprimir());

    }

    @Test
    void esRepetido() {

        Proyecto proyectoEsRepetido = new Proyecto("esRepetido");
        Equipo e1 = new Equipo("e1");
        Equipo e2 = new Equipo("e2");

        assertFalse(proyectoEsRepetido.esRepetido(t1));
        assertFalse(proyectoEsRepetido.esRepetido(t2));
        assertFalse(proyectoEsRepetido.esRepetido(e1));
        assertFalse(proyectoEsRepetido.esRepetido(e2));
        e1.anadir(t1);                                      // test de esRepetido con proyectos
        proyectoEsRepetido.anadir(e1);
        assertTrue(proyectoEsRepetido.esRepetido(t1));
        assertTrue(proyectoEsRepetido.esRepetido(e1));

        assertTrue(e1.esRepetido(t1));
        assertTrue(e1.esRepetido(e1));  // test de esRepetido con equipos
        assertFalse(e1.esRepetido(t2));
        assertFalse(e1.esRepetido(e2));

        assertFalse(t1.esRepetido(t2));
        assertTrue(t1.esRepetido(t1));
        assertFalse(t2.esRepetido(t1)); // test de esRepetido con traballadores. Ten implementación para a recursividade da función
        assertTrue(t2.esRepetido(t2));  // esRepetido con equipos


    }
}