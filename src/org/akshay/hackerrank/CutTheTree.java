package org.akshay.hackerrank;

import org.akshay.hackerrank.util.BinaryTree;
import org.akshay.hackerrank.util.Node;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by aksh7576 on 2/27/15.
 */

// https://www.hackerrank.com/challenges/cut-the-tree
public class CutTheTree {
  /**
   * Main function.
   * @param args
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] values = new int[n];
    // read the vertex values
    for (int i = 0; i < n; i++) {
      values[i] = in.nextInt();
    }
    BinaryTree binaryTree = new BinaryTree();
    // read the tree edges
    for (int i = 0; i < n-1; i++) {
      int node1index = in.nextInt();
      int node2index = in.nextInt();
      Node node1 = new Node(values[node1index-1], node1index);
      Node node2 = new Node(values[node2index-1], node2index);
      binaryTree.addEdge(node1, node2);
    }
    // find Tree_diff
    int treeDiff = Integer.MAX_VALUE;
    Stack<Node> traversalStack = new Stack<Node>();
    traversalStack.push(binaryTree.getRoot());
    while (!traversalStack.isEmpty()) {
      Node current = traversalStack.pop();
      if (current.getLeft() != null) {
        int tempTreeDiff = Math.abs(binaryTree.sumOfVertexes(current) - binaryTree.sumOfVertexes(current.getLeft()));
        if(tempTreeDiff < treeDiff) treeDiff = tempTreeDiff;
        traversalStack.push(current.getLeft());
      }
      if (current.getRight() != null) {
        int tempTreeDiff = Math.abs(binaryTree.sumOfVertexes(current) - binaryTree.sumOfVertexes(current.getRight()));
        if(tempTreeDiff < treeDiff) treeDiff = tempTreeDiff;
        traversalStack.push(current.getRight());
      }
    }
    System.out.println(treeDiff);
    System.out.println(binaryTree.sumOfVertexes(binaryTree.getRoot()));
    System.out.println(binaryTree.sumOfVertexes(binaryTree.getNode(new Node(100, 2))));
    //binaryTree.printTree(binaryTree.getRoot());
  }
}
