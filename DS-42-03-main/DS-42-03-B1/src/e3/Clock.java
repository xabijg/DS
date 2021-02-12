package e3;

import java.text.DecimalFormat;

public class Clock {

    private int HOURS;              //
    private int MINUTES;            //
    private int SECONDS;            // SE DECLARAN LOS ELEMENTOS DE CADA RELOJ
    private Period PERIOD;          //

    enum Period {

        AM,
        PM

    }

    public Clock ( String s) {

        for ( int i = 0; i < 8; i++ ){

            char A = s.charAt(i);
            if ( Character.isLetter(A) ) {

                throw new IllegalArgumentException();   // SI ALGÚN ELEMENTO DEL STRING ES UNHA LETRA, DEVUELVE UNHA EXCEPCIÓN

            }

        }

        if (s.length() == 11) {                         // CASO DEL RELOJ CON FORMATO "HH:MM:SS PP"

            String[] parts = s.split(":");        // SE SEPARA LA CADENA TENIENDO EN CUENTA EL CARÁCTER ":"

            if (Integer.parseInt(parts[0]) > 12 || Integer.parseInt(parts[1]) > 59) {

                throw new IllegalArgumentException();   // SI LAS HORAS SON MAYORES QUE 12 O LOS MINUTOS MAYORES QUE 59 GENERA UNHA EXCEPCIÓN

            }

            this.HOURS = Integer.parseInt(parts[0]);
            this.MINUTES = Integer.parseInt(parts[1]);
            String SECONDS_P = parts[2];

            parts = SECONDS_P.split(" ");        // COMO ENTRE LOS SEGUNDOS Y EL PERÍODO NO EXITE ":", SE VUELVE A SEPARAR TENIENDO EN CUENTA EL ESPACIO

            if (Integer.parseInt(parts[0]) > 59) {

                throw new IllegalArgumentException();   // SI LOS SEGUNDOS SON MAYORES DE 59 DEVUELVE UNA EXCEPCIÓN

            }

            this.SECONDS = Integer.parseInt(parts[0]);
            if (parts[1].equals("AM")) {                // CASO PERÍODO = AM

                this.PERIOD = Period.AM;

            } else if (parts[1].equals("PM")) {

                this.PERIOD = Period.PM;               // CASO PERIODO = PM

            } else if  (!parts[1].equals("AM") && !parts[1].equals("PM")) {

                throw new IllegalArgumentException();

            }

        } else if (s.length() == 8) {       // CASO DEL RELOJ CON FORMATO "HH:MM:SS"

            String[] parts = s.split(":");      // SE SEPARAN LOS CAMPOS HORAS, MINUTOS Y SEGUNDOS
            this.HOURS = Integer.parseInt(parts[0]);
            this.MINUTES = Integer.parseInt(parts[1]);
            this.SECONDS = Integer.parseInt(parts[2]);

            if (HOURS > 23 || MINUTES > 59 || SECONDS > 59) {  // SI LAS HORAS SON MAYORES QUE 24 O LOS MINUTOS O LOS SEGUNDOS MAYORES QUE 59 DEVUELVE UNA EXCEPCIÓN

                throw new IllegalArgumentException();

            } else {

                if (1 < HOURS && HOURS < 11) {      // A LAS HORAS ENTRE LA 1  Y LAS 11 SE LES AÑADE EL PERÍODO AM

                    this.PERIOD = Period.AM;

                } else if (12 < HOURS && HOURS < 23) {  // LAS HORAS ENTRE LAS 12 Y LAS 23 SE LES RESTA 12 Y SE ASIGNA EL PERÍODO PM

                    this.HOURS = HOURS - 12;
                    this.PERIOD = Period.PM;

                } else if (HOURS == 0) {        // PARA EL CASO ESPECIAL DE LAS 00 SE LE SUMA DOCE Y SE LE ASIGNA EL PERÍODO AM

                    this.HOURS = HOURS + 12;
                    this.PERIOD = Period.AM;

                }
            }
        }
    }

