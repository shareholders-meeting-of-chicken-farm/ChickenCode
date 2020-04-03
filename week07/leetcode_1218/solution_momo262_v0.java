package leetcode_1218;

import java.util.*;

public class solution_momo262_v0 {

    public int longestSubsequence(int[] arr, int difference) {
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<arr.length;i++) {
            int currentResult = 1;
            if (map.containsKey(arr[i] - difference)) {
                currentResult = 1 + map.get(arr[i] - difference);
            }
            map.put(arr[i],currentResult);
            result = Math.max(result,currentResult);
        }
        return result;
    }

}
