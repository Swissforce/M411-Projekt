/**
 * Diese Klasse sortiert nach dem Insertion Sort prinzip. Es nimmt ein Element an der Stelle arr[1] und vergleicht es mit dem
 * vorangehenden Element. Wenn es kleiner ist, wird geswapt.
 *
 * @author Marko Joksimovic
 * @version 1.0
 * @since 24.01.2021
 */

public class insertionSort {

    public insertionSort(){
    }

    public double[] sort(int arr[]){

        double iterationCnt = 0;
        double comparisonCnt = 0;
        double timeCompletion = 0;
        double memoryCnt = 0;

        double[] messwerte = new double[4];

        double timeStart = System.nanoTime();

        int n = arr.length;
        comparisonCnt++;
        for (int i = 1; i < n; ++i) {
            iterationCnt++;
            comparisonCnt++;
            int key = arr[i];
            int j = i - 1;

            comparisonCnt++;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                iterationCnt++;
                comparisonCnt++;
            }
            arr[j + 1] = key;

        }
        double timeEnd =  System.nanoTime();
        timeCompletion = timeEnd - timeStart;

        memoryCnt = Runtime.getRuntime().totalMemory();

        messwerte[0] = iterationCnt;
        messwerte[1] = comparisonCnt;
        messwerte[2] = timeCompletion;
        messwerte[3] = memoryCnt;

        return messwerte;
    }
}
