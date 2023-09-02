public class minPathSum2 {
    public static void main(String[] args) {

        int[][] grid = new int[][]{{1,2,3},{4,5,6}};
        int[][] ints = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(i==0&&j==0)
                    ints[i][j]=grid[0][0];
                else if (i==0)
                    ints[i][j]=grid[i][j]+ints[i][j-1];
                else if (j==0) {
                    ints[i][j]=grid[i][j]+ints[i-1][j];
                } else {
                    if(ints[i-1][j]>ints[i][j-1])
                        ints[i][j]=grid[i][j]+ints[i][j-1];
                    else
                        ints[i][j]=grid[i][j]+ints[i-1][j];
                }
            }
        }
        System.out.println(ints[grid.length-1][grid[0].length-1]);

    }
}
