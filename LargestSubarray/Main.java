import java.util.Arrays;

public class Main {

    static int[] func(int[] array, int k) {
        int first_idx = 0;
        for (int i = 1; i < array.length - k + 1; i++){
            if (array[first_idx] < array[i]) {
                first_idx = i;
            }
        }
        return Arrays.copyOfRange(array, first_idx, first_idx + k);
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 4, 3, 2, 5};
        int k = 4;
        int[] result = func(inputArray, k);
        int[] expected = new int[]{4, 3, 2, 5};
        System.out.println(Arrays.equals(expected, result));
    }
}