import java.util.Arrays;

public class searchRange {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2};
        int target=1;
        int[] result = new int[2];

        int left=0,right=nums.length-1,mid;
        while (right>=left){
            mid=(left+right)/2;
            if(nums[mid]==target){
                for (left=mid-1;left>-1&&nums[left]==target;left--);
                for (right=mid+1;right<nums.length&&nums[right]==target;right++);
                result[0]=left+1;
                result[1]=right-1;
                break;
            }
            if(target>=nums[left]&&target<=nums[mid]){
                right=mid-1;
            } else if (target>nums[mid]&&target<=nums[right]) {
                left=mid+1;
            }
            else{
                result[0]=-1;
                result[1]=-1;
                break;
            }
        }
        if(right<=left){
            result[0]=-1;
            result[1]=-1;
        }
        System.out.println(Arrays.toString(result));
    }
}
