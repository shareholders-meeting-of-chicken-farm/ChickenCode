package LeetCode_1255;

/*
 recursion method,avoid duplicate calculation of lettersNumberCheck
 */
public class Solution_momo262_v1 {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] lettersCount = new int[26];
        for (char letter:letters) {
            lettersCount[letter-'a']++;
        }
        return maxScoreOfSubWords(0,words,lettersCount,score);
    }

    private int maxScoreOfSubWords(int startWordIndex,String[] words,int[] lettersCount,int[] score) {
        if (startWordIndex == words.length) {
            return 0;
        }

        //remainLetters if choose currentWord
        int[] remainLettersCount = lettersCount.clone();
        boolean canAddCurrentWord = true;
        int currentWordScore = 0;

        for (int j=0;j<words[startWordIndex].length();j++) {
            //check if current word can be add
            if (remainLettersCount[words[startWordIndex].charAt(j) - 'a'] < 1) {
                canAddCurrentWord = false;
                break;
            }
            currentWordScore = currentWordScore + score[words[startWordIndex].charAt(j) - 'a'];
            remainLettersCount[words[startWordIndex].charAt(j) - 'a']--;
        }

        if (!canAddCurrentWord) {
            //skip currentWord
            return maxScoreOfSubWords(startWordIndex + 1,words,lettersCount,score);
        } else {
            //compare two choices scores
            return Math.max(maxScoreOfSubWords(startWordIndex + 1,words,lettersCount,score),
                    currentWordScore +maxScoreOfSubWords(startWordIndex + 1,words,remainLettersCount,score));
        }
    }

}

