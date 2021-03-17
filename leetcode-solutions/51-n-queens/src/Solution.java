import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 使用 栈 记录路径
 *
 * @author shanxiaokai
 * @date 2021/3/16 13:42
 */
public class Solution {

    private int n;

    private boolean[] cols;
    private boolean[] main;
    private boolean[] sub;

    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        cols = new boolean[n];
        main = new boolean[2 * n - 1];
        sub = new boolean[2 * n - 1];
        res = new ArrayList<>();

        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, path);
        return res;
    }

    // 辅助调试用的
    int cnt;

    /**
     * 用作队列
     * <p>
     * 递归的退出条件：
     * 1. row == n
     * or
     * 2. 走遍<pre>for (int j = 0; j < n; j++) {}</pre>这个循环，每次的<pre>if</pre>判断都不为真
     *
     * @param row
     * @param path
     */
    public void dfs(int row, Deque<Integer> path) {
        // 辅助调试用的
        //System.out.println(String.format("dfs(%d,path)",row));
        cnt++;
        if (row == n) {
            // 把此时的栈中元素保留下来
            // 使用传统的栈可以做到，但是比较麻烦
            res.add(convert2Board(path));
            return;
        }

        // 虽然只有一层循环，但是习惯上，喜欢用i表示行，j表示列
        // 故此处用j表示列
        for (int j = 0; j < n; j++) {
            // row的取值范围是0,1,2,...,(n-1),表示当前在第几行

            // 检查是否可以放元素
            if (!cols[j] && !main[row - j + n - 1] && !sub[row + j]) {
                // j入栈
                path.addLast(j);
                cols[j] = true;
                main[row - j + n - 1] = true;
                sub[row + j] = true;

                dfs(row + 1, path);

                // 如果下一层无解，则取消之前的true标记
                cols[j] = false;
                main[row - j + n - 1] = false;
                sub[row + j] = false;
                // 之前入栈的j也出栈，因为已经出现了不可能的解
                path.removeLast();
            }

        }
    }

    private List<String> convert2Board(Deque<Integer> path) {
        List<String> list = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == num) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solveNQueens(4);
        System.out.println(sol.res);
        //System.out.println(sol.cnt);
    }
}
