package com.yezi.datastructure;


public class RBTree<T extends RBTree.Data> {

    public interface Key extends Comparable<Key> {}

    public interface Data {
        Key getKey();
    }

    public enum Color {

        RED,

        BLACK
    }

    public static class Node<T extends RBTree.Data> {

        Node parent;

        Node left;

        Node right;

        Color color;

        T t;

        public Node(T t) {
            this.t = t;
            color = Color.RED;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getParent() {
            return parent;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node<T> getLeft() {
            return left;
        }

        public boolean hasLeft() {
            return this.left != null;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node<T> getRight() {
            return this.right;
        }

        public boolean hasRight() {
            return this.right != null;
        }

        public void colourRed() {
            this.color = Color.RED;
        }

        public void colourBlack() {
            this.color = Color.BLACK;
        }

        public Color getColor() {
            return color;
        }

        public boolean isRed() {
            return color == Color.RED;
        }

        public boolean isBlack() {
            return color == Color.BLACK;
        }

        public Key getKey() {
            return t.getKey();
        }

        public T getData() {
            return t;
        }
    }

    Node<T> root;

    public void insert(T t) {
        Node<T> newNode = new Node<>(t);
        if (root == null) {
            newNode.colourBlack();
            root = newNode;
        } else {
            insertAtNode(root, newNode);
        }
    }

    private void insertAtNode(Node<T> node, Node<T> newNode) {
        Key key = node.getKey();
        Key newKey = newNode.getKey();
        if (key.compareTo(newKey) > 0) { // newKey < key
            if (node.hasLeft()) {
                insertAtNode(node.getLeft(), newNode);
            } else {
                node.setLeft(newNode);
                newNode.setParent(node);
            }
        } else { // newKey >= key
            if (node.hasRight()) {
                insertAtNode(node.getRight(), newNode);
            } else {
                node.setRight(newNode);
                newNode.setParent(node);
            }
        }
    }

    public void remove(Data t) {

    }

    public void walkThought() {

    }

    private void makeCurNodeValid() {

    }

    private void leftRotate(Node node) {

    }

    private void rightRotate(Node node) {

    }

    private void checkVaild() {

    }

}
