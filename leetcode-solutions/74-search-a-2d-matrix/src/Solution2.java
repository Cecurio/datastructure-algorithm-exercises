import java.util.Arrays;

/**
 * @author shanxiaokai
 * @date 2021/3/30 0:24
 */
public class Solution2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        return fun(matrix, 0, matrix.length - 1, target);
    }

    boolean fun(int[][] matrix, int low, int high, int target) {
        if (low > high) return false;
        int mid = low + ((high - low) >> 1);
        int n = matrix[0].length;
        int idx = binarySearch(matrix[mid], 0, n - 1, target);
        if (-1 != idx) {
            return true;
        } else if (target < matrix[mid][0]) {
            return fun(matrix, low , mid - 1, target);
        } else if (target > matrix[mid][n - 1]){
            return fun(matrix, mid + 1, high, target);
        }
        return false;
    }


    int binarySearch(int[] nums, int L, int R, int target) {
        if (L > R) return -1;
        int mid = L + ((R - L) >> 1);
        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            return binarySearch(nums, L, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, R, target);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        Solution2 sol = new Solution2();
        System.out.println(sol.searchMatrix(matrix, 13));
    }
}
