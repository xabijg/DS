package e2;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public abstract class ElementoProyecto {

    private final String nombre;

    ElementoProyecto (String nombre) { this.nombre = nombre; }

    public ArrayList<ElementoProyecto> getCotrabajadores ( Proyecto p ) {
        if ( !p.esRepetido(this) ) {
            throw new NoSuchElementException( "El elemento " + this.nombre + " no está asignado a " + p.getNombre());
        }
        ArrayList<ElementoProyecto> result = new ArrayList<>();
        for ( ElementoProyecto elemento : p.elementos ) {
            result.addAll(elemento.getElementos());
        }
        for ( ElementoProyecto elemento : this.getElementos() ) {
            result.remove(elemento);
        }
        return result;
    }

    public String getNombre() { return this.nombre; }

    public abstract ArrayList<ElementoProyecto> getElementos ();
    public abstract boolean esRepetido ( ElementoProyecto elemento );
    public abstract String imprimir();
    public abstract float getDinero();
    public abstract float getHoras();
    public abstract boolean equals(ElementoProyecto elemento);

}
