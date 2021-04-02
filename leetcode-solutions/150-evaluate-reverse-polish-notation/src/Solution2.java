import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shanxiaokai
 * @date 2021/3/20 0:41
 */
public class Solution2 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int nums2 = stack.pop();
                int nums1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(nums1 + nums2);
                        break;
                    case "-":
                        stack.push(nums1 - nums2);
                        break;
                    case "*":
                        stack.push(nums1 * nums2);
                        break;
                    case "/":
                        stack.push(nums1 / nums2);
                        break;
                    default:
                }
            }

        }
        return stack.pop();
    }

    private boolean isNumber(String s) {
        return !("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s));
    }

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        Solution2 sol = new Solution2();
        String[] tokens2 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(sol.evalRPN(tokens));
        System.out.println(sol.evalRPN(tokens2));
    }
}
