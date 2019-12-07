package leetcode_1238;

import java.util.ArrayList;
import java.util.List;

public class solution_momo262_v1 {

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> resultList = new ArrayList<>();
        List<Integer> remainList = new ArrayList<>();
        List<Integer> codeList = new ArrayList<>();
        boolean canBeAdd = false;

        codeList.add(0);
        codeList.add(1);

        for (int i=0;i<n-1;i++) {
            for (int j=codeList.size();j>0;j--) {
                codeList.add(codeList.get(j-1) + (1 << (i+1)));
            }
        }

        for (int currentInt:codeList) {
            if (!canBeAdd) {
                if (start != currentInt) {
                    remainList.add(currentInt);
                } else {
                    canBeAdd = true;
                    resultList.add(currentInt);
                }
            }
            else {
                resultList.add(currentInt);
            }
        }
        resultList.addAll(remainList);
        return resultList;
    }

}
