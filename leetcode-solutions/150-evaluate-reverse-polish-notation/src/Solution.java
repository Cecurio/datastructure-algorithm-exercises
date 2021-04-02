import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shanxiaokai
 * @date 2021/3/20 0:25
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int a = 0;
        int b = 0;
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                a = stack.removeLast();
                b = stack.removeLast();
                stack.addLast(b + a);
            } else if ("-".equals(tokens[i])) {
                a = stack.removeLast();
                b = stack.removeLast();
                stack.addLast(b - a);
            } else if ("*".equals(tokens[i])) {
                a = stack.removeLast();
                b = stack.removeLast();
                stack.addLast(b * a);
            } else if ("/".equals(tokens[i])) {
                a = stack.removeLast();
                b = stack.removeLast();
                stack.addLast(b / a);
            } else {
                stack.addLast(Integer.parseInt(tokens[i]));
            }
        }
        return stack.removeLast();
    }

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        Solution sol = new Solution();
        String[] tokens2 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(sol.evalRPN(tokens));
        System.out.println(sol.evalRPN(tokens2));
    }
}
