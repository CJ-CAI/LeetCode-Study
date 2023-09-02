import java.util.Arrays;

/**
 * 最长递增子序列
 *
 * @author CJ_CA
 * @date 2023/08/24
 */
public class lengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {99,100,101,1,2};
        int[] sort = new int[nums.length];
        int count=0;

        for (int num : nums) {
            int j=count,i=0;
            //二分查找到正确的位置
            while (i<j){
                int m=(i+j)/2;
                if(sort[m]<num){
                    i=m+1;
                }
                else{
                    j=m;
                }
            }

            sort[i]=num;
            if(j==count){
                count++;
            }
        }

        System.out.println(Arrays.toString(sort));
    }
}
