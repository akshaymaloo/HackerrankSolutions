package org.akshay.hackerrank.util;

import java.util.Stack;

/**
 * Created by aksh7576 on 2/27/15.
 */

// Binary Tree
public class BinaryTree {
  private Node root = null;

  public BinaryTree() {};

  public BinaryTree(Node root) {
    this.root = root;
  }

  public Node getRoot() {
    return root;
  }

  /**
   * Add an edge
   * @param node1
   * @param node2
   */
  public void addEdge(Node node1, Node node2) {
    if(root == null) root = node1;
    // get the node we have to connect to.
    Node connectToNode = getNode(node1);
    if(connectToNode != null) {
      if(connectToNode.getRight() == null) connectToNode.setRight(node2);
      else connectToNode.setLeft(node2);
    } else {
      connectToNode = getNode(node2);
      if(connectToNode.getRight() == null) connectToNode.setLeft(node1);
      else connectToNode.setRight(node1);
    }
  }

  /**
   * Find/get tree node
   * @param searchNode
   * @return Node
   */
  public Node getNode(Node searchNode) {
    Stack<Node> traversalStack = new Stack<Node>();
    traversalStack.push(root);
    while (!traversalStack.isEmpty()) {
      Node current = traversalStack.pop();
      if(current.getIndex() == searchNode.getIndex()) return current;
      if(current.getLeft() != null) traversalStack.push(current.getLeft());
      if(current.getRight() != null) traversalStack.push(current.getRight());
    }
    return null;
  }

  /**
   * Return the sum of all vertices.
   * @param root
   * @return sum
   */
  public int sumOfVertexes(Node root) {
    Stack<Node> traversalStack = new Stack<Node>();
    traversalStack.push(root);
    int sum = 0;
    while (!traversalStack.isEmpty()) {
      Node current = traversalStack.pop();
      sum += current.getValue();
      if(current.getLeft() != null) traversalStack.push(current.getLeft());
      if(current.getRight() != null) traversalStack.push(current.getRight());
    }
    return sum;
  }

  /**
   * Print all tree nodes
   * @param root
   */
  public void printTree(Node root) {
    Stack<Node> traversalStack1 = new Stack<Node>();
    Stack<Node> traversalStack2 = new Stack<Node>();
    traversalStack1.push(root);
    while (!traversalStack1.isEmpty() || !traversalStack2.isEmpty()) {
      if(traversalStack1.isEmpty()) {
        // use traversalStack2
        while (!traversalStack2.isEmpty()) {
          Node current = traversalStack2.pop();
          System.out.print(current.getIndex() + " ");
          if(current.getLeft() != null) traversalStack1.push(current.getLeft());
          if(current.getRight() != null) traversalStack1.push(current.getRight());
        }
      } else {
        // use traversalStack1
        while (!traversalStack1.isEmpty()) {
          Node current = traversalStack1.pop();
          System.out.print(current.getIndex() + " ");
          if(current.getLeft() != null) traversalStack2.push(current.getLeft());
          if(current.getRight() != null) traversalStack2.push(current.getRight());
        }
      }
      System.out.println();
    }
  }
}
