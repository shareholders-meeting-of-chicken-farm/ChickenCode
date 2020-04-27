package leetcode_1222;

import java.util.ArrayList;
import java.util.List;

public class solution_momo262_v0 {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<int[]> resultList = new ArrayList<>();

        //left
        for (int i=king[1] -1;i>=0;i--) {
            if (isInQueens(queens,i,king[0])) {
                int[] result = {king[0],i};
                resultList.add(result);
                break;
            }
        }

        //right
        for (int i=king[1] +1;i<8;i++) {
            if (isInQueens(queens,i,king[0])) {
                int[] result = {king[0],i};
                resultList.add(result);
                break;
            }
        }

        //top
        for (int i=king[0] -1;i>=0;i--) {
            if (isInQueens(queens,king[1],i)) {
                int[] result = {i,king[1]};
                resultList.add(result);
                break;
            }
        }

        //bottom
        for (int i=king[0] +1;i<8;i++) {
            if (isInQueens(queens,king[1],i)) {
                int[] result = {i,king[1]};
                resultList.add(result);
                break;
            }
        }
        //diagnal
        int kingx = king[1];
        int kingy = king[0];
        while (kingx > 0 && kingy > 0) {
            kingx--;
            kingy--;
            if (isInQueens(queens,kingx,kingy)) {
                int[] result = {kingy,kingx};
                resultList.add(result);
                break;
            }
        }
        //diagnal
        kingx = king[1];
        kingy = king[0];
        while (kingx > 0 && kingy < 7) {
            kingx--;
            kingy++;
            if (isInQueens(queens,kingx,kingy)) {
                int[] result = {kingy,kingx};
                resultList.add(result);
                break;
            }
        }
        //diagnal
        kingx = king[1];
        kingy = king[0];
        while (kingx < 7 && kingy > 0) {
            kingx++;
            kingy--;
            if (isInQueens(queens,kingx,kingy)) {
                int[] result = {kingy,kingx};
                resultList.add(result);
                break;
            }
        }
        //diagnal
        kingx = king[1];
        kingy = king[0];
        while (kingx < 7 && kingy < 7) {
            kingx++;
            kingy++;
            if (isInQueens(queens,kingx,kingy)) {
                int[] result = {kingy,kingx};
                resultList.add(result);
                break;
            }
        }

        return new ArrayList(resultList);
    }

    private boolean isInQueens(int[][] queens,int x,int y) {
        for (int[] queen:queens) {
            if (queen[1] == x && queen[0] == y) {
                return true;
            }
        }
        return false;
    }

}
