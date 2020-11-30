package ThrottlingGateway;

import java.util.*;

public class Main {
    public static int MAX_PER_MINUTE = 60;
    public static int MAX_PER_SECOND = 3;
    public static int MAX_TEN_SECONDS = 20;
    public static void main(String[] args) {
        int[] requestTime1 = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 11, 11, 11, 6, 6, 6, 5, 5, 5};
        int[] requestTime2 = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11};
        int[] requestTime3 = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9,
                10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 14, 14, 14, 16, 16, 16, 16, 16,
                16, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20};
        System.out.println(droppedRequests(requestTime1) +  " 1");
        System.out.println(droppedRequests(requestTime2) +  " 7");
        System.out.println(droppedRequests(requestTime3) +  " 67");
    }

    public static int droppedRequests(int[] requestTime) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int lastTime = 0;
        for (int time: requestTime) {
            map.put(time, map.getOrDefault(time, 0) + 1);
            lastTime = Math.max(time, lastTime);
        }

        int drop = 0;
        int[] runningSum = new int[lastTime+1];
        for (int i = 1; i <= lastTime; i++) {
            int numReqThisSecond = map.getOrDefault(i, 0);
            runningSum[i] = runningSum[i-1] + numReqThisSecond;
            if (numReqThisSecond <= 0) continue;
            
            int toDrop = 0;
            // check per second 
            if (numReqThisSecond > MAX_PER_SECOND) toDrop = Math.max(toDrop, numReqThisSecond - MAX_PER_SECOND);

            // check per ten second
            int timeTenSecondsAgo = Math.max(0, i - 10);
            int numReqPastTenSecond = runningSum[i] - runningSum[timeTenSecondsAgo];
            if (numReqPastTenSecond > MAX_TEN_SECONDS) {
                int numExceeded = Math.min(numReqThisSecond, numReqPastTenSecond - MAX_TEN_SECONDS);
                toDrop = Math.max(numExceeded, toDrop);
            }

            // check per minute
            int timeMinuteAgo = Math.max(0, i - 60);
            int numReqPastMin = runningSum[i] - runningSum[timeMinuteAgo];
            if (numReqPastMin > MAX_PER_MINUTE) {
                int numExceeded = Math.min(numReqThisSecond, numReqPastMin - MAX_PER_MINUTE);
                toDrop = Math.max(numExceeded, toDrop);
            }
            drop += toDrop;
        }

       return drop;
    } 
}
