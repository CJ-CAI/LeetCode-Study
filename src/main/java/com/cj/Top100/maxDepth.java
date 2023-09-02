import com.cj.utils.TreeNode;

/**
 * 最大深度
 *
 * @author CJ_CA
 * @date 2023/08/15
 */
public class maxDepth {
    static TreeNode root = new TreeNode(1);
    static TreeNode root_r = new TreeNode(2);
    static TreeNode root_l = new TreeNode(2);

    static {
        root.right = root_r;
        root.left = root_l;
        root_r.right = new TreeNode(3);
        root_l.left = new TreeNode(3);
    }
    static int max;

    public static void main(String[] args) {
        max=0;
        search(root,0);
        System.out.println(max);
    }
    public static void search(TreeNode treeNode,int level){
        if(treeNode==null){
            max=Math.max(max,level);
            return;
        }
        search(treeNode.left,level+1);
        search(treeNode.right,level+1);
    }
}
