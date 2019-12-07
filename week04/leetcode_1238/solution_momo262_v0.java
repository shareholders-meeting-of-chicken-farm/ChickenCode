package leetcode_1238;

import java.util.ArrayList;
import java.util.List;

public class solution_momo262_v0 {

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> resultList = new ArrayList<>();
        List<Integer> remainList = new ArrayList<>();
        boolean canBeAdd = false;
        List<String> codeList = new ArrayList<>();
        codeList.add("0");
        codeList.add("1");

        for (int i=1;i<n;i++) {
            List<String> newCodeList = new ArrayList<>();
            for (String code:codeList) {
                newCodeList.add("0" + code);
            }
            for (int j=codeList.size() - 1;j>=0;j--) {
                newCodeList.add("1" + codeList.get(j));
            }
            codeList = newCodeList;
        }

        for (String code:codeList) {
            int currentInt = Integer.parseInt(code, 2);
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
