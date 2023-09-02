import java.util.HashMap;
import java.util.HashSet;

/**
 * 单数字
 *
 * @author CJ_CA
 * @date 2023/08/18
 */
public class singleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};

       /* HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }
            else {
                set.remove(nums[i]);
            }
        }
        System.out.println(set.iterator().next());*/

        for (int i = 1; i < nums.length; i++) {
            nums[0]^=nums[i];
        }
        System.out.println(nums[0]);
    }
}
