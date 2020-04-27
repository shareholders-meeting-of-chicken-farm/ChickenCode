package leetcode_1234;

public class solution_momo262_v0 {

    public static void main(String[] args) {
        System.out.println(balancedString(""));
    }

    public static int balancedString(String s) {
        int result = Integer.MAX_VALUE;
        int number = s.length() / 4;
        int end = s.length() - 1;
        int remain[] = new int[26];
        remain['Q' - 'A'] = number;
        remain['W' - 'A'] = number;
        remain['E' - 'A'] = number;
        remain['R' - 'A'] = number;


        for (int j = s.length() - 1; j >= 0; j--) {
            if (remain[s.charAt(j) - 'A'] > 0) {
                end--;
                remain[s.charAt(j) - 'A']--;
            } else {
                break;
            }
        }

        end++;
        result = Math.min(end,result);

        for (int i = 0; i < s.length(); i++) {

            if (remain[s.charAt(i) - 'A'] == 0) {
                for (int j = end; j < s.length(); j++) {
                    remain[s.charAt(j) - 'A']++;
                    end++;
                    if (s.charAt(j) == s.charAt(i)) {
                        break;
                    }
                }
            }
            if (remain[s.charAt(i) - 'A'] == 0) {
                break;
            }
            remain[s.charAt(i) - 'A']--;
            result = Math.min(end - i - 1, result);
        }
        return result;
    }

}
