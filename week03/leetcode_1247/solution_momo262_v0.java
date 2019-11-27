package leetcode_1247;

public class solution_momo262_v0 {

    public int minimumSwap(String s1, String s2) {
        int result = 0;
        int case1 = 0;
        int case2 = 0;

        for(int i=0;i<s1.length();i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                if (case1 == 1) {
                    result++;
                    case1--;
                } else {
                    case1++;
                }
            }
            else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                if (case2 == 1) {
                    result++;
                    case2--;
                } else {
                    case2++;
                }
            }
        }

        if (case1 == 1 && case2 == 1) {
            return result + 2;
        }
        else if (case1 != case2) {
            return -1;
        }
        return result;
    }

}
