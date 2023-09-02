import java.util.Arrays;
import java.util.Random;

/**
 * 数组中的第K个最大元素
 *
 * @author CJ_CA
 * @date 2023/08/30
 * 荷兰国旗算法
 * 荷兰国旗算法同样可以解决单次分区（partition）问题，其优点是在有重复元素的情况下，能一次确定pivot所有重复元素的位置，
 * 这样每次能固定到最终位置的元素从一个变成了所有相同元素，只要目标位置n-k在确定的范围内，则代表搜索成功
 *
 */
public class findKthLargest {
    public static void main(String[] args) {
        int[] ints = new int[]{3, 1, 2, 4};
        findKthLargest findKthLargest = new findKthLargest();
        findKthLargest.find(ints, 2);
        System.out.println(Arrays.toString(ints));
    }
    public int find(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left=0,right=nums.length,target=nums.length-k;

        while (left<right) {
            int[] repeat = partition(nums, left, right);
            if(repeat[0] <= target && repeat[1] >= target) {
                return nums[nums.length-k];
            }
            if(repeat[1]<target){
                left=repeat[1]+1;
            }
            else{
                right=repeat[0];
            }
        }
        return -1;
    }

    /**
     * 提高速度，命中率
     */
    Random rand = new Random();

    public  int[] partition(int[] arr, int left, int right) {
        int sample = arr[rand.nextInt(right-left)+left];
        int repeat_left = left;
        int repeat_right = right-1;
        while (left<=repeat_right){
            if(arr[left]<sample){
                swap(arr, repeat_left++, left++);
            }
            else if (arr[left]>sample ) {
                //与后面的值交换不需要left++,避免交替更大的值过来
                swap(arr,repeat_right--,left);
            }else {
                left++;
            }
        }
        return new int[]{repeat_left,repeat_right};
    }

    public  void swap(int[] arr, int left, int right) {
        if (left != right) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }
    }
}
