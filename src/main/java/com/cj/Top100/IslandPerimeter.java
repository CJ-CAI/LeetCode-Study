/**
 * 最大岛屿周长
 *
 * @author CJ_CA
 * @date 2023/08/28
 */
public class IslandPerimeter {
    static int perimeter;
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '0', '0', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int MaxPerimeter=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    perimeter=0;
                    extension(grid, i, j);
                    MaxPerimeter=Math.max(perimeter,MaxPerimeter);
                }
            }
        }
        System.out.println(MaxPerimeter);
    }
    public static void extension(char[][] grid, int y, int x) {
        if (x < 0 || x == grid[0].length || y < 0 || y == grid.length || grid[y][x] == '0' ) {
            perimeter++;
            return;
        }
        if(grid[y][x]=='2') {
            return;
        }
        //通过标识为2标识已经遍历的坐标
        grid[y][x]='2';
        extension(grid, y + 1, x);
        extension(grid, y - 1, x);
        extension(grid, y, x + 1);
        extension(grid, y, x - 1);
    }
}
