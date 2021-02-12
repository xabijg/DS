package e1;

public class StringUtilities {

    public static boolean isValidMix(String a, String b, String c) {

        int ltotal = a.length() + b.length(), ta = 0, tb = 0;

        if (ltotal != c.length()){      // SI LA CADENA C TIENE UNA LONGITUD DISTINTA A LAS SUMA DE LAS CADENAS A Y B DEVUELVE FALSO

            return false;

        } else {

            for (int i = 0; i < ltotal ; i++) {

                if (  ta < a.length() && a.charAt(ta) == c.charAt(i) ){     // TA CUENTA CUANTOS ELEMENTOS DE LA CADENA A HAN APARECIDO EN LA CADENA C

                    ta++;

                }

                else if ( tb < b.length() && b.charAt(tb) == c.charAt(i) ){     // TB CUENTA CUANTOS ELEMENTOS DE LA CADENA B HAN APARECIDO EN LA CADENA C

                    tb++;

                }

                else {

                    i = ltotal;

                }

            }

        }

        return ta == a.length() && tb == b.length(); // COMPARA SI TODOS LOS ELEMENTOS DE A Y B HAN APARECIDO EN LA CADENA C, Y DEVUELVE EL RESULTADO


    }

    public static String generateRandomValidMix(String s1, String s2) {

        int t1 = 0, t2 = 0, n;

        StringBuilder both = new StringBuilder();

        both.append(s1).append(s2);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < both.length() || result.length() < both.length(); i++) {

            n = (int) (Math.random() * (2));        // SE GENERA UN NÚMERO PSEUDO-ALEATORIO (1 O 0);
            if ( n == 0 && t1 != s1.length() ) {    // SI EL NÚMERO ES 0 SE INSERTA EL CARÁCTER DE LA POSICIÓN T1 DE A EN RESULT

                result.append(s1.charAt(t1));
                t1++;

            } else if ( n == 1 && t2 != s2.length() ) {     // SI EL NÚMERO ES 1 SE INSERTA EL CARÁCTER DE LA POSICIÓN T2 DE B EN RESULT

                result.append(s2.charAt(t2));
                t2++;

            }

        }

        return result.toString();

    }

}