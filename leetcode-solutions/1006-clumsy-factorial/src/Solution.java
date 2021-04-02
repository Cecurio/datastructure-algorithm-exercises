import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shanxiaokai
 * @date 2021/4/1 18:38
 */
public class Solution {

    public int clumsy(int N) {
        cur = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(N);
        for (int i = N - 1; i >= 1; i--) {
            char c = get();
            if (c == '*') {
                // 计算
                int peek = stack.pop();
                stack.push(new Integer(peek * i));
            } else if (c == '/') {
                int peek = stack.pop();
                stack.push(new Integer(peek / i));
            } else if (c == '+') {
                stack.push(i);
            } else if (c == '-') {
                stack.push(-1 * i);
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    int cur = 0;

    char get() {
        int t = cur;
        cur = (cur + 1) % 4;
        if (t % 4 == 0) return '*';
        else if (t % 4 == 1) return '/';
        else if (t % 4 == 2) return '+';
        else if (t % 4 == 3) return '-';
        return ' ';
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.clumsy(4) == 7);
        System.out.println(sol.clumsy(10) == 12);
    }
}
