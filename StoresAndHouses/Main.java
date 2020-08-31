package StoresAndHouses;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        runTest(new int[]{5,10,17}, new int[]{1,5,20,11,16}, new int[]{5,11,16});
        runTest(new int[]{2, 4, 2}, new int[]{5, 1, 2, 3}, new int[]{2,3,2});
        runTest(new int[]{4,8,1,1}, new int[]{5,3,1,2,6}, new int[]{3,6,1,1});
    }

    static void runTest(int[] houses, int[] stores, int[] expected) {
        int[] result = func(houses, stores);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.equals(result, expected));
    } 
    
    static int[] func(int[] houses, int[] stores) {
        int[] result = new int[houses.length];
        Arrays.sort(stores);
        for (int i = 0; i < houses.length; i++) {
            int house = houses[i];
            int ind = Arrays.binarySearch(stores, house);
            ind = ind  < 0 ? - ( ind + 1) : ind;
            if (ind >= stores.length ){
                result[i] = stores[ind -1];
            } else {
                if (stores[ind] == house) {
                    result[i] = stores[ind];
                } else {
                    int left = house - stores[ind -1];
                    int right = stores[ind] - house;
                    result[i] = left == right ? Math.min(stores[ind-1], stores[ind]) : 
                    (left < right ? stores[ind-1] : stores[ind]);
                }
            }
        }
        return result;
    }
}