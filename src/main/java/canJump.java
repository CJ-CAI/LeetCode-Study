public class canJump {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        int sum=0,i=0;
        for (; i < nums.length&&sum<nums.length-1&&!(i+nums[i]==i&&sum==i); i++) {
            if(i+nums[i]>sum)
                sum=i+nums[i];
        }
        System.out.println(i);
        if(sum>nums.length-2)
            System.out.println(true+"sum:"+sum);
        else
            System.out.println(false+"sum:"+sum);
    }
}
