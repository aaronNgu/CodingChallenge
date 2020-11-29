package FindCriticalNodes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static int time = 1;
    public static void main(String[] args) {
        int nodeNum = 7;
        int[][] graph = new int[][]{{0,1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3,4}};
        List<Integer> result = func(graph, nodeNum);
        for (Integer n : result) System.out.println(n);
        System.out.println(result.toArray().toString().equals(new int[]{5,2,3}.toString()));
    }

    public static List<Integer> func(int[][] graph, int nodeNum) {
        List<List<Integer>> g = new ArrayList<List<Integer>>();
        for (int i = 0; i < nodeNum; i++) g.add(new ArrayList<Integer>());
        for (int[] conn: graph) {
            g.get(conn[0]).add(conn[1]);
            g.get(conn[1]).add(conn[0]);
        }
        //for (Integer n : g.get(6)) System.out.println(n);

        List<Integer> result = new ArrayList<Integer>();
        int[] visitedAt = new int[nodeNum];
        dfs(g, visitedAt, 0, -1, result);
        return result;
        // return new ArrayList<Integer>(Arrays.asList(1,2,3,4));
    }

    private static int dfs(List<List<Integer>> graph, int[] visitedAt, int i, int parent, List<Integer> result) {
        if (visitedAt[i] != 0) return visitedAt[i];
        visitedAt[i] = time++;
        int min = Integer.MAX_VALUE;
        for (Integer n: graph.get(i)) {
            if (n == parent) continue;
            int minOfNeighbours = dfs(graph, visitedAt, n, i, result);
            min = Math.min(minOfNeighbours, min);
        }

        if (visitedAt[i] <= min && parent >= 0) {
            if (!result.contains(parent) && graph.get(parent).size() > 1) result.add(parent);
            if (!result.contains(i) && graph.get(i).size() > 1) result.add(i);
        }
        return Math.min(visitedAt[i], min);
    }
}