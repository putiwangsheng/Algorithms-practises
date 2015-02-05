import sun.reflect.generics.tree.Tree;

/**
 * Created by Administrator on 2015/2/4.
 */
public class NormalTree {
    int index = 0;
    TreeNode root = null;
    final int NULL = Integer.MAX_VALUE;

    NormalTree(int[] treeArray){
        root = new TreeNode();
        TreeNode currentNode = root;
        createNormalTree(treeArray,currentNode);
        System.out.println();

    }

    public void createNormalTree(int[] treeArray,TreeNode currentNode) {
        if (treeArray[index] != NULL) {
            currentNode.setValue(treeArray[index]);
            System.out.print(treeArray[index] + " ");
            index++;

            if (treeArray[index] != NULL) {
                TreeNode leftChild = new TreeNode();
                leftChild.setParents(currentNode);
                currentNode.setLeft(leftChild);
                createNormalTree(treeArray, leftChild);
            }

            index++;

            if (index < treeArray.length && treeArray[index] != NULL) {
                TreeNode rightBrother = new TreeNode();
                rightBrother.setParents(currentNode);
                currentNode.setRight(rightBrother);
                createNormalTree(treeArray, rightBrother);
            }
        }

    }

    public void traverseNormalTree(TreeNode currentNode){
        if(currentNode != null){
            System.out.print(currentNode.getValue() + " ");
            traverseNormalTree(currentNode.getLeft());
            traverseNormalTree(currentNode.getRight());
        }
        else{
            return;
        }
    }

    public void showNormalTree(){
        traverseNormalTree(root);
    }
}
