package LabelingSystem;

public class Main {
    public static void main(String[] args) {
        // System.out.println(Character.toString('a' + 1));
        //System.out.println("ddcddcdccbcbbabbaa".compareTo("ddcddcdccbcbbabaabaa"));
        System.out.println(func("baccc", 2) + " ccbca");
        System.out.println(func("aaaaabbbbbcccccddddd", 2) + " ddcddcdccbcbbabbaa"); 
        System.out.println(func("daabaabc", 2) + " dcbaabaa");
        System.out.println(func("abbbbbbbc", 2) + " cbbabb");
    } 

    public static String func(String s, int limit) {
        /* Fill up with char with the most count, then fill up char with largest*/
        int[] map = new int[26];
        for (char c: s.toCharArray()) map[c-'a']++;

        StringBuilder sb = new StringBuilder();
        int prevChar = 26, count = 0;
        for (int i = 25; i >= 0; i--) {
            while (map[i] > 0) {
                if (prevChar == i) {
                    if (count >= limit) {
                        int nextChar = i - 1;
                        while (nextChar >= 0 && map[nextChar] <= 0) nextChar--;
                        if (nextChar >=  0) {
                            sb.append(Character.toString('a' + nextChar));
                            map[nextChar]--;
                            prevChar = nextChar;
                            count = 1;
                        } else  {
                            map[i]--;
                        }
                    } else {
                        count++;
                        sb.append(Character.toString('a' + i));
                        map[i]--;
                        prevChar = i; 
                    }

                } else {
                    count = 1;
                    sb.append(Character.toString('a' + i));
                    map[i]--;
                    prevChar = i;
                }
            }
        }
        return sb.toString();
    }
}
