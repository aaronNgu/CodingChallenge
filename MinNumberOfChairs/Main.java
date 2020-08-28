/*
There are n guests who are invited to a party. The k-th guest will attend the party at time S[k] and leave the party at time E[k].
Given an integer array S and an integer array E, both of length n, return an integer denoting the minimum number of chairs you need such that everyone attending the party can sit down.
*/
import java.util.*;

public class Main {

    static int func(int[] arrival,int[] exit){
        Arrays.sort(arrival);
        Arrays.sort(exit);

        int curr = 0, max = 0;
        int i = 0, j = 0, len = arrival.length;
        while(i < len && j < len) {
            if(arrival[i] < exit[j]) {
                i++;
                curr++;
                if (curr >= max) {
                    max = curr;
                }
            } else {
                curr--;
                j++;                
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] s1 = {1, 2, 6, 5, 3};
        int[] e1 = {5, 5, 7, 6, 8};
        int expected = 3;
        int result = func(s1, e1);
        System.out.println(result);
        System.out.println(result==expected);

        int[] s2 = {1, 2, 9, 5, 5};
        int[] e2 = {4, 5, 12, 9, 12};
        /*
        1 2 5 5  9 
        4 5 9 12 12 
        */
        expected = 2;
        result = func(s2, e2);
        System.out.println(result);
        System.out.println(result==expected);
    }
}