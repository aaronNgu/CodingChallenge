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

    static int func(int[] arr){
        return 0;
    }
}