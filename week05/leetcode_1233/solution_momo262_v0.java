package leetcode_1233;

import java.util.*;

public class solution_momo262_v0 {

    public List<String> removeSubfolders(String[] folder) {
        List<String> resultList = new ArrayList<>();
        Set<String> resultSet = new HashSet<>(Arrays.asList(folder));
        for (String s:folder) {
            int lastIndex = s.lastIndexOf('/');
            String parent = s.substring(0, lastIndex);
            boolean isAdd = true;

            while (!"".equals(parent)) {
                if (resultSet.contains(parent)) {
                    isAdd = false;
                    break;
                } else {
                    parent = parent.substring(0,parent.lastIndexOf('/'));
                }
            }
            if (isAdd) {
                resultList.add(s);
            }
        }
        return resultList;
    }


}
