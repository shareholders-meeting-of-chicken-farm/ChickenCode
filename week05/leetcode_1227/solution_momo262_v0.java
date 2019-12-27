package leetcode_1227;

public class solution_momo262_v0 {

    private double[] results = new double[100000];

    public double nthPersonGetsNthSeat(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 0.5;
        }
        if (results[n] != 0) {
            return results[n];
        }

        double currentResult = (double)1/n;
        for (int i=n-1;i>1;i--) {
            currentResult = currentResult + ((double)1/n) * (nthPersonGetsNthSeat(i));
        }
        results[n] = currentResult;
        return currentResult;
    }

}
