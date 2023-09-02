import java.util.Arrays;
import java.util.Map;

/**
 * 最长连续
 *
 * @author CJ_CA
 * @date 2023/08/18
 */
public class longestConsecutive {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0,1};
        if(nums.length==0) {
            System.out.println(0);
        }
        Arrays.sort(nums);
        int Max=0,temp=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]+1){
                temp++;
            } else if (nums[i]==nums[i-1]) {
                continue;
            } else {
                Max=Math.max(Max,temp);
                temp=1;
            }
        }
        Max=Math.max(Max,temp);
        System.out.println(Max);
    }
}
