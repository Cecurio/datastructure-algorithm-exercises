/**
 * @author shanxiaokai
 * @date 2021/3/19 10:38
 */
public class Test {
    public static void main(String[] args) {
        int a = 0b1111;
        System.out.println(a);

        int b = 1534236469;
        System.out.println(String.format("%x", b));
        System.out.println(String.format("%x", 15));
        System.out.println(String.format("%x", -1));
        System.out.println(String.format("%x", Integer.MIN_VALUE));
    }
}
