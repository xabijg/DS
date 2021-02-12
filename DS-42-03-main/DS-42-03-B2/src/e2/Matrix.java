package e2;

import java.util.Iterator;

public class Matrix implements Iterable<Integer>{

    private final int rows;
    private final int columns;
    private Integer[][] pos;
    private boolean iterator;

    // constructors

    public Matrix(int n, int m) {

        this.rows = n;
        this.columns = m;

        pos = new Integer[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                pos[i][j] = 0;
        }
    }

    public Matrix(int[][] x) throws Exception {

        this.rows = x.length;

        for (int i = 0; i < rows-1; i++) {

            if ( x[i].length != x[i+1].length ) {

                throw new Exception("Ragged matrix");

            }

        }

        this.columns = x[0].length;

        pos = new Integer[rows][columns];

        for (int i = 0; i < rows; i++) {

            for ( int j = 0; j < columns; j++ ) {

                setPos(i,j,x[i][j]);

            }
        }
    }

    // getters

    public int getPos(int x, int y) throws  ArrayIndexOutOfBoundsException {

        if ( ( x > rows ) || ( y > columns ) || ( x < 0 ) || ( y < 0 ) ) {

            throw new ArrayIndexOutOfBoundsException();

        }

        return this.pos[x][y];

    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public String getDimension () {

        String result = "";
        return result+this.rows+"x"+this.columns;

    }

    public boolean getIterator() {

        return this.iterator;

    }

    // setters

    public void setPos(int x, int y, int valor) throws ArrayIndexOutOfBoundsException {

        if ( ( x > rows ) || ( y > columns ) || ( x < 0 ) || ( y < 0 ) ) {

            throw new ArrayIndexOutOfBoundsException();

        } else {

            this.pos[x][y] = valor;

        }

    }

    public void setIterator (boolean iterator) {

        this.iterator = iterator;

    }

    // functions

    public int compareDimension(Matrix b) {

        if ((this.getRows() == b.getRows()) && (this.getColumns() == b.getColumns())) {

            return 0;

        } else {

            return -1;

        }
    }

    public String rowArray ( int row ) throws ArrayIndexOutOfBoundsException {

        if ( ( row < 0 ) || ( row > this.getRows() ) ) {

            throw new ArrayIndexOutOfBoundsException();

        }

        int i = 0;

        StringBuilder result = new StringBuilder("{ ");

        for (i = 0; i < this.getColumns() - 1; i++) {

            result.append(this.getPos(row, i)).append(",");

        }

        result.append(this.getPos(row, i)).append(" }");
        return result.toString();

    }

    public String columnsArray ( int column ) throws ArrayIndexOutOfBoundsException {

        if ( ( column < 0 ) || ( column > this.getColumns() ) ) {

            throw new ArrayIndexOutOfBoundsException();

        }

        int i = 0;

        StringBuilder result = new StringBuilder("{ ");

        for (i = 0; i < this.getRows() - 1; i++) {

            result.append(this.getPos(i, column)).append(",");

        }

        result.append(this.getPos(i, column)).append(" }");
        return result.toString();

    }

    public String bidimensionalArray() {

        int i = 0, j = 0;

        StringBuilder result = new StringBuilder();

        result.append("{ ");

        for (i = 0; i < this.rows; i++) {

            result.append("{ ");

            for (j = 0; j < this.getColumns(); j++) {

                if (j == getColumns()-1) {

                    if ( i == getRows() - 1 ) {

                        result.append(this.getPos(i, j)).append(" } }");

                    } else {

                        result.append(this.getPos(i, j)).append(" },");

                    }

                } else {

                    result.append(this.getPos(i,j)).append(",");

                }

            }

        }

        return result.toString();
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.rows; i++) {

            result.append("[ ");

            for (int j = 0; j < this.columns; j++){

                result.append(this.pos[i][j]).append(" ");

            }

            result.append("]");
            result.append("\n");

        }

        return result.toString();

    } // formato "bonito" con corchetes

    @Override
    public Iterator<Integer> iterator() {

        if (iterator) {

            return rowColumnIterator();

        } else {

            return columnRowIterator();

        }

    }

    public Iterator<Integer> rowColumnIterator() { return new RowColumnIterator<>(pos); }
    public Iterator<Integer> columnRowIterator() { return new ColumnRowIterator<>(pos); }


}