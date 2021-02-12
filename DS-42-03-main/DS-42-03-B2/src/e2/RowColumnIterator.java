package e2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RowColumnIterator<T> implements Iterator<T> {

    private final T[][] matrix;
    private int rowsPos;
    private int columnsPos;

    public RowColumnIterator(T[][] matrix) {

        this.matrix = matrix;
        this.rowsPos = 0;
        this.columnsPos = 0;

    }

    @Override
    public boolean hasNext() {

        int rows = matrix.length;
        int columns = matrix[0].length;

        if ( rowsPos >= rows ) {

            return false;

        } else {

            return columnsPos < columns || rowsPos != rows -1;

        }

    }

    @Override
    public T next() {

        int columns = matrix[0].length;
        if (!hasNext()) {

            throw new NoSuchElementException();

        } else {

            if (columnsPos >= columns) {

                rowsPos++;
                columnsPos = 0;

            }

            return matrix[rowsPos][columnsPos++];

        }

    }

    @Override
    public void remove() throws IllegalArgumentException {

        try {
            throw new IllegalAccessException();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
