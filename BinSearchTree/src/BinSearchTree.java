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

    public void show(int[] array){
        System.out.print("输入数据为：");
        for(int i = 0;i < array.length;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
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
    public TreeNode treeSearch(int key){
        TreeNode currentNode = root;

        while (currentNode != null) {
            if (currentNode.getValue() == key) {
                return currentNode;
            }
            else if (key < currentNode.getValue()) {
                currentNode = currentNode.getLeft();
            }
            else {
                currentNode = currentNode.getRight();
            }
        }
        return  null;
    }

    //插入
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

    public void treeDelete(TreeNode deleteNode){
        if(deleteNode.getLeft() == null){
            transPlant(deleteNode,deleteNode.getRight());
        }
        else if(deleteNode.getRight() == null){
            transPlant(deleteNode,deleteNode.getLeft());
        }
        else {
            TreeNode successorNode = treeMinium(deleteNode.getRight());

            if (successorNode != deleteNode.getRight()) {
                transPlant(successorNode, successorNode.getRight());
                successorNode.setRight(deleteNode.getRight());
                successorNode.getRight().setParents(successorNode);
                transPlant(deleteNode,successorNode);
                successorNode.setLeft(deleteNode.getLeft());
                successorNode.getLeft().setParents(successorNode);
            }
            else{
                transPlant(deleteNode,successorNode);
                successorNode.setLeft(deleteNode.getLeft());
                successorNode.getLeft().setParents(successorNode);
            }
        }
    }

    public void deleteTheNode(int key){
        TreeNode theDeleteNode = treeSearch(key);
        treeDelete(theDeleteNode);
        showTree();
    }

    public void transPlant(TreeNode originNode,TreeNode transNode){
        //originNode是根节点
        if(originNode.getParents() == null){
            root = transNode;
        }
        else if(originNode == originNode.getParents().getLeft()){
            originNode.getParents().setLeft(transNode);
        }
        else{
            originNode.getParents().setRight(transNode);
        }

        if(transNode != null){
            transNode.setParents(originNode.getParents());
        }

    }

    //找最小关键字元素
    public TreeNode treeMinium(TreeNode currentNode){
        while(currentNode.getLeft() != null){
            currentNode = currentNode.getLeft();
        }
        return currentNode;
    }

    //中序遍历
    public void inOrderTreeWalk(TreeNode currentNode){
        if(currentNode != null){
            inOrderTreeWalk(currentNode.getLeft());
            System.out.print(currentNode.getValue() + " ");
            inOrderTreeWalk(currentNode.getRight());
        }
    }

    public void showTree(){
        System.out.print("按中序遍历输出为：");
        inOrderTreeWalk(root);
    }
}
