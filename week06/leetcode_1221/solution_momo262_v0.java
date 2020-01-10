package leetcode_1221;

public class solution_momo262_v0 {

    public int balancedStringSplit(String s) {
        int result = 0;
        int current = s.charAt(0) == 'L' ? -1:1;

        for (int i=1;i<s.length();i++) {
            current = current + (s.charAt(i) == 'L' ? -1:1);
            if (current == 0) {
                if (i+1 < s.length()) {
                    result = 1 + balancedStringSplit(s.substring(i+1));
                } else {
                    result = result + 1;
                }
                break;
            }
        }
        return result;
    }

}
