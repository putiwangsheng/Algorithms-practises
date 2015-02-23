import java.util.Scanner;

/**
 * Created by Administrator on 2015/2/22.
 */
public class Main {
    public static void main(String[] args){
        int[] array = new int[]{12,4,8,3,5,15,13,17};
        Scanner input = new Scanner(System.in);

        BinSearchTree binSearchTree = new BinSearchTree(array);
        binSearchTree.show(array);
        binSearchTree.showTree();

        System.out.print("\nPlease input the delete number:");
        int key = input.nextInt();
        binSearchTree.deleteTheNode(key);
    }
}
