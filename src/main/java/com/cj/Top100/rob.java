/**
 * 罗伯
 *
 * @author CJ_CA
 * @date 2023/08/24
 */
public class rob {
    //当前最大金额=不偷(n-1)>偷(n-2+n)?不偷(n-1):偷(n-2+n)
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        if(nums==null){
            System.out.println(0);
        }
        if (nums.length==1){
            System.out.println(nums[0]);
        }
        int first=nums[0];
        int second=nums[1]>nums[0]?nums[1]:nums[0];

        for (int i = 2; i < nums.length; i++) {
            int temp=second;
            second=first+nums[i]>second?first+nums[i]:second;
            first=temp;
        }
        System.out.println(second);
    }
}
