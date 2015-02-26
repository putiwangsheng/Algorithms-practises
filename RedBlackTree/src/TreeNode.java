/**
 * Created by Administrator on 2015/2/24.
 */
public class TreeNode {
    private int value = 0;
    private String color = "0";
    private TreeNode parent = null;
    private TreeNode left = null;
    private TreeNode right = null;

    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public TreeNode getParent() {
        return parent;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
