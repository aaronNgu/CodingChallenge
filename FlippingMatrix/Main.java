package FlippingMatrix;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[][] inputOne = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        /* 
        [1, 2, 3]
        [4, 5, 6]
        [7, 8, 9]

        [9, 6, 3]
        [8, 5, 2]
        [7, 4, 1]
        */
        int[][] expected = new int[][]{{9,6,3},{8,5,2},{7,4,1}};
        runTest(inputOne, expected);

        int[][] inputTwo = new int[][]{{1,2},{3,4}};
        /*
        [1,2]
        [3,4]

        [4,2]
        [3,1]
        */
        expected = new int[][]{{4,2},{3,1}};
        runTest(inputTwo, expected);

        int[][] inputThree = new int[][]{{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        /* 
        [1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5]

        [5, 5, 5, 5, 5]
        [4, 4, 4, 4, 4]
        [3, 3, 3, 3, 3]
        [2, 2, 2, 2, 2]
        [1, 1, 1, 1, 1]
        */
        expected = new int[][]{{5,5,5,5,5},{4,4,4,4,4},{3,3,3,3,3},{2,2,2,2,2},{1,1,1,1,1}};
        runTest(inputThree, expected);
    }

    public static void runTest(int[][] input,int[][] expected) {
        int[][] result = func(input);
        System.out.println("result:");
        for (int[] i: expected) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("expected:");
        for (int[] i: result) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static int[][] func(int[][] input) {
        int[][] result = new int[1][1];
        int height = input.length, width = input[0].length;
        for (int row = 0; row < height - 1; row++) {
            for (int col = 0; col < width - 1 - row; col++) {
                int temp = input[row][col];
                input[row][col] = input[height - 1 - col][width - 1 - row];
                input[height -  1 - col][width - 1 - row] = temp;
            }
        }
        return input;
    }
}