import java.util.Queue;
import java.util.LinkedList;
/**
 * @author shanxiaokai
 * @date 2021/3/18 22:39
 */


public class Solution {

    private final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[] visited = new boolean[rows * cols];

        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[getIndex(i, j, cols)]) {
                    maxArea = Math.max(maxArea, bfs(grid, i, j, rows, cols, visited));
                }
            }
        }
        return maxArea;
    }

    private int bfs(int[][] grid, int i, int j, int rows, int cols, boolean[] visited) {
        int count = 0;
        // 队列中放的是Integer, 方法2中的队列放的是int[], 此处的处理优于方法2
        Queue<Integer> queue = new LinkedList<>();
        int index = getIndex(i, j, cols);
        queue.offer(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int front = queue.poll();
            int curX = front / cols;
            int curY = front % cols;
            count++;
            for (int[] direction : DIRECTIONS) {
                int newX = curX + direction[0];
                int newY = curY + direction[1];

                int newIndex = getIndex(newX, newY, cols);
                if (inArea(newX, newY, rows, cols) && grid[newX][newY] == 1 && !visited[newIndex]) {
                    queue.offer(newIndex);
                    visited[newIndex] = true;
                }
            }
        }
        return count;
    }


    private int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }

    private boolean inArea(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}

