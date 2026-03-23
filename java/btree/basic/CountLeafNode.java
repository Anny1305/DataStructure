package btree.basic;

import btree.main.BinaryTreeMain;
import btree.main.BinaryTreeNode;

public class CountLeafNode {

  private static int countLeafNode(BinaryTreeNode<Integer> root){
    if(root == null){
      return 0;
    }

    if(root.left == null || root.right == null){
      return 1;
    }


   return countLeafNode(root.left) + countLeafNode(root.right);
  }



  static void main() {
    BinaryTreeNode<Integer> integerBinaryTreeNode = BinaryTreeMain.takeInputIteratively();
    System.out.println(countLeafNode(integerBinaryTreeNode));
  }
}
