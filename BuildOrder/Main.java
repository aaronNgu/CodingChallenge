package BuildOrder;

public class Main {
    
    public static void Main(String[] args) {

        String[] projects = {"a", "b", "c", "d", "e", "f", "g"};
        String[][] dependencies = {{"f", "b"}, {"f", "c"}, 
                                   {"f", "a"}, {"c", "a"}, 
                                   {"b", "a"}, {"a", "e"}, 
                                   {"b", "e"}, {"d", "g"}};
        String[] result = {"f", "d", "c", "b", "g", "a", "e"};
    } 
}