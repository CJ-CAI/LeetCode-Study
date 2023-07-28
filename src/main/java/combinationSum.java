import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
    static List<List<Integer>> result = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        int[] candidates = new int[]{4,2,8};
        int target = 8;
        SumMatch(target, candidates, new ArrayList<>(),0);
        result.forEach(list -> {
            list.forEach(item-> System.out.print(item+" "));
            System.out.println();
        });
    }

    public static void SumMatch(int target, int[] candidates, List<Integer> list_prev,int index) {
        //传递index用于防止匹配前面的，造成重复
        /*for (;index<candidates.length;index++) {
            List<Integer> list = new ArrayList<>(); //避免弱引用带来的问题
            list.addAll(list_prev);
            if (target - candidates[index] == 0) {
                list.add(candidates[index]);        // 有弱引用问题
                result.add(list);
            }
            if (target - candidates[index] > 0) {
                list.add(candidates[index]);
                SumMatch(target - candidates[index], candidates, list,index);
            }
        }*/

        if(index==candidates.length)
            return;
        if(target==0){
            result.add(new ArrayList<>(list_prev));//避免弱引用
            return;
        }
        SumMatch(target,candidates,list_prev,index+1);
        if(target-candidates[index]>=0){
            list_prev.add(candidates[index]);
            SumMatch(target-candidates[index],candidates,list_prev,index);
            list_prev.remove(list_prev.size()-1);//不管下个匹配成不成功都应该删除掉
        }
    }
}
