import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author CJ_CA
 */
public class largestRectangleAre {
    public static void main(String[] args) {
        int[] heights = new int[]{2,1,2};
        int[] temp = new int[heights.length+2];
        System.arraycopy(heights,0,temp,1,heights.length);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int Max=0;

        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty()&&temp[stack.peek()]>temp[i]){
                int top=stack.poll();
                Max = Math.max(Max, (i - stack.peek()-1) * temp[top]);
            }
            stack.push(i);
        }
        System.out.println(Max);
    }
}
