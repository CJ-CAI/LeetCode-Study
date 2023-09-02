/**
 * 马克斯lsland
 *
 * @author CJ_CA
 * @date 2023/08/28
 */
public class MaxIsland {
    static int area;
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '0', '0', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int MaxArea=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    area=0;
                    extension(grid, i, j);
                    MaxArea=Math.max(area,MaxArea);
                }
            }
        }
        System.out.println(MaxArea);
    }

    public static void extension(char[][] grid, int y, int x) {
        if (x < 0 || x == grid[0].length || y < 0 || y == grid.length || grid[y][x] == '0') {
            return;
        }
        area++;
        //通过标识为0标识已经遍历的坐标
        grid[y][x]='0';
        extension(grid, y + 1, x);
        extension(grid, y - 1, x);
        extension(grid, y, x + 1);
        extension(grid, y, x - 1);
    }
}
