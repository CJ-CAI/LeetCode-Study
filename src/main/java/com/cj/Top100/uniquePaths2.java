public class uniquePaths2 {
    public static void main(String[] args) {
        int m=51,n=9;
        int[][] ints = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||j==0)
                    ints[i][j]=1;
                else {
                    ints[i][j]=ints[i-1][j]+ints[i][j-1];
                }
            }
        }
        System.out.println(ints[m-1][n-1]);
    }
}
