/**
 * Diese Klasse beinhaltet das Main und eine Methode, die die Daten von dem dat-File in ein array umwandelt
 *
 * @author Martin Düppenbecker
 * @version 1.0
 * @since 20.01.2021
 */

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class mainKlasse {

    /**
     * @param args
     *
     * Ist das Main, von wo die Methoden ausgeführt werden
     */
    public static void main(String[] args) {

        int[] origZahlen = datEinlesen(1000);
        int[] zahlen = origZahlen;

        Sorter sorter;



        // --Martin
        System.out.println("Bubblesort: \n");
        sorter = new Bubblesort();
        ausgabeMesswerte(sorter.sort(zahlen));

        zahlen = origZahlen;

        // --Martin
        System.out.println("Quicksort: \n");
        sorter = new Quicksort();
        ausgabeMesswerte(sorter.sort(zahlen));

        zahlen = origZahlen;

        // --Marko
        System.out.println("Insertionsort: \n");
        sorter = new insertionSort();
        ausgabeMesswerte(sorter.sort(zahlen));

        zahlen = origZahlen;

        // --Sarah
        System.out.println("Gnomesort: \n");
        sorter = new Gnomesort();
        ausgabeMesswerte(sorter.sort(zahlen));

        zahlen = origZahlen;

        //  --Jonas
        System.out.println("Shakersort: \n");
        sorter = new Shakesort();
        ausgabeMesswerte(sorter.sort(zahlen));


        System.out.println(Arrays.toString(zahlen));

    }

    /**
     *
     * @param groesse
     * @return int[] zahlen
     *
     * Diese Funktion liest die Daten eines der 3 Files ein und gibt sie in einem int Array zurück
     */
    private static int[] datEinlesen(int groesse){

        //Schaut, dass die Grösse korrekt ist
        if (groesse != 10 && groesse != 100 && groesse != 1000){
            System.out.println("Bitte Grösse 10, 100 oder 1000 angeben");
            return null;
        }

        int zaehler = 0;
        int[] zahlen = new int[groesse];

        //Falls das File an einem Falschem Path ist, deshalb try-catch
        try {
            //Kreiert ein File- & ein Scanner-Objekt
            File data = new File("Projekt\\Datafiles\\" + groesse + "Digits.dat");
            Scanner scanner = new Scanner(data);

            //geht durch das File durch und liest es in ein Array ein
            while (zaehler < groesse){
                zahlen[zaehler] = scanner.nextInt();
                zaehler++;
            }
        }
        catch (Exception e){
            System.out.println("Ein Fehler ist aufgetreten:");
            System.out.println(e.getMessage());
        }

        finally {
            return zahlen;
        }
    }

    /**
     *
     * @param messwerte
     *
     * Diese Funktion printet die Messwerte anschaulich aus. Sort Methode als Parameter nehmen (weil es die Messwerte return)
     * und man so keine unnötige Variable braucht
     */
    private static void ausgabeMesswerte(double[] messwerte){
        System.out.println("Iteration Count: " + (int)messwerte[0]);
        System.out.println("Comparision Count: " + (int)messwerte[1]);
        System.out.println("Time Count: " + Double.parseDouble(String.valueOf(messwerte[2])) / 1000000 + " ms");    //Konvertiert von Nanosekunde zu Millisekunde
        System.out.println("Memory Count: " + messwerte[3]);

        System.out.println("------------------------\n");

    }
}
