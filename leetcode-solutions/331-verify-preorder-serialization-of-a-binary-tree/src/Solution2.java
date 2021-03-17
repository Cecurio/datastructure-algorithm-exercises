import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;

        // 一开始的槽位为1，目的是存放根节点
        int slots = 1;
        // 遍历整个前序字符串
        while (i < n) {
            if (slots == 0) {
                // 遍历过程中没有槽位了，不合法
                return false;
            }
            // 前序序列，字符的种类：数字（即节点的值）、#（代表空节点）、逗号分隔符
            if (preorder.charAt(i) == ',') {
                // 为逗号，往前走，其他什么都不做
                i++;
            } else if (preorder.charAt(i) == '#') {
                // 为#，代表空节点
                slots--;
                i++;
            } else {
                // 其他只能是数字

                //处理诸如11,22,#,#,33,#,#这样的序列，他的数字并不是一位的
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                slots = slots - 1 + 2;
            }
        }
        return slots == 0;

    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
