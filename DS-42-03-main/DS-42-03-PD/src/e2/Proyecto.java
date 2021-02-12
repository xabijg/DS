package e2;

import java.util.ArrayList;

public class Proyecto {

    private final String nombre;
    ArrayList<ElementoProyecto> elementos = new ArrayList<>();

    Proyecto(String nombre) { this.nombre = nombre; }

    public String getNombre() { return this.nombre; }

    public void anadir (ElementoProyecto elemento) {
        if (esRepetido(elemento)) {
            throw new IllegalArgumentException("Elemento ya asignado (" + elemento.getNombre() + ") ");

        } else {
            elementos.add(elemento);
        }
    }

    public float getHoras() {
        float totalHoras = 0;
        for (ElementoProyecto elemento : elementos) {
            totalHoras += elemento.getHoras();
        }
        return totalHoras;
    }

    public float getDinero() {
        float totalDinero = 0;
        for (ElementoProyecto elemento : elementos) {
            totalDinero += elemento.getDinero();
        }
        return totalDinero;
    }

    public String imprimir() {
        StringBuilder result = new StringBuilder();
        result.append("Proyect ").append(getNombre()).append(": ").append(getHoras()).append(" hours, ").append(getDinero()).append(" €\n");
        for (ElementoProyecto elemento : elementos) {
            result.append("\t ").append(elemento.imprimir());
        }
        return result.toString();
    }

    public boolean esRepetido( ElementoProyecto elemento ) {
        for (ElementoProyecto elemento1 : elementos) {
            if (elemento1.esRepetido(elemento)) {
                return true;
            }
        }
        return false;
    }

}

