import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shanxiaokai
 * @date 2021/3/18 16:07
 */
public class Solution2 {
    // 方法二：广度优先遍历（使用二维坐标）

    /**
     * 方向向量（坐标偏移），4 个方向的顺序无关紧要
     *
     * 上、下、左、右
     */
    private final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, bfs(grid, i, j, rows, cols, visited));
                }
            }
        }
        return maxArea;
    }

    /**
     * @param grid    二维网格
     * @param i       横坐标
     * @param j       纵坐标
     * @param rows    二维网格的行数
     * @param cols    二维网格的列数
     * @param visited 标记是否访问过
     * @return 当前连通分量里结点的个数
     */
    private int bfs(int[][] grid, int i, int j, int rows, int cols, boolean[][] visited) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int curX = front[0];
            int curY = front[1];
            count++;
            // 大体框架是有的，之前就是如何找相邻，自己不会
            // 四个方向都遍历一遍
            for (int[] direction : DIRECTIONS) {
                int newX = curX + direction[0];
                int newY = curY + direction[1];
                if (inArea(newX, newY, rows, cols) && grid[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.offer(new int[]{newX, newY});
                    // 注意：一定要在入队以后马上标记为「已经访问」
                    visited[newX][newY] = true;
                }
            }
        }
        return count;
    }

    private boolean inArea(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(sol.maxAreaOfIsland(grid));
    }
}
