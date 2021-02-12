package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    int[][] a = {{1,2,3},{4,5,6}};

    Matrix test1 = new Matrix(6, 5);
    Matrix test2 = new Matrix(a);

    MatrixTest() throws Exception {}

    @Test
    void getPos() {

        assertEquals(1, test2.getPos(0,0));
        assertEquals(2, test2.getPos(0,1));
        assertEquals(3, test2.getPos(0,2));
        assertEquals(4, test2.getPos(1,0));
        assertEquals(5, test2.getPos(1,1));
        assertEquals(6, test2.getPos(1,2));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> test2.getPos(6,7));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> test2.getPos(1,7));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> test2.getPos(6,1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> test2.getPos(-1,1));

    }

    @Test
    void getRows() {

        assertEquals(6, test1.getRows());
        assertEquals(2, test2.getRows());

    }

    @Test
    void getColumns() {

        assertEquals(5, test1.getColumns());
        assertEquals(3, test2.getColumns());

    }

    @Test
    void getDimension() {

        assertEquals("6x5", test1.getDimension());
        assertEquals("2x3", test2.getDimension());

    }

    @Test
    void setPos() {

        test1.setPos(4,1, 1);
        test1.setPos(3,2, 2);
        test1.setPos(2,3, 3);
        test1.setPos(1,4, 4);
        test1.setPos(0,4, 5);
        test1.setPos(2,4, 6);

        assertEquals(1, test1.getPos(4,1));
        assertEquals(2, test1.getPos(3,2));
        assertEquals(3, test1.getPos(2,3));
        assertEquals(4, test1.getPos(1,4));
        assertEquals(5, test1.getPos(0,4));
        assertEquals(6, test1.getPos(2,4));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> test1.setPos(8,5,1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> test1.setPos(4,5,1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> test1.setPos(8,4,1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> test1.setPos(-1, 0, 0));

    }

    @Test
    void compareDimension() {

        Matrix internalTest1 = new Matrix(6,5);
        Matrix internalTest2 = new Matrix(2,3);

        assertEquals(test1.getDimension(), internalTest1.getDimension());
        assertEquals(test2.getDimension(), internalTest2.getDimension());

        assertNotEquals(test1.getDimension(), test2.getDimension());
        assertNotEquals(internalTest1.getDimension(), internalTest2.getDimension());

    }

    @Test
    void rowArray() {

        assertEquals("{ 0,0,0,0,0 }", test1.rowArray(0));
        assertEquals("{ 0,0,0,0,0 }", test1.rowArray(1));
        assertEquals("{ 0,0,0,0,0 }", test1.rowArray(2));
        assertEquals("{ 0,0,0,0,0 }", test1.rowArray(3));
        assertEquals("{ 0,0,0,0,0 }", test1.rowArray(4));
        assertEquals("{ 0,0,0,0,0 }", test1.rowArray(5));

        assertEquals("{ 1,2,3 }", test2.rowArray(0));
        assertEquals("{ 4,5,6 }", test2.rowArray(1));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> test1.rowArray(-1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> test1.rowArray(6));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> test2.rowArray(-2));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> test2.rowArray(2));

    }

    @Test
    void columnsArray() {

        assertEquals("{ 0,0,0,0,0,0 }", test1.columnsArray(0));
        assertEquals("{ 0,0,0,0,0,0 }", test1.columnsArray(1));
        assertEquals("{ 0,0,0,0,0,0 }", test1.columnsArray(2));
        assertEquals("{ 0,0,0,0,0,0 }", test1.columnsArray(3));
        assertEquals("{ 0,0,0,0,0,0 }", test1.columnsArray(4));

        assertEquals("{ 1,4 }", test2.columnsArray(0));
        assertEquals("{ 2,5 }", test2.columnsArray(1));
        assertEquals("{ 3,6 }", test2.columnsArray(2));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> test1.columnsArray(-1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> test1.columnsArray(5));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> test2.columnsArray(-2));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> test2.columnsArray(3));

    }

    @Test
    void bidimensionalArray() {

        assertEquals("{ { 0,0,0,0,0 },{ 0,0,0,0,0 },{ 0,0,0,0,0 },{ 0,0,0,0,0 },{ 0,0,0,0,0 },{ 0,0,0,0,0 } }", test1.bidimensionalArray());
        assertEquals("{ { 1,2,3 },{ 4,5,6 } }", test2.bidimensionalArray());

    }

    @Test
    void testToString() {

        assertEquals("[ 0 0 0 0 0 ]\n[ 0 0 0 0 0 ]\n[ 0 0 0 0 0 ]\n[ 0 0 0 0 0 ]\n[ 0 0 0 0 0 ]\n[ 0 0 0 0 0 ]\n", test1.toString());
        assertEquals("[ 1 2 3 ]\n[ 4 5 6 ]\n", test2.toString());

    }

    @Test
    void setIterator() {

        test1.setIterator(true);
        test2.setIterator(false);

        assertTrue(test1.getIterator());
        assertFalse(test2.getIterator());

        test1.setIterator(false);
        test2.setIterator(true);

        assertFalse(test1.getIterator());
        assertTrue(test2.getIterator());

    }

    @Test
    void getIterator() {

        test1.setIterator(true);
        test2.setIterator(false);

        assertTrue(test1.getIterator());
        assertFalse(test2.getIterator());

        test1.setIterator(false);
        test2.setIterator(true);

        assertFalse(test1.getIterator());
        assertTrue(test2.getIterator());

    }

}