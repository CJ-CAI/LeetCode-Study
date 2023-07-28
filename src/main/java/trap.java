public class trap {
    public static void main(String[] args) {
        int[] height = new int[]{4,2,0,3,2,5};
        int left_max=0,right_max=0,sum=0;
        for (int i = 0; i < height.length; i++) {
            sum-=height[i];
            if(height[i]>left_max){
                sum-=i*(height[i]-left_max);
                left_max=height[i];
            }
        }

        for (int i = height.length-1; ; i--) {
            if(height[i]>right_max){
                sum-=(height.length-i-1)*(height[i]-right_max);
                right_max=height[i];
            }
            if(height[i] ==left_max)
                break;
        }
        sum=height.length*left_max+sum;
        System.out.println(sum);
    }
}
