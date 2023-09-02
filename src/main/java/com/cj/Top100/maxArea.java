public class maxArea {
    public static void main(String[] args) {
        int[] height=new int[]{1,8,6,2,5,4,8,3,7};
        int left=0,right=height.length-1,sum=0;
        while (true){
            if (left==right)
                break;
            else if(height[left]<height[right]){
                sum=Math.max(sum,height[left]*(right-left));
                left++;
            }
            else {
                sum = Math.max(sum, height[right] * (right - left));
                right--;
            }
        }
        System.out.println(sum);
    }
}
