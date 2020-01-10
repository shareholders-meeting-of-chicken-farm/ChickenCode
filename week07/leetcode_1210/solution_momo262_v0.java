package leetcode_1210;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
[0,0,0,0,0,0,0,0,0,1],
[0,1,0,0,0,0,0,1,0,1],
[1,0,0,1,0,0,1,0,1,0],
[0,0,0,1,0,1,0,1,0,0],
[0,0,0,0,1,0,0,0,0,1],
[0,0,1,0,0,0,0,0,0,0],
[1,0,0,1,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0,0,0],
[1,1,0,0,0,0,0,0,0,0]
 */
public class solution_momo262_v0 {

    int[][] resultArray = new int[10000][2];

    public int minimumMoves(int[][] grid) {
        int[] snake1 = {0,0};
        int[] snake2 = {0,1};
        return move(snake1,snake2,true,grid,false,false);
    }

    public int move(int[] snake1,int[] snake2,boolean horizontal,int[][] grid,
                    boolean clockwise,boolean counterclockwise) {
        int key1 = snake1[0]*100 + snake1[1];
        int key2 = horizontal ? 0:1;
        if (resultArray[key1][key2] != 0) {
            return resultArray[key1][key2];
        }

        int result = Integer.MAX_VALUE;

        if (snake1[0] == grid.length-1 && snake1[1] == grid.length-2
            && snake2[0] == grid.length-1 && snake2[1] == grid.length -1) {
            return 0;
        }

        if (snake2[1] < grid.length -1 && grid[snake2[0]][snake2[1]+1] == 0
         && grid[snake1[0]][snake1[1]+1] == 0) {
            int[] rightSnake1 = snake1.clone();
            rightSnake1[1]++;
            int[] rightSnake2 = snake2.clone();
            rightSnake2[1]++;
            int rightResult = move(rightSnake1,rightSnake2,horizontal,grid,false,false);

            if (rightResult != -1) {
                result = Math.min(result,1 + rightResult);
            }
        }

        if (snake2[0] < grid.length -1 && grid[snake2[0]+1][snake2[1]] == 0
            && grid[snake1[0]+1][snake1[1]] == 0) {
            int[] bottomSnake1 = snake1.clone();
            bottomSnake1[0]++;
            int[] bottomSnake2 = snake2.clone();
            bottomSnake2[0]++;
            int bottomResult = move(bottomSnake1,bottomSnake2,horizontal,grid,false,false);

            if (bottomResult != -1) {
                result = Math.min(result,1 + bottomResult);
            }
        }

        if (horizontal && snake2[0] < grid.length - 1 && grid[snake2[0]+1][snake2[1]] == 0
                && grid[snake1[0]+1][snake1[1]] == 0 && !counterclockwise) {
            int[] clockwiseSnake1 = snake1.clone();
            int[] clockwiseSnake2 = snake2.clone();
            clockwiseSnake2[0]++;
            clockwiseSnake2[1]--;
            int clockwiseResult = move(clockwiseSnake1,clockwiseSnake2,
                    false,grid,true,false);

            if (clockwiseResult != -1) {
                result = Math.min(result,1 + clockwiseResult);
            }
        }

        if (!horizontal && snake2[1] < grid.length -1 && grid[snake2[0]][snake2[1]+1] == 0
            && grid[snake1[0]][snake1[1]+1] == 0 && !clockwise) {
            int[] counterclockwiseSnake1 = snake1.clone();
            int[] counterclockwiseSnake2 = snake2.clone();
            counterclockwiseSnake2[0]--;
            counterclockwiseSnake2[1]++;
            int counterclockwiseResult = move(counterclockwiseSnake1,counterclockwiseSnake2,
                    true,grid,false,true);

            if (counterclockwiseResult != -1) {
                result = Math.min(result,1 + counterclockwiseResult);
            }
        }

        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
        resultArray[key1][key2] = result;
        return result;
    }

}
