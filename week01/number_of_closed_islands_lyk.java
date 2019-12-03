package cloas_ilands;

import java.util.HashMap;
import java.util.Map;

public class number_of_closed_islands_lyk {

    public static void main(String[] args){

    }

    class node{
        HashMap<String, Integer> markMap;
        Boolean status = false;


        void mergeNode(node n){
        }
    }

    public int closedIsland(int[][] grid) {
        if (grid.length <= 2){
            return 0;
        }

        int[][] mark = new int[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid.length; j++){
                if (grid[i][j] == 0){

                }
            }
        }

        return 0;
    }


}
