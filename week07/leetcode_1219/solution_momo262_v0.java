package leetcode_1219;

/*
[00,00,00,00,00,00,32,00,00,20],
[00,00,02,00,00,00,00,40,00,32],
[13,20,36,00,00,00,20,00,00,00],
[00,31,27,00,19,00,00,25,18,00],
[00,00,00,00,00,00,00,00,00,00],
[00,00,00,00,00,00,00,18,00,06],
[00,00,00,25,00,00,00,00,00,00],
[00,00,00,21,00,30,00,00,00,00],
[19,10,00,00,34,00,02,00,00,27],
[00,00,00,00,00,34,00,00,00,00]
 */

public class solution_momo262_v0 {

    public int getMaximumGold(int[][] grid) {
        int result = 0;

        for(int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] != 0) {
                    result = Math.max(getMaximumGold(grid,i,j,new boolean[grid.length][grid[0].length]), result);
                }
            }
        }
        return result;
    }

    public int getMaximumGold(int[][] grid,int row,int column,boolean[][] visited) {

        if (row < 0 || row >= grid.length) {
            return 0;
        }

        if (column < 0 || column >= grid[0].length) {
            return 0;
        }

        if (grid[row][column] == 0) {
            return 0;
        }

        if (visited[row][column]) {
            return 0;
        }

        int result = grid[row][column];
        visited[row][column] = true;

        int left = getMaximumGold(grid,row,column-1,visited);
        int right = getMaximumGold(grid,row,column+1,visited);
        int top = getMaximumGold(grid,row-1,column,visited);
        int bottom = getMaximumGold(grid,row+1,column,visited);

        visited[row][column] = false;
        return result + Math.max(Math.max(left,right),Math.max(top,bottom));
    }

}
