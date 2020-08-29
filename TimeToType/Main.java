package TimeToType;
/*
Imagine you have a special keyboard with all keys in a single row. 
The layout of characters on a keyboard is denoted by a string keyboard of length 26. 
Initially your finger is at index 0.
To type a character, you have to move your finger to the index of the desired character.
The time taken to move your finger from index i to index j is abs(j - i).

Given a string keyboard that describe the keyboard layout and a string text, 
return an integer denoting the time taken to type string text.
*/

public class Main {
    public static void main(String[] args){
        String keyboard =  "abcdefghijklmnopqrstuvwxy";
        String word = "cba";
        int expected = 4;
        int result = func(keyboard, word);
        System.out.println(result);
        System.out.println(result == expected);
    }    

    static int func(String keyboard, String word) {
        int[] map = new int[26];
        for (int i = 0; i < keyboard.length(); i++){
            char c = keyboard.charAt(i);
            map[c -'a'] = i;
        }
        int time = map[word.charAt(0) - 'a'];
        int lastSeen = time;
        for (int j = 1; j < word.length(); j++ ) {
            time += Math.abs(lastSeen - map[word.charAt(j) - 'a']);
            lastSeen = map[word.charAt(j)-'a'];
        }
        return time;
    }
}