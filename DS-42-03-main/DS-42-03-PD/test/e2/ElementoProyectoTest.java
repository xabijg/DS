package e2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ElementoProyectoTest {

    Trabajador t1 = new Trabajador("t1", 60, 1800);
    Trabajador t2 = new Trabajador("t2", 80, 2100);
    Trabajador t3 = new Trabajador("t3", 20, 600);
    Trabajador t4 = new Trabajador("t4", 60, 1800);
    Trabajador t5 = new Trabajador("t5", 80, 2100);
    Trabajador t6 = new Trabajador("t6", 20, 600);

    Equipo e1 = new Equipo("e1");
    Equipo e2 = new Equipo("e2");

    Proyecto p = new Proyecto("p");

    @Test
    void getCotrabajadores() {

        ArrayList<ElementoProyecto> todos = new ArrayList<>();
            todos.add(t1);
            todos.add(t2);
            todos.add(t3);
            todos.add(t4);
            todos.add(t5);
            todos.add(t6);


        e1.anadir(t1);
        e1.anadir(t2);
        e2.anadir(t3);
        e2.anadir(t4); // engadimos todos os traballadores a p en diferentes grupos
        p.anadir(e1);
        p.anadir(e2);
        p.anadir(t5);
        p.anadir(t6);

        todos.remove(t1);
        assertEquals( todos,t1.getCotrabajadores(p)); // mostra todos os traballadores menos o traballador que invocoua función
        todos.add(t1);

    }
}