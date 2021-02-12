package e2;

import java.util.ArrayList;

public class Equipo extends ElementoProyecto{

    ArrayList<ElementoProyecto> elementos = new ArrayList<>();

    Equipo (String nombre) {
        super(nombre);
    }

    @Override
    public ArrayList<ElementoProyecto> getElementos() {
        ArrayList<ElementoProyecto> result = new ArrayList<>();
        for ( ElementoProyecto elemento: elementos ) {
            result.addAll(elemento.getElementos());
        }
        return result;
    }

    public void anadir ( ElementoProyecto elemento ) {
        if (esRepetido(elemento)) {
            throw new IllegalArgumentException("Elemento ya asignado (" + elemento.getNombre() + ") ");
        } else {
            elementos.add(elemento);
        }
    }

    @Override
    public float getHoras() {
        float totalHoras = 0;
        for (ElementoProyecto elemento: elementos) {
            totalHoras += elemento.getHoras();
        }
        return totalHoras;
    }

    @Override
    public boolean equals(ElementoProyecto elemento) {
        if ( elemento.getClass().equals(this.getClass()) ) {
            Equipo elementoInt = (Equipo) elemento;
            return elemento.getDinero() == getDinero() && elemento.getHoras() == getHoras() &&
                    elemento.getNombre().equals(getNombre()) && elementoInt.elementos.size() == this.elementos.size();

        } else {
            return false;
        }
    }

    @Override
    public float getDinero() {
        float totalDinero = 0;
        for (ElementoProyecto elemento: elementos) {
            totalDinero += elemento.getDinero();
        }
        return totalDinero;
    }

    @Override
    public String imprimir() {
        return "Team " + getNombre() + ": " + getHoras() + " hours, " + getDinero() + " €\n" +
                imprimirElementos();
    }

    private String imprimirElementos() {
        StringBuilder result = new StringBuilder();
        for (ElementoProyecto elemento: elementos) {
            result.append("\t").append(elemento.imprimir());
        }
        return result.toString().replaceAll("(?m)^", "\t");
    }

    @Override
    public boolean esRepetido( ElementoProyecto elementoProyecto ) {
        for ( ElementoProyecto elemento : elementos) {
            if (elemento.esRepetido(elementoProyecto)) {
                return true;
            }
        }
        return false;
    }
}
