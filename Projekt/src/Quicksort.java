public class Quicksort {
    public Quicksort(){

    }

    private double[] quicksortMessungen = new double[4];

    public double[] sortQuick(int[] zahlen){
        quickSort(0,zahlen.length - 1,zahlen);

        return quicksortMessungen;
    }

    private void quickSort(int leftIndex, int rightIndex, int[] arr){
        double irerationsCnt = 0;
        double comptCnt = 0;

        //schaut, ob es  bereits sortiert ist
        if (leftIndex >= rightIndex){
            comptCnt++;

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

            while (arr[leftPos] <= pivot && leftPos < rightIndex){
                irerationsCnt++;
                comptCnt++;

                leftPos++;
            }
            while (arr[rightPos] >= pivot && rightPos > leftIndex){
                irerationsCnt++;
                comptCnt++;

                rightPos--;
            }
            if (leftPos < rightPos){
                comptCnt++;

                int tmp = arr[leftPos];

                arr[leftPos] = arr[rightPos];
                arr[rightPos] = tmp;
            }
        }
        while (leftPos < rightPos);

        if (arr[leftPos] > pivot){
            comptCnt++;

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
