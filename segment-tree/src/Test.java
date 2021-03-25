/**
 * @author shanxiaokai
 * @date 2021/3/25 11:13
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegTree st = new SegTree(arr);
        st.update(4, 6);
        int res = st.query(2, 5);
        System.out.println(res);
    }
}
