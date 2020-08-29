package G;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListGraph implements Graph{

    ArrayList<String> vertices;
    HashMap<String, Tode> edges;

    public ListGraph() {
        vertices = new ArrayList<String>();
        edges = new HashMap<String, Tode>();
    }

    @Override
    public void add_vertex(String node) {
        vertices.add(node);
        Tode vertex = new Tode(node);
        edges.put(node, vertex);
    }

    @Override
    public void add_edges(String src, String dst) {
        if (!vertices.contains(src)) {
            add_vertex(src);
        }

        if (!vertices.contains(dst)) {
            add_vertex(dst);
        }

        Tode source_node = edges.get(src);
        source_node.nodes.add(dst);
    }

    @Override
    public void print_edges() {
        for( Map.Entry<String, Tode> tode: edges.entrySet()) {
            System.out.println("edges for vertex " + tode.getKey() + ":");
            StringBuilder result = new StringBuilder();
            tode.getValue().nodes.forEach((next) -> {
                result.append(next);
                result.append(" ");
            });
            System.out.println(result);
        } 
    }

    @Override
    public void print_vertices() {
        System.out.println("The vertices are : ");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.println(vertices.get(i));
        }
    }


}