/**
 * @author shanxiaokai
 * @date 2021/3/30 0:22
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] nums = new int[m * n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[idx++] = matrix[i][j];
            }
        }

        return binarySearch(nums, 0, m * n - 1 ,target) != -1;
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

    }
}
