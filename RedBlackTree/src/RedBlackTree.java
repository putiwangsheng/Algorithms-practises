/**
 * Created by Administrator on 2015/2/24.
 */
public class RedBlackTree {
    private int index = 0;
    private TreeNode root = null;
    private TreeNode nullNode = null;

    RedBlackTree(int[] treeArray){
        root = new TreeNode();
        TreeNode currentNode = root;
        nullNode = new TreeNode();
        createTree(treeArray, currentNode);
    }

    public void show(int[] treeArray){
        System.out.print("输入数据为：");
        for(int i = 0;i < treeArray.length;i++){
            System.out.print(treeArray[i] + " ");
        }
    }

    public TreeNode setNullNode(TreeNode currentNode){
        if(currentNode == null){
            currentNode = nullNode;
            currentNode.setLeft(nullNode);
            currentNode.setRight(nullNode);

            if(currentNode.getParent() == null){
                currentNode.setParent(nullNode);
            }
            return currentNode;
        }

        else {
            if (currentNode.getParent() == null) {
                currentNode.setParent(nullNode);
            }

            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                currentNode.setLeft(nullNode);
                currentNode.setRight(nullNode);
            }
            return currentNode;
        }
    }

    public void createTree(int[] treeArray,TreeNode currentNode){
        currentNode.setValue(treeArray[0]);
        currentNode.setColor("BLACK");
        index = index + 1;

        while(index < treeArray.length){
            RedBlackTreeInsert(treeArray,root);
            index++;
        }
    }

    public void RedBlackTreeInsert(int[] treeArray,TreeNode currentNode){
        TreeNode insertNode = new TreeNode();
        TreeNode currentParent = nullNode;
        insertNode.setValue(treeArray[index]);

        while(currentNode != nullNode){
            currentParent = currentNode;

            if(insertNode.getValue() < currentNode.getValue()){
                currentNode = currentParent.getLeft();
            }
            else{
                currentNode = currentParent.getRight();
            }

            currentNode = setNullNode(currentNode);
        }

        insertNode.setParent(currentParent);

        if(currentParent == nullNode){
            root = insertNode;
        }
        else if(insertNode.getValue() < currentParent.getValue()){
            currentParent.setLeft(insertNode);
        }
        else{
            currentParent.setRight(insertNode);
        }

        insertNode.setLeft(nullNode);
        insertNode.setRight(nullNode);
        insertNode.setColor("RED");

        rbInsertFixUp(insertNode);
    }

    public void rbInsertFixUp(TreeNode currentNode){
        while(currentNode.getParent().getColor() == "RED"){
            if(currentNode.getParent() == currentNode.getParent().getParent().getLeft()){
                TreeNode uncleNode = currentNode.getParent().getParent().getRight();
                uncleNode = setNullNode(uncleNode);

                if(uncleNode.getColor() == "RED"){
                    currentNode.getParent().setColor("BLACK");
                    uncleNode.setColor("BLACK");
                    currentNode.getParent().getParent().setColor("RED");
                    currentNode = currentNode.getParent().getParent();
                }
                else if (currentNode == currentNode.getParent().getRight()) {
                    currentNode = currentNode.getParent();
                    leftRotate(currentNode);
                }
                else {
                    currentNode.getParent().setColor("BLACK");
                    currentNode.getParent().getParent().setColor("RED");
                    rightRotate(currentNode.getParent().getParent());
                }

            }

            else{
                TreeNode uncleNode = currentNode.getParent().getParent().getLeft();
                uncleNode = setNullNode(uncleNode);

                if(uncleNode.getColor() == "RED"){
                    currentNode.getParent().setColor("BLACK");
                    uncleNode.setColor("BLACK");
                    currentNode.getParent().getParent().setColor("RED");
                    currentNode = currentNode.getParent().getParent();
                }
                else if(currentNode == currentNode.getParent().getLeft()){
                    currentNode = currentNode.getParent();
                    rightRotate(currentNode);
                }
                else {
                    currentNode.getParent().setColor("BLACK");
                    currentNode.getParent().getParent().setColor("RED");
                    leftRotate(currentNode.getParent().getParent());
                }
            }
            root.setColor("BLACK");
            currentNode = setNullNode(currentNode);
        }
    }

    public void leftRotate(TreeNode rotateNode){
        TreeNode rightNode = rotateNode.getRight();
        rotateNode.setRight(rightNode.getLeft());
        rightNode = setNullNode(rightNode);

        if(rightNode.getLeft() != nullNode){
            rightNode.getLeft().setParent(rotateNode);
        }
        rightNode.setParent(rotateNode.getParent());

        rotateNode = setNullNode(rotateNode);
        if(rotateNode.getParent() == nullNode){
            root = rightNode;
        }
        else if(rotateNode == rotateNode.getParent().getLeft()){
            rotateNode.getParent().setLeft(rightNode);
        }
        else{
            rotateNode.getParent().setRight(rightNode);
        }

        rightNode.setLeft(rotateNode);
        rotateNode.setParent(rightNode);
    }

    public void rightRotate(TreeNode rotateNode){
        TreeNode leftNode = rotateNode.getLeft();
        rotateNode.setLeft(leftNode.getRight());
        leftNode = setNullNode(leftNode);

        if(leftNode.getRight() != nullNode){
            leftNode.getRight().setParent(rotateNode);
        }
        leftNode.setParent(rotateNode.getParent());

        rotateNode = setNullNode(rotateNode);
        if(rotateNode.getParent() == nullNode){
            root = leftNode;
        }
        else if(rotateNode == rotateNode.getParent().getLeft()){
            rotateNode.getParent().setLeft(leftNode);
        }
        else{
            rotateNode.getParent().setRight(leftNode);
        }

        leftNode.setRight(rotateNode);
        rotateNode.setParent(leftNode);
    }

    public void inOrderTreeWalk(TreeNode currentNode){
        currentNode = setNullNode(currentNode);

        if(currentNode != nullNode){
            inOrderTreeWalk(currentNode.getLeft());
            System.out.print(currentNode.getValue() + " ");
            inOrderTreeWalk(currentNode.getRight());
        }
    }

    public void showTree(){
        System.out.print("\n按中序遍历输出为：");
        inOrderTreeWalk(root);
    }
}
