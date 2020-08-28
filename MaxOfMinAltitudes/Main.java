package MaxOfMinAltitudes;

public class Main {
    static int func(int[][] input) {
        int width = input[0].length, height = input.length, above, left, result;
        result = 0;
        System.out.println("width : " + width);
        System.out.println("height : " + height);
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if ((i == 0 && j == 0)|| (i == 1 && j == 0) || (i == 0 && j == 1)) {
                    // first spot
                    continue;
                } else if (i == height - 1 && j == width - 1 ){
                    // last spot
                    above = input[i-1][j];
                    left = input[i][j-1];
                    result = Math.max(above, left);
                } else {
                    // min from above
                    above = i-1 <= 0 ? Integer.MIN_VALUE : Math.min(input[i][j], input[i-1][j]);
                    // min from left
                    left = j-1 < 0 ? Integer.MIN_VALUE : Math.min(input[i][j], input[i][j-1]);
                    input[i][j] = Math.max(above, left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] inputOne = new int[][] {{5, 1},{4, 5}};
        int outputOne = 4;
        int result = func(inputOne);
        System.out.println(result);
        System.out.println(result == outputOne);

        int[][] inputTwo = new int[][]{{1, 2, 3},{4, 5, 1}};
        int outputTwo = 4;
        result = func(inputTwo);
        System.out.println(result);
        System.out.println(result == outputTwo);

        int[][] inputThree = new int[][]{{20, 20, 3}, {20, 3, 20}, {3, 20, 20}};
        int outputThree = 3;
        result = func(inputThree);
        System.out.println(result );
        System.out.println(result == outputThree);
        
    }
}