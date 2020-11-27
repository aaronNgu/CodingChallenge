package MinCostToRepairEdges;

// Kruskal always select the min cost unless it form a cycle 
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        runTest(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}, new int[][]{{1, 2, 12}, {3, 4, 30}, {1, 5, 8}}, 20);
        runTest(6, new int[][]{{1, 2}, {2, 3}, {4, 5}, {3, 5},{1, 6}, {2, 4}}, new int[][]{{1, 6, 410}, {2, 4, 800}}, 410);
        runTest(6, new int[][]{{1, 2}, {2, 3}, {4, 5}, {5, 6}, {1, 5},{2, 4},{3, 4}}, new int[][]{{1, 5, 110}, {2, 4, 84}, {3, 4, 79}}, 79);
        runTest(6, new int[][]{}, new int[][]{{1, 4, 100},{2, 4, 10},{2, 3, 7},{2, 5, 15},{2, 1, 17},{5, 3, 1}}, 35);
    }   

    static void runTest(int nodes, int[][] edges, int[][] edgesToRepair, int expected){
        int result = func(nodes, edges, edgesToRepair);
        System.out.println(result);
        System.out.println(result == expected);
    }

    public static int func(int n, int[][] edges, int[][] edgesToRepair) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b) -> a[2] - b[2]);
        Set<String> set = new HashSet<String>();
        for (int[] e: edgesToRepair) {
            set.add(e[0] + " " + e[1]);
            q.add(e);
        }
        for (int[] e: edges) {
            if (set.contains(e[0] + " " + e[1])) continue;
            q.add(new int[]{e[0], e[1], 0});
        }
        int sum = 0;
        int[] p = new int[n+1];
        Arrays.fill(p, -1);
        while (!q.isEmpty()) {
            int[] c = q.poll();
            int u = c[0], v = c[1], w = c[2];
            int up = find(u, p), vp = find(v, p);
            if (up != vp) {
                sum += w;
                union(u, v, p);
            }
        }
        return sum;
    }
    
    private static int find(int node,int[] parent) {
        if (parent[node] < 0) return node;
        int p = find(parent[node], parent);
        parent[node] = p;
        return p;
    }
    
    private static void union(int u, int v, int[] parent) {
        int up = find(u, parent);
        int vp = find(v, parent);
        parent[vp] = up;
    }
    /*
    static int func(int n, int[][] edges, int[][] edgesToRepair) {
        Set<String> hset = new HashSet<String>();

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        for(int[] e: edgesToRepair) {
            String s = e[0] + " " + e[1];
            hset.add(s);
            pq.add(e);
        }

        for(int[] e : edges) {
            String s = e[0] + " " + e[1];
            if (hset.contains(s)) continue;
            int[] t = new int[] {e[0], e[1], 0};
            hset.add(s);
            pq.add(t);
        }

        int[] parent = new int[n+1];
        Arrays.fill(parent, -1);
        int sum = 0;
        while(!pq.isEmpty()) {
            // keep processing
            int[] current = pq.poll();
            int u = current[0], v = current[1], w = current[2];
            int up = find(u,parent), vp = find(v, parent); 
            if (up != vp) {
                // no cycle
                union(vp, up, parent);
                sum += w;
            }
        }
        return sum;
    }

    static int find(int node , int[] parent) {
        if (parent[node] < 0) return node;
        int p = find(parent[node], parent);
        // path compression
        parent[node] = p;
        return p;
    }

    static void union(int v, int u, int[] parent) {
        int up = find(u, parent);
        int vp = find(v, parent); 
        parent[up] = vp;
    } 
    */
}
