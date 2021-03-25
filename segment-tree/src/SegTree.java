import java.util.Arrays;

/**
 * @author shanxiaokai
 * @date 2021/3/24 22:06
 */
public class SegTree {
    private int[] arr;
    private int size;
    private int[] tree = new int[8];

    public SegTree(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
        Arrays.fill(tree, 0);
        build_tree(0, 0, size - 1);
    }

    private void build_tree(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            int left_node = 2 * node + 1;
            int right_node = 2 * node + 2;
            // 必要时扩容
            if (left_node >= this.tree.length || right_node >= this.tree.length) {
                resize();
            }
            build_tree(left_node, start, mid);
            build_tree(right_node, mid + 1, end);
            tree[node] = tree[left_node] + tree[right_node];
        }
    }

    private void resize() {
        int len = this.tree.length;
        this.tree = Arrays.copyOf(this.tree, len * 2);
    }

    public void update(int idx, int val) {
        update(0, 0, this.size - 1, idx, val);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            arr[idx] = val;
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;
            int left_node = 2 * node + 1;
            int right_node = 2 * node + 2;
            if (idx >= start && idx <= mid) {
                // 更改左边的分支
                update(left_node, start, mid, idx, val);
            } else {
                update(right_node, mid + 1, end, idx, val);
            }
            // 左右分支均已经修改完毕，所以现在更改根节点的值
            tree[node] = tree[left_node] + tree[right_node];
        }
    }

    public int query(int L, int R) {
        return query_tree(0, 0, size - 1, L, R);
    }

    private int query_tree(int node, int start, int end, int L, int R) {
        if (R < start || end < L) {
            return 0;
        } else if (start == end) {
            return tree[node];
        } else if (L <= start && end <= R) {
            return this.tree[node];
        } else {
            int mid = (start + end) / 2;
            int left_node = 2 * node + 1;
            int right_node = 2 * node + 2;
            int sum_left = query_tree(left_node, start, mid, L, R);
            int sum_right = query_tree(right_node, mid + 1, end, L, R);
            return sum_left + sum_right;
        }
    }

}
