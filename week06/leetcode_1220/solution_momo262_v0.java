package leetcode_1220;

public class solution_momo262_v0 {

    int[][] dp = new int[2*10000+1][5];

    int mod = (int) 1e9 + 7;

    public int countVowelPermutation(int n) {
        int result = 0;
        for (int i=1;i<=5;i++) {
            dp[1][i-1] = 1;
        }
        for (int i=2;i<=n;i++) {
            dp[i][0] = ((dp[i-1][1] + dp[i-1][2])%mod + dp[i-1][4])%mod;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2])%mod;
            dp[i][2] = (dp[i-1][1] + dp[i-1][3])%mod;
            dp[i][3] = dp[i-1][2];
            dp[i][4] = (dp[i-1][2] + dp[i-1][3])%mod;
        }
        for (int sum:dp[n]) {
            result = (result + sum)%mod;
        }
        return result;
    }

}
