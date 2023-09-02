import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0};
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length && nums[first] <= 0; first++) {
            if ((first > 0 && nums[first] == nums[first - 1]))
                continue;
            int third = nums.length - 1;
            for (int second = first + 1; second < nums.length && nums[second] <= -nums[first]; second++) {
                if (second - 1 > first && nums[second] == nums[second - 1])
                    continue;
                while (nums[second] + nums[third] > -nums[first] && third > second)
                    third--;                                                //重点左右减少
                if (second == third)
                    break;
                if (nums[second] + nums[third] == -nums[first]) {
                    List<Integer> sum = new ArrayList<Integer>();
                    sum.add(nums[first]);
                    sum.add(nums[second]);
                    sum.add(nums[third]);
                    listList.add(sum);
                }
            }
        }

        for (List<Integer> integers : listList) {
            System.out.println(integers);
        }
    }
}
