import java.util.Arrays;

public class Main {
    // sample solution 
    static int[] funx(String A, String B) {
        String[] strsA = A.split(","), strsB = B.split(",");
        int lenA = strsA.length, lenB = strsB.length;
        int[] res = new int[lenB];
        int[] freqs = new int[11];
        
        for (String s: strsA) {
            // count frequency of minimum character for string 
            if (s.length() == 0) continue;
            int[] counts = new int[26];
            int minIdx = 26;
            for (char c : s.toCharArray()) {
                // increment count for freq
                ++counts[c - 'a'];
                // track minimum index
                minIdx = Math.min(minIdx, c - 'a');
            }
            int freq = counts[minIdx];
            freqs[freq]++;
        }
        
        for (int i = 1; i < 11; i++){
            freqs[i] += freqs[i-1];
        }

        for (int i = 0; i < lenB; i++) {
            String s = strsB[i];
            int[] counts = new int[26];
            int minIdx = 26;
            for (char c : s.toCharArray()) {
                ++counts[c - 'a'];
                minIdx = Math.min(minIdx, c - 'a');
            }
            int freq = counts[minIdx];
            res[i] =(freq - 1 >= 0) ? freqs[freq - 1] : 0;
        }

        return res;
    }

    // My solution
    static int[] funy(String A, String B) {
        String[] strA = A.split(","), strB = B.split(",");
        int lenA = strA.length, lenB = strB.length;
        int[] res = new int[lenB];
        int[] freqs = new int[11];

        for(String s: strA) {
            if (s.length() == 0) continue;
            int minIdx = 26;
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                ++count[c - 'a'];
                minIdx = Math.min(minIdx, c - 'a');
            }
            freqs[count[minIdx]]++;
        }
        for(int i = 1; i < freqs.length; i++)
            freqs[i] += freqs[i-1];

        for(int i = 0; i < lenB; i++) {
            int minIdx = 26;
            int[] count = new int[26];
            for(char c: strB[i].toCharArray()) {
                ++count[c-'a'];
                minIdx = Math.min(minIdx, c - 'a');
            }
            int freq = count[minIdx];
            res[i] = (freq - 1 >= 0) ? freqs[freq - 1]: 0;
        }
        return res;
    }

    static int[] func(String a, String b) {
        String[] strsA = a.split(","), strsB = b.split(",");
        int lenA = strsA.length, lenB = strsB.length;
        int[] res = new int[lenB];
        int[] freqs = new int[11];
    
        for (String s : strsA) {
            int[] count = new int[26];
            int minIdx = 26;
            for (char c : s.toCharArray()) {
                ++count[c - 'a'];
                minIdx = Math.min(minIdx, c - 'a');
            }
            int freq = count[minIdx];
            freqs[freq]++;
        }

        for (int i = 1 ; i < 11; i++)
            freqs[i] += freqs[i-1];

        for (int i = 0; i < lenB; i++ ){
            int[] count = new int[26];
            int minIdx = 26;
            String s = strsB[i];
            for (char c : s.toCharArray()) {
                ++count[c - 'a'];
                minIdx = Math.min(minIdx, c - 'a');
            }
            int freq = count[minIdx];
            res[i] = (freqs[freq] - 1 > 0) ? freqs[freq - 1] : 0;
        }

        return res;
    }

    public static void main(String[] args) {
        String a = "abcd,aabc,bd";
        String b = "aaa,aa";
        int[] expected = new int[]{3,2};
        int[] result = func(a, b);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.equals(expected, result));
    }
}