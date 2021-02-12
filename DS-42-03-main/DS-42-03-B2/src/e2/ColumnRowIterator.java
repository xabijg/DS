package e2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ColumnRowIterator<T> implements Iterator <T> {

    private final T[][] matrix;
    private int rowsPos;
    private int columnsPos;

    public ColumnRowIterator(T[][] matrix) {

        this.matrix = matrix;
        this.rowsPos = 0;
        this.columnsPos = 0;
    }

    @Override
    public boolean hasNext() {

        int rows = matrix.length;
        int columns = matrix[0].length;

        if ( columnsPos >= columns ) {

            return false;

        } else {

            return rowsPos < rows || columnsPos != columns - 1;

        }

    }

    @Override
    public T next() {

        int rows = matrix.length;

        if (!hasNext()) {

            throw new NoSuchElementException();

        } else {

            if (rowsPos >= rows ) {

                columnsPos++;
                rowsPos = 0;

            }

            return matrix[rowsPos++][columnsPos];

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
