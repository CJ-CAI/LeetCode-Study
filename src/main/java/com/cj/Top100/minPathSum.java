public class minPathSum {
    private static int min=0;
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2,3},{4,5,6}};
        move(grid,0,0,0);
        System.out.println(min);
    }
    public static void move(int[][] grid,int x,int y,int sum){
        if(x==grid.length-1&&y==grid[0].length-1){
            sum+=grid[x][y];
            min=Math.min(min,sum);
            if(min==0)
                min=sum;
        }
        if (x<grid.length-1){
            move(grid,x+1,y,sum+grid[x][y]);
        }
        if(y<grid[0].length-1)
            move(grid,x,y+1,sum+grid[x][y]);
    }
}
