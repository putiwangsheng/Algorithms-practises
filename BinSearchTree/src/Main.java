/**
 * Created by Administrator on 2015/2/22.
 */
public class Main {
    public static void main(String[] args){
        int[] array = new int[]{12,4,5,3,8,15,13,17};

        BinSearchTree binSearchTree = new BinSearchTree(array);
        binSearchTree.show(array);
        binSearchTree.showTree();
    }
}
