/**
 * Created by Administrator on 2015/2/22.
 */
public class BinTree {
    int index = 0;
    TreeNode root = null;
    int NULL = Integer.MAX_VALUE;

    BinTree(int[] treeArray){
        root = new TreeNode();
        TreeNode currentNode = root;
        createBinTree(treeArray,currentNode);
        System.out.println();
    }

    public void createBinTree(int[] treeArray,TreeNode currentNode) {
        if (treeArray[index] != NULL) {
            currentNode.setValue(treeArray[index]);
            System.out.print(currentNode.getValue() + " ");
            index++;

            if (treeArray[index] != NULL) {
                TreeNode left = new TreeNode();
                left.setParents(currentNode);//指定左节点的父节点
                currentNode.setLeft(left);
                createBinTree(treeArray, left);
            }
            index++;

            if (treeArray[index] != NULL) {
                TreeNode right = new TreeNode();
                right.setParents(currentNode);
                currentNode.setRight(right);
                createBinTree(treeArray, right);
            }
        }
    }

    //遍历
    public void traverseBinTree(TreeNode currentNode){
        if(currentNode != null){
            System.out.print(currentNode.getValue() + " ");
            traverseBinTree(currentNode.getLeft());
            traverseBinTree(currentNode.getRight());
        }
        else{
            return;
        }
    }

    public void showBinTree(){
        traverseBinTree(root);
    }
}
