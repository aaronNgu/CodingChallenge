package RotateMatrix;
import java.util.*;

public class Main {
   
    public static void main(String[] args) {
        int[][] inputOne = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        /* 
        [1, 2, 3]
        [4, 5, 6]
        [7, 8, 9]

        [7, 4, 1]
        [8, 5, 2]
        [9, 6, 3]
        */
        int[][] expected = new int[][]{{7,4,1},{8,5,2},{9,6,3}};
        runTest(inputOne, expected);

        int[][] inputTwo = new int[][]{{1,2},{3,4}};
        /*
        [1,2]
        [3,4]

        [3,1]
        [4,2]
        */
        expected = new int[][]{{3,1},{4,2}};
        runTest(inputTwo, expected);

        int[][] inputThree = new int[][]{{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        /* 
        [1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5]

        [1, 1, 1, 1, 1]
        [2, 2, 2, 2, 2]
        [3, 3, 3, 3, 3]
        [4, 4, 4, 4, 4]
        [5, 5, 5, 5, 5]
        */
        expected = new int[][]{{1,1,1,1,1},{2,2,2,2,2},{3,3,3,3,3},{4,4,4,4,4},{5,5,5,5,5}};
        runTest(inputThree, expected);
    }

    public static void runTest(int[][] input,int[][] expected) {
        int[][] result = func(input);
        System.out.println("expected:");
        for (int[] i: expected) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("result:");
        for (int[] i: result) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static int[][] func(int[][] input) {
        int len = input.length;
        for (int layer= 0; layer < len/2; layer++) {
            int first = layer;
            int last = len - layer - 1;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int temp = input[first][i];
                input[first][i] = input[last - offset][first];
                input[last - offset][first] = input[last][last - offset];
                input[last][last-offset] = input[i][last];
                input[i][last] = temp;
            }
        }
        return input;
    } 
}
