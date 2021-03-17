/**
 * @author shanxiaokai
 * @date 2021/3/17 22:02
 */
public class Test {

    //一、指定的某一位数置1
    //
    //          宏 #define setbit(x,y)  x|=(1<<y)
    //
    //二、指定的某一位数置0
    //
    //          宏  #define clrbit(x,y)  x&=~(1<<y)
    //
    //三、指定的某一位数取反
    //
    //          宏  #define reversebit(x,y)  x^=(1<<y)
    //
    //三、获取的某一位的值
    //
    //         宏 #define getbit(x,y)   ((x) >> (y)&1)
    //————————————————

    /**
     * 将 一个数的某一位 置为1
     *
     * @param x
     * @param i i从0开始，从右边开始计算
     */
    int setBit(int x, int i) {
        return x | (1 << i);
    }

    /**
     * 将 一个数的某一位 置为0
     * @param x
     * @param i i从0开始，从右边开始计算
     * @return
     */
    int clrBit(int x, int i) {
        return x & ~(1 << i);
    }

    /**
     * 对某一位取反
     * 与0 按位异或, 保持不变
     * 与1 按位异或, 取反
     *
     * @return
     */
    int reverseBit(int x, int i) {
        return x ^ (1 << i);
    }

    /**
     * 获取 x 的第i位的值
     * @param x
     * @param i
     * @return
     */
    int getBit(int x, int i) {
        // 对于((x) >> (i) & 1), 从左往右依次执行
        // 先执行 (x) >> (i)
        return ((x) >> (i) & 1);
    }

    public static void main(String[] args) {
        Test t = new Test();

        // 二进制： 100 1010
        // 十六进制：0x4A

        int m = 0x4A;
        System.out.println(String.format("%X", t.setBit(m, 2)));
        System.out.println(String.format("%X", t.clrBit(m, 1)));
        System.out.println(String.format("%X", t.reverseBit(m, 0)));
        System.out.println(String.format("%X", t.getBit(m, 3)));
        System.out.println(String.format("%X", t.getBit(m, 2)));

    }
}
