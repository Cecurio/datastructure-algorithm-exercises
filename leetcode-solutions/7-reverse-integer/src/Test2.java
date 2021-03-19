/**
 * @author shanxiaokai
 * @date 2021/3/19 11:13
 */
public class Test2 {
    public static void main(String[] args) {
        int a = -123;
        int num = 0;
        while (a != 0) {
            int pop = a % 10;
            System.out.println(pop);
            num = num * 10 + pop;
            System.out.println(num);
            a = a / 10;
            System.out.println(a);
        }
    }
}
