package leetcode_1218;

public class solution_momo262_v1 {

    public int longestSubsequence(int[] arr, int difference) {
        int result = 0;
        int[] dp = new int[5*10000 + 1];

        for (int i=0;i<arr.length;i++) {
            dp[arr[i] + 20000] = 1 + dp[arr[i] - difference + 20000];
            result = Math.max(result,dp[arr[i] + 20000]);
        }
        return result;
    }

}
