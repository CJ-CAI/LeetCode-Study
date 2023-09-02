import java.util.Arrays;

/**
 * 最大正方形
 *
 * @author CJ_CA
 * @date 2023/08/31
 */
public class maximalRectangle2 {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}};
        int x=matrix.length,y=matrix[0].length;
        int[][] cache=new int[x][y];
        int MaxSquare=0;

        for (int j = 0; j < y; j++) {
            if(matrix[0][j]=='1') {
                cache[0][j]=1;
            } else {
                cache[0][j]=0;
            }
        }
        for (int i = 1; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(matrix[i][j]=='1') {
                    cache[i][j]=cache[i-1][j]+1;
                }
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(cache[i][j]>0&&cache[i][j]*cache[i][j]>MaxSquare){
                    int side=1;
                    for (int left = j-1; left >= 0&&cache[i][left]>=cache[i][j]; left--) {
                        side++;
                    }
                    for (int right = j+1; right < y&&cache[i][right]>=cache[i][j]; right++) {
                        side++;
                    }
                    side=Math.min(cache[i][j],side);
                    MaxSquare=Math.max(side*side,MaxSquare);
                }
            }
        }
        System.out.println(MaxSquare);

        for (int i = 0; i < cache.length; i++) {
            System.out.println(Arrays.toString(cache[i]));
        }

    }
}
