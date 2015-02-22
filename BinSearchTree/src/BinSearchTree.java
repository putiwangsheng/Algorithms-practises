/**
 * Created by Administrator on 2015/2/22.
 */
public class BinSearchTree {
    private int index = 0;
    private TreeNode root = null;

    BinSearchTree(int[] treeArray){
        root = new TreeNode();
        TreeNode currentNode = root;
        createTree(treeArray,currentNode);
    }

    public void createTree(int[] treeArray,TreeNode currentNode) {
        currentNode.setValue(treeArray[0]);
        index = index + 1;

        while (index < treeArray.length) {
            treeInsert(treeArray, currentNode);
            index++;
        }
    }

    //查找具有给定关键字的节点
    public TreeNode treeSearch(TreeNode currentNode,int key){
        if(currentNode == null || currentNode.getValue() == key){
            return currentNode;
        }
        if(key < currentNode.getValue()){
            treeSearch(currentNode.getLeft(),key);
        }
        else{
            treeSearch(currentNode.getRight(),key);
        }
        return null;
    }

    public void treeInsert(int[] treeArray,TreeNode currentNode) {
        TreeNode insertNode = new TreeNode();
        TreeNode currentParent = null;
        insertNode.setValue(treeArray[index]);

        while (currentNode != null) {
            currentParent = currentNode;

            if (insertNode.getValue() < currentNode.getValue()) {
                currentNode = currentNode.getLeft();
            }
            else {
                currentNode = currentNode.getRight();
            }

        }
        //currentNode为null时
        insertNode.setParents(currentParent);
        if(currentParent == null){
            root = insertNode;//树为空
        }
        else if(insertNode.getValue() < currentParent.getValue()){
            currentParent.setLeft(insertNode);
        }
        else{
            currentParent.setRight(insertNode);
        }
    }

    //中序遍历
    public void inorderTreeWalk(TreeNode currentNode){
        if(currentNode != null){
            inorderTreeWalk(currentNode.getLeft());
            System.out.print(currentNode.getValue() + " ");
            inorderTreeWalk(currentNode.getRight());
        }
    }

    public void show(int[] array){
        System.out.print("输入数据为：");
        for(int i = 0;i < array.length;i++){
            System.out.print(array[i] + " ");
        }
    }

    public void showTree(){
        System.out.print("\n按中序遍历输出为：");
        inorderTreeWalk(root);
    }
}
