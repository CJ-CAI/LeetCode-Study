import com.cj.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 层序遍
 *
 * @author CJ_CA
 * @date 2023/08/15
 */
public class levelOrder {
    static TreeNode root = new TreeNode(1);
    static TreeNode root_r = new TreeNode(2);
    static TreeNode root_l = new TreeNode(2);

    static {
        root.right = root_r;
        root.left = root_l;
        root_r.right = new TreeNode(3);
        root_l.left = new TreeNode(3);
    }

    static List<List<Integer>> result;

    public static void main(String[] args) {
        result = new ArrayList<>();
        LevelSort(root, 0);
        result.forEach(list -> {
            list.forEach(v -> {
                System.out.print(v + " ");
            });
            System.out.println();
        });
    }

    public static void LevelSort(TreeNode treeNode, int level) {
        if(treeNode==null) {
            return;
        }
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(treeNode.val);
        LevelSort(treeNode.left, level + 1);
        LevelSort(treeNode.right, level + 1);
    }
}
