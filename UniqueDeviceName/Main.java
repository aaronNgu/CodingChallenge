package UniqueDeviceName;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        int num = 6;
        List<String> deviceNames = new ArrayList<String>(Arrays.asList("switch", "tv", "switch", "tv","switch", "tv"));
        List<String> result = func(num, deviceNames);
        for (String s: result) System.out.print(s + " ");
        System.out.println(" ");
    }
    
    private static List<String> func(int num, List<String> deviceNames) {
        List<String> result = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s: deviceNames) {
            if (map.containsKey(s)) {
                result.add(s + map.get(s));
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
                result.add(s);
            }
        }
        return result;
    }
}
