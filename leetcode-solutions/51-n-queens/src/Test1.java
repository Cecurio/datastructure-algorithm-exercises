import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shanxiaokai
 * @date 2021/3/16 14:19
 */
public class Test1 {
    public static void main(String[] args) {
        Deque<Integer> path = new ArrayDeque<>();
        path.addLast(1);
        path.addLast(2);
        path.addLast(3);
        System.out.println("当前队列中的元素："+path);
        System.out.println("栈顶元素出栈："+path.removeLast());
        System.out.println("栈顶元素出栈："+path.removeLast());
        System.out.println("栈顶元素出栈："+path.removeLast());
        System.out.println("栈顶元素出栈："+path.removeLast());
    }
}
