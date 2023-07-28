import java.util.Arrays;

public class nextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{ 5,1, 1};
//        System.out.println(Arrays.toString(nums));

        int left = nums.length - 1, right = nums.length - 1,temp;
        for (; left > 0 && nums[left] <= nums[left - 1]; left--) ;
        left -= 1;
        while (left > -1 && right > left) {
            if (nums[right] > nums[left])
                break;
            right--;
        }


        //swap
        if (left != -1) {
            temp= nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        //sort
        left += 1;
        right = nums.length - 1;
        while (left != right && right - left != -1) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(nums));

    }
}
