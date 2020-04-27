package maximum_score_words;

public class maximum_score_words_formed_by_letters_lyk {
    public static void main(String[] args){
        String[] words =  new String[]{"dog", "cat", "dad", "good"};
        char[] letters = new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
        int[] scores = new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        maximum_score_words_formed_by_letters_lyk s = new maximum_score_words_formed_by_letters_lyk();
        int max = s.maxScoreWords(words, letters, scores);
        System.out.println(max);
    }

    class Word{
        Node[] nodes;
        int score;
    }

    class Node{
        int index;
        int count;
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letterMap = new int[26];
        Word[] wordScoreMap = new Word[words.length];
        for (int i=0; i<letters.length; i++){
            letterMap[letters[i]-'a']++;
        }

        for (int i=0; i<words.length; i++){
            int[] wordMap = new int[26];
            int charLength = 0;
            for (int j=0; j<words[i].length(); j++){
                wordMap[words[i].charAt(j)-'a']++;
                if (wordMap[words[i].charAt(j)-'a'] == 1){
                    charLength++;
                }
            }

            Node[] nodes = new Node[charLength];
            int nodeIndex = 0;
            int wordScore = 0;
            Word w = new Word();
            for (int j=0; j<wordMap.length; j++){
                if (wordMap[j] > 0){
                    if (wordMap[j] > letterMap[j]){
                        w.score = 0;
                        break;
                    }
                    Node newNode = new Node();
                    newNode.index = j;
                    newNode.count = wordMap[j];
                    nodes[nodeIndex] = newNode;
                    nodeIndex++;
                    w.score += newNode.count * score[j];
                }
            }
            w.nodes = nodes;
            wordScoreMap[i] = w;
        }

        return computerScore(0,  wordScoreMap, letterMap);
    }

    int computerScore(int index, Word[] words, int[] letters){
        if (index == words.length){
            return 0;
        }

        //判断是否可以match
        Word word = words[index];
        boolean match = true;
        if (word.score == 0){
            match = false;
        }else{
            for (int i=0; i<word.nodes.length; i++){
                if (letters[word.nodes[i].index] < word.nodes[i].count){
                    match = false;
                    break;
                }
            }
        }

        if (match){
            //可以选择match，或者不match
            int matchScore = word.score;
            for (int i=0; i<word.nodes.length; i++){
                letters[word.nodes[i].index] -= word.nodes[i].count;
            }
            matchScore += computerScore(index+1, words, letters);

            for (int i=0; i<word.nodes.length; i++){
                letters[word.nodes[i].index] += word.nodes[i].count;
            }
            int notMatchScore = computerScore(index+1, words, letters);
            System.out.println("index:"+index+" match:"+matchScore+" notmatch:"+notMatchScore);
            return Math.max(notMatchScore, matchScore);
        }else{
            //只能不match
            return computerScore(index+1, words, letters);
        }

    }
}
