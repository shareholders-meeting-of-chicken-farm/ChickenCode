package leetcode_1237;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution_momo262_v0 {

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> solutionList = new ArrayList<>();
        int x = 1, y = z;
        while(x <= z && y > 0) {
            if(customfunction.f(x, y) == z) {
                solutionList.add(Arrays.asList(x, y));
                x++;
                y--;
            } else if(customfunction.f(x, y) > z) {
                y--;
            } else {
                x++;
            }
        }
        return solutionList;
    }

    private class CustomFunction {
        public int f(int x, int y) {
            return x + y;
        }
    }
}
