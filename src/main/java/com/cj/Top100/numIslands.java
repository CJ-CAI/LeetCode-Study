import java.util.Arrays;
import java.util.HashMap;

/**
 * 岛屿数量
 *
 * @author CJ_CA
 * @date 2023/08/26
 */
public class numIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    extension(grid, i, j);
                }
            }
        }
        System.out.println(count);
    }

    public static void extension(char[][] grid, int y, int x) {
        if (x < 0 || x == grid[0].length || y < 0 || y == grid.length || grid[y][x] == '0') {
            return;
        }
        //通过标识为0标识已经遍历的坐标
        grid[y][x]='0';
        extension(grid, y + 1, x);
        extension(grid, y - 1, x);
        extension(grid, y, x + 1);
        extension(grid, y, x - 1);
    }
}
