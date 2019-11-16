package leetcode_1253;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
   we only have choice when current colsum = 1,put number 1 into line that has more remain numbers
   check if valid at last
 */
public class Solution_momo262_v0 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int[] line1 = new int[colsum.length];
        int[] line2 = new int[colsum.length];

        for (int i=0;i<colsum.length;i++) {
            if (colsum[i] == 2) {
                line1[i] = 1;
                line2[i] = 1;
                upper--;
                lower--;
            }
            if (colsum[i] == 1) {
                if (upper > lower) {
                    line1[i] = 1;
                    upper--;
                } else {
                    line2[i] = 1;
                    lower--;
                }
            }
        }
        if (upper != 0 || lower != 0) {
            return new ArrayList<>();
        }
        return new ArrayList(Arrays.asList(line1,line2));
    }

}
