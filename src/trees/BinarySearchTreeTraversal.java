package src.trees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Class that contains methods to traverse a binary search tree.
 */
public class BinarySearchTreeTraversal {

    // Given a binary search tree in which each node has a parent pointer, perform an inorder traversal withou
    // recursion, and without allocating any memory.

    public static void inorderTraversalWithRecursion(final BSTNode root) {
        inorderTraversalWithRecursionHelper(root);
        System.out.println("");
    }

    private static void inorderTraversalWithRecursionHelper(final BSTNode root) {
        if (root == null) {
            return;
        }

        inorderTraversalWithoutRecursion(root.left);
        System.out.print(root.value + " ");
        inorderTraversalWithRecursionHelper(root.right);
    }

    public static void inorderTraversalWithoutRecursion(final BSTNode root) {
        final Deque<BSTNode> nodeStack = new ArrayDeque<>();
        BSTNode current = root;

        // save all the left nodes on the stack
        while (current != null) {
            nodeStack.push(current);
            current = current.left;
        }

        while (!nodeStack.isEmpty()) {
            current = nodeStack.pop();
            System.out.print(current.value + " ");

            current = current.right;
            if (current != null) {
                nodeStack.push(current);
            }
        }

        System.out.println("");
    }

    public static void main(final String[] args) {
        final BSTNode root = new BSTNode(5);
        root.left = new BSTNode(3);
        root.left.left = new BSTNode(2);
        root.left.right = new BSTNode(4);
        root.right = new BSTNode(6);
        root.right.right = new BSTNode(7);

        inorderTraversalWithRecursion(root);
        inorderTraversalWithoutRecursion(root);
    }

    private static class BSTNode {
        BSTNode left = null;
        BSTNode right = null;

        int value;

        public BSTNode(final int value) {
            this.value = value;
        }
    }
}
