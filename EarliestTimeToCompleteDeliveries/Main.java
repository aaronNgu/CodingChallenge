package EarliestTimeToCompleteDeliveries;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(func(2 , new int[]{8,10}, new int[]{2,2,3,1,8,7,4,5}) + "  16");
    }

    private static int func(int numBuildings, int[] openingTime, int[] offLoadTime) {
        Arrays.sort(openingTime);
        Arrays.sort(offLoadTime);

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < numBuildings; i++) {
            int offLoadTimeIndex = numBuildings * 4  - i * 4 - 1;
            res = Math.max(res, openingTime[i] + offLoadTime[offLoadTimeIndex]);
        }
        return res;
    }
    
}
