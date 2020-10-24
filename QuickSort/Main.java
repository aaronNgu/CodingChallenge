package QuickSort;

public class Main {
    private static int partition(int[] unsorted, int low, int high) {
        int pivot = unsorted[high];
        int i = (low - 1);
        for (int j = low; j < high ; j++) {
            if (unsorted[j] < pivot) {
                i++;
                int temp = unsorted[i];
                unsorted[i] = unsorted[j];
                unsorted[j] = temp;
            }
        }
        int temp = unsorted[i+1];
        unsorted[i+1] = pivot;
        unsorted[high] = temp;
        return i+1;
    }
    
    private static void quickSort(int[] unsorted, int low, int high) {
        if (low < high) {
            int pivot = partition(unsorted, low, high);
            quickSort(unsorted, low, pivot-1);
            quickSort(unsorted, pivot+1, high);
        }
    }

    public static int partitionOne(int[] unsorted, int low, int high) {
        // returns position of pivot;
        int pivot = unsorted[high];
        int i = (low-1);
        for(int j = low; j < high ; j++) {
            if (unsorted[j] < pivot) {
                i++;
                int temp = unsorted[i];
                unsorted[i] = unsorted[j];
                unsorted[j] = temp;
            }
        }

        int temp = unsorted[i+1];
        unsorted[i+1] = pivot;
        unsorted[high] = temp;
        return i+1;
    }

    public static void quickSortOne(int[] unsorted, int low, int high) {
        if (low < high) {
            int pivot = partition(unsorted, low, high);
            quickSort(unsorted, pivot+1, high);
            quickSort(unsorted, low, pivot-1);
        }
    }

    public static boolean checkIfSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] unsorted = new int[] {10, 5, 3, 7, 1, 6, 20};
        quickSort(unsorted, 0, unsorted.length - 1);
        System.out.println(checkIfSorted(unsorted));

        unsorted = new int[] {10, 5, 3, 3, 1, 6, 20};
        quickSort(unsorted, 0, unsorted.length - 1);
        System.out.println(checkIfSorted(unsorted));
    }    
}
