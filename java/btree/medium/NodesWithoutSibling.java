package btree.medium;
import java.io.*;
import java.util.*;
import btree.main.BinaryTreeMain;
import btree.main.BinaryTreeNode;

/*
    Problem:
    Print all nodes that do NOT have a sibling in a binary tree.

    Example Input:
    1 4 5 6 -1 -1 7 20 30 80 90 -1 -1 -1 -1 -1 -1 -1 -1

    Output:
    6 7

    Key Learning:
    XOR (^) helps check if exactly one child exists.
*/

public class NodesWithoutSibling {

    /*
        Core Logic:
        If exactly one child exists → print that child.
    */
    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        if (root == null) return;

        // XOR: true when exactly one child is present
        if (root.left == null ^ root.right == null) {
            System.out.print(
                (root.left != null ? root.left.data : root.right.data) + " "
            );
        }

        // Always traverse both subtrees
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }

     static void main(String[] args){
        BinaryTreeNode<Integer> root =  BinaryTreeMain.takeInputIteratively();
        printNodesWithoutSibling(root);
    }
}
