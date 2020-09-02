package CountSubtringsWithExactlyKDistinctChars;
/*
Given a string s and an int k,
return an int representing the number of substrings (not unique) of s with exactly k distinct characters. 
If the given string doesn't have k distinct characters, return 0.
*/

import java.util.HashMap;

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

    static int atMostK(String s, int k) {
        int total = 0, left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (!map.containsKey(c)) map.put(c, 0);
            map.put(c, 1);
            while (map.size() > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                total += right - left + 1;
                left++;
            }
            total += right - left + 1;
            right++;
        }
        return total;
    }

    static int func(String s, int k) {
        return atMostK(s,k) - atMostK(s, k-1);
    }
}