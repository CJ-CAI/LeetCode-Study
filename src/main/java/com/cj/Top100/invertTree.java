import com.cj.utils.TreeNode;

/**
 * @author CJ_CA
 * @date 2023/09/01
 */
public class invertTree {
    static TreeNode root = new TreeNode(4);
    static TreeNode root_r = new TreeNode(7);
    static TreeNode root_l = new TreeNode(2);

    static {
        root.left=root_l;
        root_l.left=new TreeNode(1);
        root_l.right=new TreeNode(3);
        root.right = root_r;
        root_r.left = new TreeNode(6);
        root_r.right = new TreeNode(8);
    }

    public static void main(String[] args) {
        invert(root);
        inorderTraversal.PrintInorder(inorderTraversal.getInorder(root));
    }
    public static void invert(TreeNode root){
        if(root==null) {
            return;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invert(root.left);
        invert(root.right);
    }
}
