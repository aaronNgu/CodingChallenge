package CountSubtringsWithExactlyKDistinctChars;
/*
Given a string s and an int k,
return an int representing the number of substrings (not unique) of s with exactly k distinct characters. 
If the given string doesn't have k distinct characters, return 0.
*/


public class Main {
    public static void main(String[] args) {
        runTest("pqpqs", 2, 7);
        runTest("aabab", 3, 0);
    }

    public static void runTest(String s, int k, int expected) {
        int result = func(s, k);
        System.out.println(result);
        System.out.println(result == expected);
    }

    static int func(String s, int k) {
        return 0;
    }
}