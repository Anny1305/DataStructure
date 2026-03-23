package btree.basic;

import java.util.Scanner;
import btree.main.BinaryTreeMain;
import btree.main.BinaryTreeNode;

//For a given a binary tree of integers and an integer X,
// find and return the total number of nodes of the given binary tree
// which are having data greater than X.
public class NodeAtDepthK {

  public static void nodesAtDepthK(BinaryTreeNode<Integer> root, int k) {
    if(root == null){
      return;
    }

    if (k == 0){
      System.out.print(root.data+ " ");
      return;
    }
    nodesAtDepthK(root.left, k-1);
    nodesAtDepthK(root.right, k-1);
  }


  static void main() {
    BinaryTreeNode<Integer> inputTree = BinaryTreeMain.takeInputIteratively();
    Scanner sc = new Scanner(System.in);
    System.out.println("enter the depth at which you want to print node");
    int k = sc.nextInt();
    nodesAtDepthK(inputTree,k);
  }

}