    public Clock ( int hours , int minutes , int seconds ) {

        if ( hours > 24 || minutes > 59 || seconds > 59 ){      // SI LAS HORAS SON MAYORES QUE 24 O LOS MINUTOS O LOS SEGUNDOS MAYORES QUE 59 DEVUELVE UNA EXCEPCIÓN

            throw new IllegalArgumentException();

        } else {

            if ( 1 < hours && hours < 11 ) {        // A LAS HORAS ENTRE LA 1  Y LAS 11 SE LES AÑADE EL PERÍODO AM

                this.PERIOD = Period.AM;

            } else if ( 12 < hours && hours < 23 ) {        // LAS HORAS ENTRE LAS 12 Y LAS 23 SE LES RESTA 12 Y SE ASIGNA EL PERÍODO PM

                this.HOURS = hours -12;
                this.PERIOD = Period.PM;

            } else if ( hours == 0 ){           // PARA EL CASO ESPECIAL DE LAS 00 SE LE SUMA DOCE Y SE LE ASIGNA EL PERÍODO AM

                this.HOURS = hours +12;
                this.PERIOD = Period.AM;

            }

            this.MINUTES = minutes;            // SE ASIGNAN LOS MINUTOS Y SEGUNDOS YA QUE NO ESTÁN SUJETOS A VARIACIONES DERIVADAS DEL PERÍODO
            this.SECONDS = seconds;
        }
    }

    public Clock ( int hours , int minutes , int seconds , Period period ) {

        if ( hours > 12 || minutes > 59 || seconds > 59){       // SI LAS HORAS SON MAYORES QUE 12 O LOS MINUTOS O LOS SEGUNDOS MAYORES QUE 59 DEVUELVE UNA EXCEPCIÓN

            throw new IllegalArgumentException();

        } else {

            this.HOURS = hours;
            this.MINUTES = minutes;
            this.SECONDS = seconds;
            this.PERIOD = period;

        }

    }

    public int getHours24 () {                                  // COMO ALMACENAMOS LAS HORAS EN FORMATO AM/PM, SE TRANSFORMA A FORMATO 24 HORAS

        if(PERIOD.equals(Period.PM)){
            HOURS = 12 + HOURS;
        }
        else if ( HOURS == 12 && PERIOD.equals(Period.AM) )
            HOURS = 0;

        return HOURS;
    }

    public int getHours12 () {
        return HOURS;
    }

    public int getMinutes () {
        return MINUTES;
    }

    public int getSeconds () {
        return SECONDS;
    }

    public Period getPeriod () {
        return PERIOD;
    }

    public String printHour12 () {

        String result;
        DecimalFormat df = new DecimalFormat("#00");

        result=df.format(HOURS)+":"+df.format(MINUTES)+":"+df.format(SECONDS)+" "+PERIOD;
        return result;
    }


    public String printHour24 () {

        String result;
        DecimalFormat df = new DecimalFormat("#00");

        if ( PERIOD.equals(Period.PM) ){

            HOURS = HOURS +12;

        } else if ( HOURS == 12 && PERIOD.equals(Period.AM) ){

            HOURS = 0;
        }

        result=df.format(HOURS)+":"+df.format(MINUTES)+":"+df.format(SECONDS);
        return result;


    }

    @Override
    public boolean equals(Object o) {           // MÉTODO PARA COMPARAR SI EL OBJETO ACTUAL ES IGUAL AL OBJETO PASADO POR PARÁMETRO
        if (this == o) return true;             // SI ES IDÉNTICO DEVOLVEMOS TRUE Y EN CASO DE QUE SEA NULO O TIENE UNA CLASE DISTINTA DEVOLVEMOS FALSO
        if (o == null || getClass() != o.getClass()) return false;
        Clock clock = (Clock) o;
        return HOURS == clock.HOURS &&          // COMPARAMOS LOS VALORES Y DEVOLVEMOS EL RESULTADO
                MINUTES == clock.MINUTES &&
                SECONDS == clock.SECONDS &&
                PERIOD == clock.PERIOD;
    }

    @Override
    public int hashCode() {                     // PARA OBTENER EL HASHCODE 31 SE MULTIPLICAN LOS VALORES ENTEROS POR 31 Y SE SUMA EL HASHCODE DE LOS ELEMENTOS QUE NO SON ENTEROS
        int result=HOURS+MINUTES+SECONDS;
        result=31*result+PERIOD.hashCode();
        return result;
    }

}
