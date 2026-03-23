package btree.basic;

import btree.main.BinaryTreeNode;

/**
 * Utility class to compute properties of a Binary Tree.
 */
public class HeightBinaryTree {

  /**
   * Calculates the height of a binary tree.
   * Definition:
   * Height = Number of nodes in the longest path
   *          from root to any leaf node.
   * --------------------------------------------------
   * TIME COMPLEXITY:
   * --------------------------------------------------
   * O(n) → Every node is visited once
   * --------------------------------------------------
   * SPACE COMPLEXITY:
   * --------------------------------------------------
   * O(h) → Recursion stack (h = tree height)
   * Worst case (skewed tree): O(n)
   * Best case (balanced tree): O(log n)
   * --------------------------------------------------
   * INTUITION (1-LINER):
   * --------------------------------------------------
   * "Height = 1 + maximum height of its children"
   * --------------------------------------------------
   *
   * @param root Root node of the binary tree
   * @return Height of the tree
   */
  public static int height(BinaryTreeNode<Integer> root) {
    // Base case: empty tree
    if (root == null) {
      return 0;
    }

    // Recursive case:
    // 1 + max height of left and right subtree
    return 1 + Math.max(height(root.left), height(root.right));
  }
}