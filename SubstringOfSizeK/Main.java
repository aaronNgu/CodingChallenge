import java.util.*;

// Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.
public class Main {
    static String[] funx(String s, int k) {
        Set<Character> window = new HashSet<Character>();
        Set<String> result = new HashSet<String>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            // check for duplicate;
            for(; window.contains(s.charAt(end)); start++){
                window.remove(s.charAt(start));
            }

            window.add(s.charAt(end));

            if (window.size() == k) {
                result.add(s.substring(start, end+1));
                window.remove(s.charAt(start));
                start++;
            }
        }
        return result.toArray(new String[result.size()]);
    }

    static String[] funy(String s, int k) {
        Set<Character> window = new HashSet<Character>();
        Set<String> result = new HashSet<String>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            for(; window.contains(s.charAt(end)); start++) {
                window.remove(s.charAt(start));
            }
            window.add(s.charAt(end));
            if (window.size() == k) {
                result.add(s.substring(start, end+1));
                window.remove(s.charAt(start));
                start++;
            }
        }
        return result.toArray(new String[result.size()]);
    }

    static String[] func(String s, int k) {
        Set<Character> window = new HashSet<Character>();
        Set<String> result = new HashSet<String>();
        for (int start = 0, end = 0; end < s.length(); end++){
            for(; window.contains(s.charAt(end)); start++){
                window.remove(s.charAt(start));
            }
            window.add(s.charAt(end));
            if (window.size() == k) {
                result.add(s.substring(start, end+1));
                window.remove(s.charAt(start));
                start++;
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        String[] inputString = new String[] {"abcabc", "abacab", "awaglknagawunagwkwagl"}; 
        int[] inputSize = new int[] {3, 3, 4};  
        ArrayList<String[]> expected = new ArrayList<String[]>();
        expected.add(new String[]{"abc", "bca", "cab"});
        expected.add(new String[]{"bac", "cab"});
        expected.add(new String[]{"wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"});

        String[] result;
        for (int i = 0; i < inputString.length; i++) {
            result = func(inputString[i], inputSize[i]);

            // Arrays.sort sorts in place does not return anything
            Arrays.sort(result);
            Arrays.sort(expected.get(i));
            System.out.println(Arrays.toString(result));
            System.out.println(Arrays.toString(expected.get(i)));
            System.out.println(Arrays.equals(result, expected.get(i)));
        }
    }
}