package leetcode_1239;

import java.util.List;

public class solution_momo262_vo {

    public int maxLength(List<String> arr) {
        int[] currentLetters = new int[26];
        return maxLength(arr,0,currentLetters);
    }

    public int maxLength(List<String> arr,int start,int[] currentLetters) {

        if (start == arr.size()) {
            return 0;
        }

        String currentArray = arr.get(start);
        int[] newCurrentLetters = currentLetters.clone();
        boolean isValid = true;

        for (int i=0;i<currentArray.length();i++) {
            if (newCurrentLetters[currentArray.charAt(i) - 'a'] > 0) {
                isValid = false;
                break;
            }
            newCurrentLetters[currentArray.charAt(i) - 'a']++;
        }

        if (isValid) {
            return Math.max(currentArray.length() + maxLength(arr,start+1,newCurrentLetters),
                    maxLength(arr,start+1,currentLetters));
        }
        return maxLength(arr,start+1,currentLetters);
    }
}
