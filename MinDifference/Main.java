public class Main {
    public static int mindifff(int[] load) {
        int sum = 0, len, diff, i, j, actualSum;
        for (i = 0; i < load.length; i++) 
           sum += load[i]; 
        
        actualSum = sum;
        sum = sum/2;
        len = load.length;
        int[][] table = new int[len+1][sum+1];
        for (i = 0; i <= len ; i++) {
            StringBuilder sb = new StringBuilder();
            if (i == 0) {
                sb.append(0 + ": ");
            } else {
                sb.append(load[i-1] + ": ");
            }
            for (j = 0; j <= sum; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (j >= load[i-1] && j - load[i-1] >= 0){
                    table[i][j] = Math.max(table[i-1][j], load[i-1] + table[i-1][j-load[i-1]]);
                } else {
                    table[i][j] = table[i-1][j];
                }
                sb.append(table[i][j] + " | ");
            }
            System.out.println(sb.toString());
            System.out.println("\n");
        }
        int serverOne = actualSum -table[len][sum];
        int serverTwo = table[len][sum];
        System.out.println("sum : " + sum);
        System.out.println("actualSum : " + actualSum);
        System.out.println("serverOne : " + serverOne);
        System.out.println("serverTwo : " + serverTwo);
        return Math.abs(serverOne - serverTwo);
    }

    public static int mindiff(int[] load) {
        int sum = 0, h, ld;
        for (int i: load)
            sum += i;
        
        int half = sum/2;        
        int[][] table = new int[load.length+1][half+1];
        for(ld = 0; ld <= load.length; ld++) {
            for(h = 0; h <= half; h++) {
                if (h == 0 || ld ==0) {
                    table[ld][h] = 0;
                } else if (h >= load[ld-1] && h - load[ld-1] >= 0) {
                    table[ld][h] = Math.max(table[ld-1][h], load[ld-1] + table[ld][h - load[ld-1]]);
                } else {
                    table[ld][h] = table[ld-1][h];
                }
            }
        }
        return (sum - table[load.length][half]) - table[load.length][half];
    }

    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 3, 4, 5};
        int expected = 1;
        int result = mindiff(input);
        System.out.println("result: " + result);
        System.out.println("expected: " + expected);
        System.out.println(result == (expected));

        input = new int[] {10,10,9,9,2};
        result = mindiff(input);
        expected = 0;
        System.out.println("result: " + result);
        System.out.println("expected: " + expected);
        System.out.println(result == (expected));

    }
}