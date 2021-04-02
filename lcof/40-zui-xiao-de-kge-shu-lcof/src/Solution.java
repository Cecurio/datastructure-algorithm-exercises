import java.util.Arrays;
import java.util.Random;

/**
 * @author shanxiaokai
 * @date 2021/3/22 13:50
 */
public class Solution {
    int k;

    public int[] getLeastNumbers(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        this.k = k - 1;
        return quickSelect(arr, left, right);
    }

    int[] quickSelect(int[] arr, int left, int right) {
        int[] p = randomPartition(arr, left, right);
        if (p[0] == k) {
            return Arrays.copyOfRange(arr, 0, k + 1);
        } else if (p[0] == k + 1) {
            return Arrays.copyOfRange(arr, 0, k + 1);
        } else if(k < p[0] - 1) {
            return quickSelect(arr, left, p[0] - 1);
        } else {
            return quickSelect(arr, p[0] + 1, right);
        }
    }


    private int[] randomPartition(int[] arr, int L, int R) {
        int idx = new Random().nextInt(R - L + 1) + L;
//        System.out.println("Solution.randomPartition");
//        System.out.println("idx = " + idx);
        swap(arr, idx, R);
        return partition(arr, L, R);
    }

    private int[] partition(int[] arr, int L, int R) {
        // arr[R]为划分值
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    void f1() {
        int[] nums = {2, 1, 5, 4, 4, 4};
        System.out.println(Arrays.toString(nums));
        int[] p = partition(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(p));
        System.out.println(Arrays.toString(nums));
    }

    void f2() {
        int[] nums = {3, 9, 2, 5, 7, 4, 8, 1, 6};
        System.out.println(Arrays.toString(nums));
        int[] p = partition(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(p));
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] arr = {0, 1, 2, 1};
//        int k = 1;
//        System.out.println(Arrays.toString(sol.getLeastNumbers(arr, k)));
        int[] nums = {3, 6, 2, 5, 7, 4, 8, 1, 9};
//        int[] p = sol.randomPartition(nums, 0, nums.length - 1);
//        for (int i : p) {
//            System.out.println("i = " + i);
//        }
//        for (int num : nums) {
//            System.out.print(num + " ");
//        }
//        System.out.println();

        int[] res = sol.getLeastNumbers(nums, 4);
        for (int re : res) {
            System.out.print(re + " ");
        }


//        sol.f2();


    }

}
