package FindPairWithGivenSum;
import java.util.*;

public class Main {

    public static void main(String[] args) {
       runTest(new int[]{1, 10, 25, 35, 60}, 90, new int[]{2,3}); 
       runTest(new int[]{20, 50, 40, 25, 30, 10}, 90, new int[]{1,5}); 
       runTest(new int[]{0,0}, 30, new int[]{0,1}); 
       runTest(null, 100, null);
    }

    public static void runTest(int[] input, int target, int[] expected) {
        int[] result = func(input, target);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.equals(result, expected));
    }
    
    static int[] func(int[] input, int target) {
        if (input == null || input.length == 0) return null;  
        int val = target - 30;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            Integer diff = val - input[i];
            Integer other = map.get(input[i]);
            if (other != null) {
                int max = Math.max(other, i);
                if (max > largest) {
                    result[0] = other;
                    result[1] = i;
                    largest = max;
                }
            } else {
                map.put(diff, i);
            }
        }
        return result;
    }
}