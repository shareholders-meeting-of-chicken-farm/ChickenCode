package LeetCode_1255;

public class Solution {

    private int[] wordScore = new int[14];

    private int[][] wordLettersCount = new int[14][26];

    private int[] lettersCount = new int[26];

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int result = 0;
        getWordScore(words,score);
        getLettersCount(letters);

        double j = Math.pow(2,words.length) - 1;

        while (j > 0) {
            int currentScore = 0;
            int[] wordsLettersCount = new int[26];
            boolean isValid = true;

            String binary = Integer.toBinaryString((int)j);

            for (int i=binary.length();i>0;i--) {
                if (binary.charAt(i-1) == '1') {
                    currentScore = currentScore +  wordScore[binary.length()-i];
                    for (int k=0;k<26;k++) {
                        if (wordLettersCount[binary.length()-i][k] > 0) {
                            if (wordLettersCount[binary.length()-i][k] + wordsLettersCount[k] > lettersCount[k]) {
                                isValid = false;
                                break;
                            }
                            wordsLettersCount[k] = wordLettersCount[binary.length()-i][k] + wordsLettersCount[k];
                        }
                    }
                }
                if (!isValid) {
                    break;
                }
            }
            if (currentScore > result && isValid) {
                result = currentScore;
            }
            j--;
        }
        return result;
    }


    private void getWordScore(String[] words,int[] score) {
        int index = 0;
        for (String word:words) {
            int result = 0;
            for (int i=0;i<word.length();i++) {
                result = result + score[word.charAt(i) - 'a'];
                wordLettersCount[index][word.charAt(i) - 'a']++;
            }
            wordScore[index] = result;
            index++;
        }
    }

    private void getLettersCount(char[] letters) {
        for (char letter:letters) {
            lettersCount[letter-'a']++;
        }
    }

}
