package leetcode_1252;

public class Solution_momo262_v0 {

    public int oddCells(int n, int m, int[][] indices) {
        int total=0;
        int[][] result = new int[n][m];
        for (int[] indice:indices) {
            for (int i=0;i<m;i++) {
                result[indice[0]][i]++;
            }
            for (int j=0;j<n;j++) {
                result[j][indice[1]]++;
            }
        }
        for (int[] a:result) {
            for (int b:a) {
                if (b%2 != 0) {
                    total++;
                }
            }
        }
        return total;
    }

}
