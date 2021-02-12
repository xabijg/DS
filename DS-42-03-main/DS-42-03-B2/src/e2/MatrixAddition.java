package e2;

import java.util.Iterator;

public class MatrixAddition {

    public Matrix Suma ( Matrix a, Matrix b ) {

        if (a.compareDimension(b) == 0) {

            Matrix result = new Matrix(a.getRows(), a.getColumns());

            a.setIterator(b.getIterator()); // para que as dúas matrices se recorran igual
            Iterator<Integer> iteratorA = a.iterator();
            Iterator<Integer> iteratorB = b.iterator();

            if (a.getIterator()) {

                for (int rows = 0; rows < a.getRows(); rows++) {

                    for (int columns = 0; columns < b.getColumns(); columns++) {

                        result.setPos(rows, columns, iteratorA.next() + iteratorB.next());

                    }

                }

            } else {

                for (int columns = 0; columns < a.getColumns(); columns++) {

                    for (int rows = 0; rows < b.getRows(); rows++) {

                        result.setPos(rows, columns, iteratorA.next() + iteratorB.next());

                    }

                }

            }

            return result;

        } else {

            throw new ArithmeticException();

        }

    }

}
