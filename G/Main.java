public class Main { 
    public static void main(String[] args) {

        Graph graph = new ListGraph();
        graph.add_edges("a", "b");
        graph.add_edges("a", "c");
        graph.add_edges("c", "b");
        graph.add_edges("c", "d");
        graph.add_edges("d", "e");
        graph.add_edges("d", "b");
        graph.print_edges();
        graph.print_vertices();
    }
}