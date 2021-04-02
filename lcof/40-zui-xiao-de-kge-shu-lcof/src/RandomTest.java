import java.util.Random;

/**
 * @author shanxiaokai
 * @date 2021/3/22 20:49
 */
public class RandomTest {

    public static void main(String[] args) {
        Random r = new Random();
        // 产生[0-10)的随机数
        for (int i = 0; i < 100; i++) {
            System.out.println(r.nextInt(10));
        }
    }
}
