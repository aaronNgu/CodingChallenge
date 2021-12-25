package MinAmp;
import java.util.*;

class Solution {

}

public class Main {
    public static void main(String[] args) {
        int[] input1 = new int[]{-1,3,-1,8,5,4};
        System.out.println(solution(input1) + " " + 2);
        int[] input2 = new int[]{10,10,3,4,10};
        System.out.println(solution(input2) + " " + 0);
    }

    static int solution(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n <= 3) return 0;
        int ans = nums[n-1]- nums[0];
        for (int i = 0, j = n - 4; j < n; i++, j++) {
            ans = Math.min(ans, nums[j] - nums[i]);
        }
        return ans;
    }
}
