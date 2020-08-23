public class Main {
    public static String mostbooked(String[] floors) {
        int[] map = new int[260];
        int max = 0;
        String currentMax = floors[0];

        for (int i = 0; i < floors.length; i++) {
            String currentRoom = floors[i];
            if(currentRoom.charAt(0) == '-') continue;
            int idx = (1 + currentRoom.charAt(1) - '0') * (1 + currentRoom.charAt(2) - 'A') + 1;
            map[idx]++;
            if (map[idx] > max) {
                max = map[idx];
                currentMax = currentRoom;
            } else if (max == map[idx]){
                currentMax = currentMax.compareTo(currentRoom) < 0 ? currentMax : currentRoom;
            }
        }

        return currentMax.substring(1);
    }

    public static void main(String[] args) {
        String[] input = new String[] {"+1A", "+3E", "-1A", "+4F", "+1A", "-3E"};
        String expected = "1A";
        String result = mostbooked(input);
        System.out.println("result: " + result);
        System.out.println("expected: " + expected);
        System.out.println(result.equals(expected));
    }
}