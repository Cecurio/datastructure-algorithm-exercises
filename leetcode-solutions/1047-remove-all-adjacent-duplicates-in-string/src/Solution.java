import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        if ("".equals(S) || S == null)
            return "";
        for (int i = 0; i < S.length(); i++) {

            if (!stack.isEmpty() && stack.peek().equals(S.charAt(i))) {
                stack.pop();
            } else {
                stack.push(new Character(S.charAt(i)));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates2("abbaca"));
//        System.out.println(sol.removeDuplicates2(""));
        char[] arr = new char[]{'a', 'b', 'c', 'd'};
        int[] brr = new int[]{1, 2, 3, 4};
//        System.out.println(arr);
//        System.out.println(Arrays.toString(brr));
        System.out.println(String.valueOf(arr, 0, 2));
    }

    public String removeDuplicates1(String S) {
        StringBuilder current = new StringBuilder(S);
        for (int i = 0; i < current.length() - 1; i++) {
            if (current.charAt(i) == current.charAt(i + 1)) {
                current.deleteCharAt(i);
                current.deleteCharAt(i);
                return removeDuplicates1(current.toString());
            }
        }
        return current.toString();
    }

    public String removeDuplicates2(String S) {
        int n = S.length();
        char[] s = S.toCharArray();
        char[] ans = new char[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            if (top == -1 || ans[top] != s[i]) {
                // 入栈
                ans[++top] = s[i];
            } else {
                // 出栈
                top--;
            }
        }
        System.out.println(ans);
        System.out.println(ans.length);
        System.out.println(ans[2] == 0);
        System.out.println("top=" + top);
        return String.valueOf(ans, 0, top + 1);
    }

    public void test(int x) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        s1.push(x);
        s2.push(x);
        int p1 = s1.peek();
        int p2 = s2.peek();
        System.out.println("s1 cur stack: " + s1);
        System.out.println("s2 cur stack: " + s2);
        System.out.println(p1 == p2);
        System.out.println(s1.peek() == s2.peek());
    }
}