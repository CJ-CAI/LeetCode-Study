import java.util.HashMap;
import java.util.HashSet;

public class majorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int cand_num = nums[0], count = 1;

        /*“多数元素”的个数: >n/2，其余元素的个数总和: <= n/2
        (>n/2) - (<=n/2) = (>=1)*/
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i]) {
                ++count;
            } else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        System.out.println(cand_num);

    }
}
