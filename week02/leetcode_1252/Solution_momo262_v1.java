package leetcode_1252;

public class Solution_momo262_v1 {

    public int oddCells(int n, int m, int[][] indices) {
        int total=0;
        int[][] result = new int[n][m];
        for (int[] indice:indices) {
            for (int i=0;i<m;i++) {
                if (result[indice[0]][i] == 0) {
                    result[indice[0]][i]++;
                    total++;
                } else {
                    result[indice[0]][i]--;
                    total--;
                }
            }
            for (int j=0;j<n;j++) {
                if (result[j][indice[1]] == 0) {
                    result[j][indice[1]]++;
                    total++;
                } else {
                    result[j][indice[1]]--;
                    total--;
                }
            }
        }
        return total;
    }

}
