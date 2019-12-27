package leetcode_1232;

public class solution_momo262_v0 {

    public boolean checkStraightLine(int[][] coordinates) {
        double gradient = (double)(coordinates[1][1] - coordinates[0][1]) /
                (double)(coordinates[1][0] - coordinates[0][0]);
        int[] current = coordinates[1];

        for (int i=2;i<coordinates.length;i++) {
            double currentGradient = (double)(coordinates[i][1] - current[1]) /
                    (double)(coordinates[i][0] - current[0]);
            if (currentGradient != gradient) {
                return false;
            }
            current = coordinates[i];
        }
        return true;
    }

}
