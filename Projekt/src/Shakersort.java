/*
Code by: Jonas Rhbary
Date: 20/01/21
About: Dieses Programm sortiert ein eingelesenes .dat File und sortiert die Zahlen dann mithilfe vom Shakesort
*/
public class Shakersort {
    long start = System.nanoTime();

    int k;
    int counter;


    public int[] sort(int[] zahlen) {

        int i = 0, l = zahlen.length;
        while (i < l) {
            shaker1(i, l, zahlen);
            l--; counter++;
            shaker2(i, l, zahlen);
            i++; counter++;
        }
        return zahlen;

    }

    public void shaker1(int i, int l, int[] zahlen) {
        for (int j = i; j < l - 1; j++) {
            if (zahlen[j] > zahlen[j + 1]) {
                k = zahlen[j];
                zahlen[j] = zahlen[j + 1];
                zahlen[j + 1] = k;
            }
        }
    }


    public void shaker2(int i, int l, int[] zahlen) {
        for (int j = l - 1; j >= i; j--) {
            if (zahlen[j] > zahlen[j + 1]) {
                k = zahlen[j];
                zahlen[j] = zahlen[j + 1];
                zahlen[j + 1] = k;
            }
        }
    }


    long finish = System.nanoTime();
    int zeit = (int) (finish - start);
    Runtime rt = Runtime.getRuntime();
    int memory = (int) (rt.totalMemory() - rt.freeMemory());


    int[] werte = {counter, zeit, memory};


    public  void shakeit(int[] zahlen){
        Shakersort ss = new Shakersort();
        int[] arr = ss.sort(zahlen);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + ": " + arr[i]);
        }

    }


}