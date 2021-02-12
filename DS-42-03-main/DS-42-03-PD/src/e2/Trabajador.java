package e2;

import java.util.ArrayList;

public class Trabajador extends ElementoProyecto {

    private final float horas;
    private final float dinero;

    Trabajador (String nombre, float hours, float dinero) {
        super(nombre);
        this.horas = hours;
        this.dinero = dinero;
    }

    @Override
    public float getHoras() { return this.horas; }

    @Override
    public boolean equals(ElementoProyecto elemento) {
        return elemento.getDinero() == dinero && elemento.getHoras() == horas &&
                elemento.getNombre().equals(getNombre()) && elemento.getClass().equals(this.getClass());
    }

    @Override
    public float getDinero() { return this.dinero; }

    @Override
    public ArrayList<ElementoProyecto> getElementos () {
        ArrayList<ElementoProyecto> result = new ArrayList<>();
        result.add(this);
        return result;
    }

    public boolean esRepetido(ElementoProyecto elemento) {
        if ( elemento.getClass().equals(Trabajador.class) ) {
            return esRepetidoT((Trabajador) elemento);

        } else {
            return esRepetidoE((Equipo) elemento);
        }
    }

    private boolean esRepetidoT( Trabajador trabajador ) {
        return this.equals(trabajador);
    }

    private boolean esRepetidoE( Equipo equipo ) {
        return equipo.esRepetido(this);
    }

    @Override
    public String imprimir() {
        return "Worker " + getNombre() + ": " + horas + " hours , " + dinero + " €\n";
    }

}
