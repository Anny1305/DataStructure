package btree.basic;

import btree.main.BinaryTreeMain;
import btree.main.BinaryTreeNode;

public class LargestNode {

  public static int largest(BinaryTreeNode<Integer> root) {
    if (root == null) {
      return -1;
    }

    int leftLargest = largest(root.left);
    int rightLargest = largest(root.right);
    return Math.max(root.data, Math.max(leftLargest, rightLargest));
  }

  static void main() {
    BinaryTreeNode<Integer> bNode = BinaryTreeMain.takeInputIteratively();
    System.out.print("largest is : " + largest(bNode));
  }
}
