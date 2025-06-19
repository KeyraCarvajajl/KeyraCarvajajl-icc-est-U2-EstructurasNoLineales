package Materia.models;

public class Node {

    private int value;
    private int height;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
        this.height = 1; 
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public int getBalanceFactor() {
        int leftHeight = (left != null) ? left.getHeight() : 0;
        int rightHeight = (right != null) ? right.getHeight() : 0;
        return leftHeight - rightHeight;
    }

    @Override
    public String toString() {
        return value + "(h=" + height + ", bf=" + getBalanceFactor() + ")";
    }
}
