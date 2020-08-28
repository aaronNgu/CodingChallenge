package DecresingSubsequence;
/*
Given an int array nums of length n. Split it into strictly decreasing subsequences. 
Output the min number of subsequences you can get by splitting.
*/

public class Main {
    public static void main(String[] args){
        int[] inputOne = {5, 2, 4, 3, 1, 6};
        int expected = 3;
        int result = func(inputOne);
        System.out.println(result);
        System.out.println(result == expected);

        int[] inputTwo = {2, 9, 12, 13, 4, 7, 6, 5, 10};
        expected = 4;
        result = func(inputTwo);
        System.out.println(result);
        System.out.println(result == expected);

        int[] inputThree = {1, 1, 1};
        expected = 3;
        result = func(inputThree);
        System.out.println(result);
        System.out.println(result == expected);
    }

    static int func(int[] nums){
        int[] dp = new int[nums.length];
        int result = 0;
        for (int n : nums) {
            int i = binarySearch(dp, 0, result, n);
            if (i < 0) 
                i = - (i + 1);
            dp[i] = n;
            if (result == i)
                result++;
        }
        return result;
    }

    // returns index of the smallest value that is greater than target
    static int binarySearch(int[] array, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) >> 1;
            if (array[mid] <= target) {
                // go right - start is inclusive
                start = mid + 1;
            } else {
                // end is exclusive
                end = mid; 
            } 
        }
        return start;
    }
}