package e2;

public class Code {

    public static boolean isKeypadValid(char[][] keypad) {

        String secuencia = "1234567890ABCDE";
        boolean tecladoNulo = false, filasMal = false, columnasMal = false;
        int z , filas = 0, columnas = 0;

        if (keypad == null) {

            tecladoNulo = true;                          // DEVUELVE FALSO SI EL TECLADO ES NULO(NO TIENE ELEMENTOS)

        } else {

            filas = keypad.length;
            columnas = keypad[0].length;
        }

        if (!tecladoNulo) {

            z = 0;
            for (int x = 0; x < filas; x++) {

                if (keypad[x] == null) {                // COMPROBAMOS QUE NINGUNA POSICIÓN CONTENGA UN NULO

                    tecladoNulo = true;

                } else {

                    for (int y = 0; y < columnas; y++) {


                        char c1 = keypad[x][y];
                        char c2 = secuencia.charAt(z);

                        if (c1 != c2) {                             // DEVUELVE FALSO SI LOS VALORES RECIBIDOS DE LAS FILAS NO SON COMO LOS DE LA MÁXIMA SECUENCIA VÁLIDA

                            filasMal = true;
                            y = columnas + 1;

                        } else {

                            z++;

                        }

                    }

                }

            }


        }

        if (!tecladoNulo && filasMal) {                                          // CUMPLICADAS LAS CONDICIONES DE NO TENER UN TECLADO NULO O LAS FILAS INCORRECTAS , PASAMOS A COMPROBAR LAS COLUMNAS

            z = 0;
            for (int y = 0; y < columnas; y++) {

                for (int x = 0; x < filas; x++) {

                    char c1 = keypad[x][y];
                    char c2 = secuencia.charAt(z);

                    if (c1 != c2) {

                        columnasMal = true;                                        // DEVUELVE FALSO SI LOS VALORES RECIBIDOS DE LAS COLUMNAS NO SON COMO LOS DE LA MÁXIMA SECUENCIA VÁLIDA
                        x = columnas + 1;

                    } else {

                        z++;

                    }

                }

            }

        }

        return !tecladoNulo && !columnasMal;

    }


    public static boolean areMovementsValid(String[] movements) {

        boolean result = false, check = true;
        int i , j ;

        if (movements == null) {

            result = false;

        } else {

            char cU = 'U', cD = 'D', cL = 'L', cR = 'R';            // CONJUNTO DE MOVIMIENTOS VÁLIDOS GUARDADOS EN cU,cD,cL,cR
            for (i = 0; i < movements.length; i++) {

                if (movements[i] == null || movements[i].length() == 0) {

                    result = false;
                    i = movements.length;

                } else {

                    for (j = 0; j < movements[i].length() && check; j++) {

                        char c1 = movements[i].charAt(j);

                        result = c1 == cU || c1 == cD || c1 == cL || c1 == cR;              // COMPROBAMOS QUE LOS VALORES QUE NOS ENTRAN SON CHAR DEL TIPO U,D,R,L . EN CASO CONTRARIO DEVOLVEMOS FALSO
                        if (!result) {
                            check = false;
                        }

                    }
                }

            }

        }

        return result;
    }

    public static String obtainCode(char[][] keypad, String[] movements) {

        StringBuilder result = new StringBuilder();

        if (!isKeypadValid(keypad) || !areMovementsValid(movements)) {                      // LANZA UNA EXCEPCIÓN SI ALGUNO DE LOS DATOS PROPORCIONADOS NO SON VÁLIDOS

            throw new IllegalArgumentException();

        } else {

            int x = 0, y = 0;
            char cU = 'U', cD = 'D', cL = 'L', cR = 'R';                                    // DEFINIMOS LOS MOVIMIENTOS VÁLIDOS

            for (String movement : movements) {

                for (int j = 0; j < movement.length(); j++) {                               // RECORREMOS MEDIANTE UN BUCLE EL CONTENIDO DE MOVEMENTS PARA MOVERNOS EN UN SENTIDO A OTRO SEGÚN EL CARAÁCTER

                    if (cU == movement.charAt(j)) {

                        if (x > 0) {                                                        // SUBIMOS UNA POSICIÓN VERTICALMENTE CON X SI LA POSICIÓN ACTUAL ES MAYOR QUE 0
                            x--;
                        }

                    } else if (cD == movement.charAt(j)) {

                        if (x < keypad.length - 1) {                                        // BAJAMOS UNA POSICIÓN VERTICALMENTE CON X SI LA POSICIÓN ACTUAL ES MENOR QUE EL ÚLTIMO VALOR DEL TECLADO
                            x++;
                        }

                    } else if (cR == movement.charAt(j)) {

                        if (y < keypad[0].length - 1) {                                     // NOS MOVEMOS UNA POSICIÓN HORIZONTALMENTE CON Y A LA DERECHA SI LA POSICIÓN ACTUAL ES MENOR QUE EL ÚLTIMO VALOR DEL TECLADO
                            y++;
                        }

                    } else if (cL == movement.charAt(j)) {

                        if (y > 0) {                                                        // NOS MOVEMOS UNA POSICIÓN HORIZONTALMENTE CON Y A LA IZQUIERDA SI LA POSICIÓN ACTUAL ES MENOR QUE EL ÚLTIMO VALOR DEL TECLADO
                            y--;
                        }

                    }

                }

                result.append(keypad[x][y]);                                               // DEVOLVEMOS LOS VALORES CONCATENADOS DESPUÉS DE CADA INSTRUCCIÓN

            }

            return result.toString();

        }

    }
}