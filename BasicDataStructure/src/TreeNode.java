/**
 * Created by Administrator on 2015/2/22.
 */
public class TreeNode {
    private int value = 0;
    private TreeNode parents = null;
    private TreeNode left = null;
    private TreeNode right = null;

    public void setValue(int value) {
        this.value = value;
    }

    public void setParents(TreeNode parents) {
        this.parents = parents;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getParents() {
        return parents;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
