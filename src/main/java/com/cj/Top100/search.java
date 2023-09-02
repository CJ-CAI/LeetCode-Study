public class search {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 2, 3, 4};//count=7  mid=3
        int target = 1;
        int left = 0, right = nums.length - 1;
        int mid;
        int target_index = -1;

        if (nums.length== 1) {
            target_index=nums[0] == target ? 0 : -1;
        }

        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] == target) {
                target_index = mid;
                break;
            }
            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[nums.length-1])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        System.out.println(target_index);
    }
}
