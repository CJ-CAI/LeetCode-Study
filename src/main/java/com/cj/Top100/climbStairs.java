public class climbStairs {
    public static void main(String[] args) {
        int n=3;
        if(n<3){
            System.out.println(n);
        }
        int[] steps = new int[n];
        steps[0]=1;
        steps[1]=2;
        for (int i = 2; i < n; i++) {
            steps[i]=steps[i-1]+steps[i-2];
        }
        System.out.println(steps[n-1]);
    }
}
