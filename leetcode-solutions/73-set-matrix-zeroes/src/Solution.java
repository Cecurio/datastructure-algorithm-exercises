import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shanxiaokai
 * @date 2021/3/21 19:28
 */
public class Solution {
    private Set<Integer> rows;
    private Set<Integer> cols;
    private int row;
    private int col;
    public void setZeroes(int[][] matrix) {
        rows = new HashSet<>();
        cols = new HashSet<>();
        row = matrix.length;
        col = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int idx: rows) {
            for (int j = 0; j < col; j++) {
                matrix[idx][j] = 0;
            }
        }

        for (int idx: cols) {
            for (int i = 0; i < row; i++) {
                matrix[i][idx] = 0;
            }
        }
        System.out.println("done");
    }

    private void print2DArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        Solution sol = new Solution();
        sol.print2DArray(matrix);
        sol.setZeroes(matrix);
        sol.print2DArray(matrix);
    }
}
