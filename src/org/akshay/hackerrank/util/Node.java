package org.akshay.hackerrank.util;

/**
 * Created by aksh7576 on 2/27/15.
 */

// Class represents a tree node
public class Node {
  private int value;
  private int index;
  private Node left = null;
  private Node right = null;

  public Node(int value) {
    this.value = value;
  }

  public Node(int value, int index) {
    this.value = value;
    this.index = index;
  }

  public Node(int value, Node left, Node right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public Node(int value, int index, Node left, Node right) {
    this.value = value;
    this.left = left;
    this.right = right;
    this.index = index;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }
}
