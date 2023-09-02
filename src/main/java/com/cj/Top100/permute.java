import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permute {
    static List<List<Integer>> result=new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        match(nums,0,new ArrayList<>());
        result.forEach(list -> {
            list.forEach(item-> System.out.print(item+" "));
            System.out.println();
        });
    }
    public static void match(int[] nums,int index,ArrayList<Integer> list){
        int start,temp;
        if(index== nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(start=index;index<nums.length;index++){
            if(start!=index) {
                temp = nums[index];
                nums[index] = nums[start];
                nums[start] = temp;
            }

            list.add(nums[start]);
            match(nums,start+1,list);

            if(start!=index) {                      //交换了需要再交换回去
                temp = nums[index];
                nums[index] = nums[start];
                nums[start] = temp;
            }
            list.remove(list.size()-1);
        }

    }
}
