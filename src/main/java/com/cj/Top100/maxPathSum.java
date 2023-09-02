import com.cj.utils.TreeNode;

/**
 * 二叉树中的最大路径和
 *
 * @author CJ_CA
 * @date 2023/08/18
 */
public class maxPathSum {
    static TreeNode root = new TreeNode(-10);
    static TreeNode root_r = new TreeNode(20);
    static TreeNode root_l = new TreeNode(9);

    static {
        root.right = root_r;
        root.left = root_l;
        root_r.right = new TreeNode(15);
        root_r.left = new TreeNode(7);
    }
    static int MaxSum=Integer.MIN_VALUE;

    public static void main(String[] args) {
        PathSum(root);
        System.out.println(MaxSum);
    }
    public static int PathSum(TreeNode treeNode){
        if(treeNode==null) {
            return 0;
        }
        //如果是<0就没必要加了
        int leftSum=Math.max(PathSum(treeNode.left),0);
        int rightSum=Math.max(PathSum(treeNode.right),0);
        MaxSum=Math.max(MaxSum,treeNode.val+leftSum+rightSum);
        return treeNode.val+Math.max(leftSum,rightSum);
    }
}
