package leetcode_1217;

public class solution_momo262_v0 {

    public int minCostToMoveChips(int[] chips) {
        int oddNumber = 0;
        int evenNumber = 0;

        for (int chip:chips) {
            if (chip%2 == 0) {
                evenNumber++;
            } else {
                oddNumber++;
            }
        }
        return Math.min(evenNumber,oddNumber);
    }

}
