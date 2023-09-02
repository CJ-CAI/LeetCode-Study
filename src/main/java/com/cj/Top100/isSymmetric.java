import com.cj.utils.TreeNode;

/**
 * 对称二叉树
 *
 * @author CJ_CA
 * @date 2023/08/15
 */
public class isSymmetric{
        static TreeNode root = new TreeNode(1);
        static TreeNode root_r = new TreeNode(2);
        static TreeNode root_l = new TreeNode(2);
        static {
            root.right = root_r;
            root.left = root_l;
            root_r.right = new TreeNode(3);
            root_l.left = new TreeNode(3);
        }
    public static void main(String[] args) {

        System.out.println(Verify(root.left, root.right));

    }
    public static boolean Verify(TreeNode left,TreeNode right){
        if(left==null&&right==null) {
            return true;
        }
        if(left==null||right==null||left.val!=right.val) {
            return false;
        }
        return Verify(left.left,right.right)&&Verify(left.right,right.left);

    }
}