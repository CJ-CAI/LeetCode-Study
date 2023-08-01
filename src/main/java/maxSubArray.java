public class maxSubArray {

    public static void main(String[] args) {
        int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int pre=-32767,max=-32767;
        for (int num : nums) {
            if(pre+num<num)
                pre=num;
            else
                pre=pre+num;
            max=Math.max(pre,max);
            System.out.println(pre+" "+max);
        }
        System.out.println(max);
    }
}
