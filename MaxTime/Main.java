public class Main {
    static String maxtime(String s) {
        char[] time = s.toCharArray();
        if (time[0] == '?') {
            time[0] = (time[1] <= '3' || time[1] == '?') ? '2' : '1'; 
        }

        if (time[1] == '?') {
            time[1] = time[0] == '2' ? '3' : '9';
        }

        time[3] = time[3] == '?' ? '5' : time[3];
        time[4] = time[4] == '?' ? '9' : time[4];
        return new String(time);
    }

    public static void main(String[] args) {
        String[] input = new String[] {"?4:5?", "23:5?", "2?:22", "0?:??", "??:??"};
        String[] expected = new String[] {"14:59", "23:59", "23:22", "09:59", "23:59"};
        String result;
        for(int i = 0; i < input.length; i++) {
           result = maxtime(input[i]); 
           System.out.println("result: " + result);
           System.out.println("expected: " + expected[i]);
           System.out.println(result.equals(expected[i]));
        }
    }
}