/**
 * Created by Administrator on 2015/2/24.
 */
public class Main {
    public static void main(String[] args){
        int[] array = new int[] {10,22,27,24,14,25,19,7,21,13,26};

        RedBlackTree rbTree = new RedBlackTree(array);
        rbTree.show(array);
        rbTree.showTree();
    }
}
