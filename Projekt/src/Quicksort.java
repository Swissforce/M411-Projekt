/**
 * beinhaltet die Methode sortQuick(), die für die Aufbereitung der Parameter, für quickSort(), und Rückgabe der Messwerte verantwortlich ist
 * quickSort() ist rekursiv, deshalb muss man das Messungen-Array ausserhalb der Methode deklarieren
 *
 * @author Martin Düppenbecker
 * @version 1.0
 * @since 20.01.2021
 */

public class Quicksort {
    public Quicksort(){

    }

    private double[] quicksortMessungen = new double[4];

    /**
     * Bereitet die Daten für quickSort vor
     *
     * @param zahlen
     * @return dobule[] quicksortMessungen
     */
    public double[] sortQuick(int[] zahlen){
        quickSort(0,zahlen.length - 1,zahlen);

        return quicksortMessungen;
    }

    /**
     * Sortiert die Zahlen rekursiv, der Output ist in aufsteigender Reihenfolge
     *
     * @param leftIndex
     * @param rightIndex
     * @param arr
     */
    private void quickSort(int leftIndex, int rightIndex, int[] arr){
        double irerationsCnt = 0;
        double comptCnt = 0;

        //schaut, ob es  bereits sortiert ist
        comptCnt++;
        if (leftIndex >= rightIndex){
            return;
        }

        //ACHTUNG es wird zwischen pos/index unterschieden
        int leftPos = leftIndex;
        int rightPos = rightIndex - 1;

        int pivot = arr[rightIndex];

        do {
            //wegen do-while schleife
            irerationsCnt++;
            comptCnt++;

            comptCnt++; //Schleifen machen +1, wenn sie hinein/hinaus gehen (ansichtsweise)
            while (arr[leftPos] <= pivot && leftPos < rightIndex){
                irerationsCnt++;
                comptCnt++;

                leftPos++;
            }
            comptCnt++;
            while (arr[rightPos] >= pivot && rightPos > leftIndex){
                irerationsCnt++;
                comptCnt++;

                rightPos--;
            }
            comptCnt++;
            if (leftPos < rightPos){

                int tmp = arr[leftPos];

                arr[leftPos] = arr[rightPos];
                arr[rightPos] = tmp;
            }
        }
        while (leftPos < rightPos);

        comptCnt++;
        if (arr[leftPos] > pivot){
            int tmp = arr[leftPos];

            arr[leftPos] = arr[rightIndex];
            arr[rightIndex] = tmp;
        }

        quicksortMessungen[0] += irerationsCnt;
        quicksortMessungen[1] += comptCnt;

        quickSort(leftIndex,leftPos - 1, arr);
        quickSort(leftPos + 1,rightIndex, arr);

    }
}
