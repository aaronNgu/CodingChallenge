package MaxDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
The distance between 2 binary strings is the sum of their lengths after removing the common prefix.
For example: the common prefix of 1011000 and 1011110 is 1011 so the distance is len("000") + len("110") = 3 + 3 = 6.

Given a list of binary strings, pick a pair that gives you maximum distance among all possible pair and return that distance.
*/
class BinaryTrieNode {
    BinaryTrieNode left;
    BinaryTrieNode right;
    private char ch;
    
    public BinaryTrieNode(char c) {
       ch = c;
    }

    public void set(char ch, BinaryTrieNode node) {
        if (ch == '0') {
            left = node;
        } else if (ch == '1') {
            right = node;
        }
    }

    public BinaryTrieNode get(char ch) {
        if (ch == '0') {
            return left;
        } else if (ch == '1') {
            return right;
        }
        return null;
    }
}

class BinaryTrie{
    private BinaryTrieNode root;
    private int maxDiff;

    public BinaryTrie(List<String> input){
        root = new BinaryTrieNode('\0');
        maxDiff = 0;
        for (String s : input) {
            BinaryTrieNode curr = root;
            for (char c : s.toCharArray()) {
                BinaryTrieNode child = curr.get(c);
                if (child == null) {
                    child = new BinaryTrieNode(c);
                    curr.set(c, child);
                }
                curr = child;
            }
        }
    }

    public int getMaxDiff() {
        getMaxDiff(root);
        return maxDiff;
    }

    public int getMaxDiff(BinaryTrieNode node) {
        if (node == null) return 0;
        int left = getMaxDiff(node.left);
        int right = getMaxDiff(node.right);

        if (left > 0 && right > 0)
            maxDiff = Math.max(maxDiff, left+right);

        return 1 + Math.max(left, right);   
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> binaries = new ArrayList<String>(Arrays.asList("1011100", "1011011","1001111"));

		BinaryTrie trie = new BinaryTrie(binaries);
        
		System.out.println(trie.getMaxDiff() == 10); // gives 10 (1011100, 1001111) differ by 10.
        
        binaries = new ArrayList<String>(Arrays.asList("101", "111","000"));
        
        trie = new BinaryTrie(binaries);
        
		System.out.println(trie.getMaxDiff() == 6); // return 6 (101, 000)
    }

    
}