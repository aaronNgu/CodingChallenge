package MinDaysToBloom;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        int result = func(new int[]{1, 2, 4, 9, 3, 4, 1} , 2, 2);
        System.out.println(result);
        System.out.println(result == 4);

        result = func(new int[]{1, 5, 6, 2}, 1, 4);
        System.out.println(result);
        System.out.println(result == 6);

        result = func(new int[]{1, 1, 1, 1} , 4, 1);
        System.out.println(result);
        System.out.println(result == 1);

    }
    
    static int funx(int[] roses,int k , int n) {
        int l = 1, r = Arrays.stream(roses).max().getAsInt();
        int days = Integer.MAX_VALUE;
        while(l <= r) {
            int mid = l + ( r - l ) /2, bouquets = 0;
            int i = 0;
            while(i < roses.length) {
                int running = 0;
                while(i < roses.length && roses[i++] <= mid && ++running < k);
                if (running == k ) ++bouquets;
            }
            if (bouquets >= n){
                days = Math.min(days, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            } 
        }
        return days;
    }

    static int func(int[] roses,int k , int n) {
        int l = 1, r = Arrays.stream(roses).max().getAsInt();
        int days = Integer.MAX_VALUE;
        while( l <= r) {
            int bouquets = 0, i = 0;
            int mid = l + (r-l)/2;
            while (i < roses.length) {
                int running = 0;
                while (i < roses.length && roses[i++] <= mid && ++running < k);
                if (running == k) ++bouquets;
            }
            if (bouquets >= n ) {
                r = mid - 1;
                days = Math.min(days, mid);
            } else  {
                l = mid + 1;
            }
        }
        return days;
    }
}