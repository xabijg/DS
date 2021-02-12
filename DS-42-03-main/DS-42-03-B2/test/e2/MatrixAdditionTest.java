package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixAdditionTest {

    MatrixAddition mainTest = new MatrixAddition();

    int[][] a = {{1,2,3},{3,2,1}};
    int[][] b = {{3,2,1},{1,2,3}};
    int[][] c = {{1,2,3},{3,2,1},{0,0,0}};
    int[][] result = {{4,4,4},{4,4,4}};

    Matrix testA = new Matrix(a);
    Matrix testB = new Matrix(b);
    Matrix testC = new Matrix(c);
    Matrix testResult = new Matrix(result);

    MatrixAdditionTest() throws Exception {}

    @Test
    void suma() {

        testB.setIterator(true);

        assertEquals(testResult.toString(), mainTest.Suma(testA, testB).toString());
        assertEquals(testResult.toString(), mainTest.Suma(testB, testA).toString());

        testB.setIterator(false);

        assertEquals(testResult.toString(), mainTest.Suma(testA, testB).toString());
        assertEquals(testResult.toString(), mainTest.Suma(testB, testA).toString());

        assertThrows(ArithmeticException.class, () -> mainTest.Suma(testA, testC));
        assertThrows(ArithmeticException.class, () -> mainTest.Suma(testB, testC));
        assertThrows(ArithmeticException.class, () -> mainTest.Suma(testResult, testC));


    }

}