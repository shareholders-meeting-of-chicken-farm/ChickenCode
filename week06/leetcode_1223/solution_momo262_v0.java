package leetcode_1223;

public class solution_momo262_v0 {

    int[][][] resultMap = new int[5000][6][16];

    int mod = (int) 1e9 + 7;

    public int dieSimulator(int n, int[] rollMax) {
        int result = 0;

        for (int i=1;i<=6;i++) {
            result = (result + dieSimulator(n-1,rollMax,i,1)) % mod;
        }
        return result;
    }

    private int dieSimulator(int n,int[] rollMax,int previousNumber,int numberSize) {

        if (n == 0) {
            return 1;
        }

        if (resultMap[n-1][previousNumber-1][numberSize] != 0) {
            return resultMap[n-1][previousNumber-1][numberSize];
        }

        int result = 0;
        for (int i=1;i<=6;i++) {
            if (previousNumber != i) {
                result = (result + dieSimulator(n-1,rollMax,i,1)) % mod;
            }
            else {
                if (numberSize < rollMax[previousNumber-1]) {
                    result = (result + dieSimulator(n-1,rollMax,previousNumber,numberSize+1)) % mod;
                }
            }
        }
        resultMap[n-1][previousNumber-1][numberSize] = result;
        return result;
     }


}
