package leetcode_1223;

public class solution_momo262_v1 {

    int[][] dp = new int[5001][7];

    int mod = (int) 1e9 + 7;

    public int dieSimulator(int n, int[] rollMax) {

        for (int i=1;i<=6;i++) {
            dp[1][i-1] = 1;
        }
        dp[1][6] = 6;

        for (int i=2;i<=n;i++) {
            int sum = 0;
            for (int j=1;j<=6;j++) {
                dp[i][j-1] = dp[i-1][6];

                if (rollMax[j-1] == i-1) {
                    dp[i][j-1]--;
                }

                else if (rollMax[j-1] < i-1) {
                    int count = dp[i-1-rollMax[j-1]][6] - dp[i-1-rollMax[j-1]][j-1];
                    dp[i][j-1] = ((dp[i][j-1] - count)%mod + mod)%mod;
                }
                sum = (sum + dp[i][j-1])%mod;
            }
            dp[i][6] = sum;
        }
        return dp[n][6];
    }

}
