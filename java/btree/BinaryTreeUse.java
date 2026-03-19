package btree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {

  public static BinaryTreeNode<Integer> takeInputRecursive(Scanner sc){
    int rootData;
    System.out.println("Enter root data");
    rootData = sc.nextInt();
    if(rootData == -1){
      return null;
    }
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
    root.left = takeInputRecursive(sc);
    root.right = takeInputRecursive(sc);
    return root;
  }

  public static void print(BinaryTreeNode<Integer> root){
    if (root == null){
      return;
    }

    String s  = root.data+": ";
    if(root.left != null){
      s += "L:"+root.left.data+",";
    }

    if(root.right != null){
      s += "R:"+root.right.data;
    }

    System.out.println(s);

    print(root.left);
    print(root.right);
  }

  public static BinaryTreeNode<Integer> takeInputIteratively(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter root child");
    int rootData = sc.nextInt();
    if(rootData == -1){
      return null;
    }
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
    Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
    q.add(root);

    while(!q.isEmpty()){
      BinaryTreeNode<Integer> rootNode = q.poll();

      System.out.println("please enter left node of "+rootNode.data);
      int leftData = sc.nextInt();
      if(leftData != -1) {
        BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<>(leftData);
        rootNode.left = leftNode;
        q.add(leftNode);
      }

      System.out.println("please enter right node of "+rootNode.data);
      int rightData = sc.nextInt();
      if(rightData != -1) {
        BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<>(rightData);
        rootNode.right = rightNode;
        q.add(rightNode);
      }
    }
    return root;
  }



  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
//    BinaryTreeNode<Integer> integerBinaryTree = takeInputRecursive(sc);
    BinaryTreeNode<Integer> integerBinaryTree = takeInputIteratively();
    print(integerBinaryTree);
  }

}
