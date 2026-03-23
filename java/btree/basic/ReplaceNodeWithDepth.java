package btree.basic;

import btree.main.BinaryTreeMain;
import btree.main.BinaryTreeNode;

//For a given a Binary Tree of integers,
// replace each of its data with the depth of the tree.
public class ReplaceNodeWithDepth {

  public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
    changeToDepthTreeHelper(root,0);
  }

  public static void changeToDepthTreeHelper(BinaryTreeNode<Integer> root, int depth){
    if(root == null){
      return;
    }

    root.data = depth;
    changeToDepthTreeHelper(root.left, depth+1);
    changeToDepthTreeHelper(root.right, depth+1);
  }


  static void main() {
    BinaryTreeNode<Integer> inputTree = BinaryTreeMain.takeInputIteratively();
    changeToDepthTree(inputTree);
    BinaryTreeMain.print(inputTree);
  }

}
