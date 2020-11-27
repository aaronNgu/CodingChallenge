package Knapsack;

public class Main {

    static int dp2(int[] weights, int[] value, int cap) {
        int[][] table = new int[weights.length + 1][cap + 1];
        for (int i = 0; i <= weights.length; i++) {
            for (int w = 0; w <= cap; w++) {
                if (i == 0 || w == 0) {
                    table[i][w] = 0;
                } else if (weights[i-1] <= w) {
                    table[i][w] = Math.max(table[i-1][w], value[i-1] + table[i-1][w-weights[i-1]]);
                } else {
                    table[i][w] = table[i-1][w];
                }
            }
        }
        return table[weights.length][cap];
    }

    static int dp(int[] weights, int[] value, int cap) {
        int i, w;
        int[][] table = new int[value.length+1][cap+1];

        for (i = 0; i <= value.length; i++) {
            for(w = 0; w <= cap; w++ ) {
                if (i == 0 || w == 0) {
                    table[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    table[i][w] = Math.max(table[i-1][w], 
                                value[i-1] + table[i-1][w-weights[i-1]]);
                } else {
                    table[i][w] = table[i-1][w];
                }
            }
        }
        return table[value.length][cap];
    }

    static int recursive2(int[] weight, int[] value, int cap) {
        return rhelper2(weight, value, cap, value.length - 1);
    }

    static int rhelper2(int[] weight, int[] value, int cap, int index) {
        if (index <= 0 || cap <= 0) return 0;
        if (weight[index] > cap) return rhelper2(weight, value, cap, index+1);
        return Math.max(rhelper2(weight, value, cap, index-1), value[index] + rhelper2(weight, value, cap - weight[index], index-1));
    }

    static int recursive(int[] weights, int[] value, int cap) {
        return rhelper(weights, value, cap, value.length);
    }

    static int rhelper(int[] weights, int[] value, int cap, int index) {
        if (index == 0 || cap <= 0) return 0;
        if (weights[index - 1] > cap) return rhelper(weights, value, cap, index-1);
        return Math.max(rhelper(weights, value, cap, index-1), 
                        value[index-1] + rhelper(weights, value, cap-weights[index-1], index-1));
    }

    public static void main(String[] args) {
        int[] weights = new int[] {10, 20,30};

        int[] value = new int[] {60, 100, 120};

        int capacities=50;

        int expected = 220;
        // int result = recursive2(weights, value, capacities);
        int result = dp2(weights, value, capacities);
        System.out.println("result: " + result);
        System.out.println("expected: " + expected);
        System.out.println(result == expected);
    }
}