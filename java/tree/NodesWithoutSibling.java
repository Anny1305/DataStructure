package tree;
import java.io.*;
import java.util.*;

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
        Binary Tree Node Definition
    */
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        BinaryTreeNode(T data) {
            this.data = data;
        }
    }

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

    /*
        Level Order Tree Input
        -1 represents NULL
    */
    public static BinaryTreeNode<Integer> takeInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nodeData = br.readLine().trim().split(" ");

        if (nodeData.length == 0 || nodeData[0].equals("-1"))
            return null;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

        BinaryTreeNode<Integer> root =
                new BinaryTreeNode<>(Integer.parseInt(nodeData[0]));

        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < nodeData.length) {

            BinaryTreeNode<Integer> current = queue.poll();

            // Left child
            if (!nodeData[i].equals("-1")) {
                current.left = new BinaryTreeNode<>(
                        Integer.parseInt(nodeData[i])
                );
                queue.add(current.left);
            }
            i++;

            if (i >= nodeData.length) break;

            // Right child
            if (!nodeData[i].equals("-1")) {
                current.right = new BinaryTreeNode<>(
                        Integer.parseInt(nodeData[i])
                );
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BinaryTreeNode<Integer> root = takeInput();
        printNodesWithoutSibling(root);
    }
}
