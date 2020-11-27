package MinCostToConnectAllNodes;
// basically same question as Min Cost To Repair Edges

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    
    public static void main(String[] args) {
        // n = 6, edges = [[1, 4], [4, 5], [2, 3]], newEdges = [[1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5]]
        runTest(6, new int[][]{{1, 4}, {4, 5}, {2, 3}}, new int[][]{{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}}, 7);
    }   

    public static void runTest(int n, int[][] edges, int[][] newEdges, int expected) {
        int result = func(n, edges, newEdges);
        System.out.println(result);
        System.out.println(result == expected);
    }

    static int func(int n, int[][] edges, int[][] newEdges) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        for (int[] edge: edges) q.add(new int[]{edge[0], edge[1], 0});
        for (int[] newEdge: newEdges) q.add(newEdge);
        int sum = 0;
        int[] parents = new int[n+1];
        Arrays.fill(parents, -1);
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0], v = curr[1], w = curr[2];
            int up = find(u, parents), vp = find(v, parents);
            if (up != vp) {
                sum += w;
                union(u, v, parents);
            }
        }
        return sum;
    }

    static int find(int node,int[] parents) {
        if (parents[node] < 0) return node;
        int p = find(parents[node], parents);
        parents[node] = p;
        return p;
    }

    static void union(int u, int v, int[] parents) {
        int up = find(u, parents);
        int vp = find(v, parents);
        parents[up] = vp;
    }
    /*
    static int func(int n, int[][] edges, int[][] newEdges) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int[] edge: edges) {
            q.add(new int[]{edge[0], edge[1], 0});
        }

        for (int[] newEdge: newEdges) {
            q.add(newEdge);
        }

        int sum = 0;
        int[] parents = new int[n+1];
        Arrays.fill(parents, -1);
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0], v = curr[1], w = curr[2];
            int up = find(u, parents), vp = find(v, parents);
            if (up != vp) {
                sum += w;
                union(parents, u, v);
            }
        }
        return sum;
    }

    static int find(int node, int[] parents) {
        if (parents[node] < 0) return node;
        int p = find(parents[node], parents);
        parents[node] = p;
        return p;
    }

    static void union(int[] parents, int u, int v) {
        int up = find(u, parents);
        int vp = find(v, parents);
        parents[vp] = up;
    }

    static int func(int n, int[][] edges, int[][] newEdges) {
        //Set<String> hset = new HashSet<String>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        for (int[] e : newEdges) {
            //String s = e[0] + " " +  e[1];
            //hset.add(s);
            pq.add(e);
        }
        for (int[] e : edges) {
            // String s = e[0] + " " + e[1];
            //if (hset.contains(s)) continue;
            int[] l = new int[]{e[0], e[1], 0};
            pq.add(l);
        }

        int[] par = new int[n+1];
        Arrays.fill(par, -1);
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int u = t[0], v = t[1], w = t[2];
            int up = find(u, par), vp = find(v, par);
            if (vp != up) {
                sum += w;
                union(up, vp, par);
            }
        }
        return sum;
    }

    static int find(int node, int[] par) {
        if (par[node] < 0) return node;
        int p = find(par[node], par);
        par[node] = p;
        return p;
    }

    static void union(int u, int v, int[] par) {
        int up = find(u, par);
        int vp = find(v, par);
        par[vp] = up;
    }
    */
}
