package zigzag;

import stack_usingll.*;
import queue_usingll.*;

public class Solution {

    public static void printZigZag(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTreeNode<Integer>> pendingnodes = new Stack<>();
        pendingnodes.push(root);

        boolean zig = true;
        int n;

        while (!pendingnodes.isEmpty()) {
            try {
                n = pendingnodes.getSize();
                Queue<BinaryTreeNode<Integer>> child = new Queue<>();
                if (zig) {
                    for (int i = 0; i < n; ++i) {
                        BinaryTreeNode<Integer> front = pendingnodes.pop();
                        System.out.print(front.data + " ");
                        if (front.left != null)
                            child.enqueue(front.left);

                        if (front.right != null)
                            child.enqueue(front.right);
                    }
                } else {
                    for (int i = 0; i < n; ++i) {
                        BinaryTreeNode<Integer> front = pendingnodes.pop();
                        System.out.print(front.data + " ");
                        if (front.right != null)
                            child.enqueue(front.right);

                        if (front.left != null)
                            child.enqueue(front.left);
                    }

                }

                while (!child.isEmpty()) {
                    pendingnodes.push(child.dequeue());
                }

                System.out.println();
                zig = zig == false;

            } catch (StackEmptyException e) {
                return;
            } catch (QueueEmptyException e) {
                return;
            }

        }
    }

}
