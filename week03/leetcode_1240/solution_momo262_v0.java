package leetcode_1240;

public class solution_momo262_v0 {

    private static int[][] results = new int[14][14];

    public int tilingRectangle(int n, int m) {
        if (results[n][m] != 0) {
            return results[n][m];
        }

        if (n < m) {
            return (tilingRectangle(m,n));
        }
        if (n % m == 0) {
            return n/m;
        }
        int result = 1 + tilingRectangle(n-m,m);
        for (int i= m - 1;i>=n/2;i--) {
            int result2 = 1 + solution2(n-i,m,n,m-i,i,i);
            result = Math.min(result,result2);

        }
        results[n][m] = result;
        return result;
    }

    private int solution2(int a,int b,int c,int d,int e,int f) {
        if (b - a == d) {
            return 1 + tilingRectangle(d,c);
        }
        if (a < b) {
            return 1 + solution2(a,b-a,c,d,e,f-a);
        }
        if (a > b) {
            return 1 + solution2(a-b,b,c-b,d,e,f);
        }
        else {
            return 1 + tilingRectangle(d,e);
        }
    }
}
