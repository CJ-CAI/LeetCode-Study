public class uniquePaths {
    private static long counts=0;
    private static int m,n;
    public static void main(String[] args) {
        counts=0;
        m=45;n=9;//m>45递归超出时间限制
        move(1,1);
        System.out.println(counts);
    }
    public static void move(int x,int y){
        if(x==m&&y==n){
            counts++;
            return;
        }
        if (x<m)
            move(x+1,y);
        if(y<n)
            move(x,y+1);
    }
}
