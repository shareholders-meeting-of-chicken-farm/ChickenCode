package LeetCode_1254;

public class Solution {
    private int columnNumber;

    public int closedIsland(int[][] grid) {
        int result = 0;
        columnNumber = grid[0].length;

        //travelFirstBottomLine and exclude 0s that connect to them
        for (int j=0;j<columnNumber;j++) {
            travel(grid,0,j);
            travel(grid,grid.length - 1,j);
        }
        //travelLeftAndRightColumn and exclude 0s that connect to them
        for (int i=1;i<grid.length-1;i++) {
            travel(grid,i,0);
            travel(grid,i,columnNumber - 1);
        }
        //get 0s that is not connected to corners
        for (int k=1;k<grid.length-1;k++) {
            for (int m=1;m<columnNumber-1;m++) {
                if (grid[k][m] == 0) {
                    result++;
                    travel(grid,k,m);
                }
            }
        }
        return result;
    }

    //travel from 0,until no more connected 0s
    private void travel(int[][] grid,int rowIndex,int columnIndex) {
        if (grid[rowIndex][columnIndex] == 1) {
            return;
        }
        grid[rowIndex][columnIndex] = 1;//set to 1,mark as travelled
        if (rowIndex > 0) {
            travel(grid,rowIndex - 1,columnIndex);//travel up
        }
        if (rowIndex < grid.length - 1) {
            travel(grid,rowIndex + 1,columnIndex);//travel down
        }
        if (columnIndex > 0) {
            travel(grid,rowIndex,columnIndex -1);//travel left
        }
        if (columnIndex < columnNumber - 1) {
            travel(grid,rowIndex,columnIndex + 1);//travel right
        }
    }
}
