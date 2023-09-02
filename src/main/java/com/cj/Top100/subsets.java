import java.util.ArrayList;
import java.util.List;

public class subsets {
    static List<List<Integer>> results;

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3,4};
        results = new ArrayList<>();
        results.add(new ArrayList<>());

        for (int i = 1; i <= nums.length; i++) {
            add(nums, i, 0, new ArrayList<Integer>());
        }

        results.forEach(list -> {
            list.forEach(v -> {
                System.out.print(v + " ");
            });
            System.out.println();
        });
    }

    public static void add(int[] nums, int length, int index, ArrayList<Integer> list) {
        for (int i = index;nums.length - i >= length; i++) {
            list.add(nums[i]);
            if (length == 1) {
                results.add(new ArrayList<>(list));
            } else {
                add(nums, length - 1, i+1, list);
            }
            list.remove(list.size() - 1);
        }
    }
}
