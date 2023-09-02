/**
 * @author CJ_CA
 */
public class maximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int x=matrix.length,y=matrix[0].length;

        int[][] flag = new int[x][y];
        int Max=0;

        for (int j = 0; j < y; j++) {
            if(matrix[0][j]=='1') {
                flag[0][j]=1;
            }
        }

        for (int i = 1; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(matrix[i][j]=='1'){
                    flag[i][j]=flag[i-1][j]+1;
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(flag[i][j]!=0){
                    //提高效率
                    if(flag[i][j]*y<Max) {
                        continue;
                    }
                    int width=1;
                    for (int left = j-1; left >-1; left--) {
                        if(flag[i][left]<flag[i][j]) {
                            break;
                        }
                        width++;
                    }

                    for (int right = j+1; right < y; right++) {
                        if(flag[i][right]<flag[i][j]) {
                            break;
                        }
                        width++;
                    }

                    Max=Math.max(Max,width*flag[i][j]);
                }
            }
        }

        System.out.println(Max);

    }
}

