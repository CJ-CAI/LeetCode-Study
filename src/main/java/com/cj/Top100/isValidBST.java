import com.cj.utils.TreeNode;

/**
 * 是有效二叉搜索树
 *
 * @author CJ_CA
 * @date 2023/08/14
 */
public class isValidBST {
    static TreeNode root = new TreeNode(1);
    static TreeNode root_r = new TreeNode(5);

    static {
        root.right = root_r;
        root_r.left = new TreeNode(4);
    }

    /**
     * 通过pre递归中序判断是否为一个递增数据
     */
    static long pre=Long.MIN_VALUE;
    public static void main(String[] args) {
        System.out.println(isValid(root));
    }
    public static Boolean isValid(TreeNode treeNode){
            if(treeNode==null){
                return true;
            }
            if(isValid(treeNode.left)){
                if (treeNode.val>pre){
                    pre=treeNode.val;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
           return isValid(treeNode.right);
    }
}
