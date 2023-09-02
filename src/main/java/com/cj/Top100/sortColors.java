import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class sortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        int index=0,temp;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                temp=nums[index];
                nums[index++]=nums[i];
                nums[i]=temp;
            }
        }
        for (int i = index; i < nums.length; i++) {
            if(nums[i]==1){
                temp=nums[index];
                nums[index++]=nums[i];
                nums[i]=temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
