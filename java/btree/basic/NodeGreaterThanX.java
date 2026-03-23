package btree.basic;

import java.util.Scanner;
import btree.main.BinaryTreeMain;
import btree.main.BinaryTreeNode;

//For a given a binary tree of integers and an integer X,
// find and return the total number of nodes of the given binary tree
// which are having data greater than X.
public class NodeGreaterThanX {

  public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
    if (root == null) {
      return 0;
    }

    int ans = 0;
    if (root.data > x) {
      ans = 1;
    }

    ans += countNodesGreaterThanX(root.left, x);
    ans += countNodesGreaterThanX(root.right, x);

    return ans;
  }


  static void main() {
    BinaryTreeNode<Integer> inputTree = BinaryTreeMain.takeInputIteratively();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter x value: ");
    int x  = sc.nextInt();
    System.out.println(countNodesGreaterThanX(inputTree,x));
  }

}
