import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class merge {
    public static void main(String[] args) {
//        int[][] intervals={{2,6},{1,3},{8,10},{15,18}};
        int[][] intervals={{4,5},{1,4},{0,1}};
        ArrayList<int[]> list = new ArrayList<>();
        //sort
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        for (int i = 0; i < intervals.length; i++) {
            if(list.size()>0&&list.get(list.size()-1)[1]>=intervals[i][0]){
                if(list.get(list.size()-1)[1]<intervals[i][1]){
                    list.get(list.size()-1)[1]=intervals[i][1];
                }
                continue;
            }
            list.add(intervals[i]);
        }
        int[][] result = list.toArray(new int[list.size()][]);
        for (int i = 0; i < intervals.length; i++) {
            System.out.print(Arrays.toString(intervals[i])+" ");
        }
        System.out.println();
        for (int i = 0; i < result.length; i++) {
            System.out.print(Arrays.toString(result[i])+" ");
        }
    }
}
