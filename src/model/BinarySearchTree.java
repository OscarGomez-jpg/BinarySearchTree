package model;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    /*
     * This function creates and adds a node to the left if its value
     * is lower than its parent value, otherwise it will be added to the right
     */
    public void addNode(int value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
        } else {
            addNode(root, node);
        }
    }

    private void addNode(Node pointer, Node node) {
        if (node.getValue() < pointer.getValue()) {
            if (pointer.getLeft() == null) {
                pointer.setLeft(node);
            } else {
                addNode(pointer.getLeft(), node);
            }
        } else {
            if (pointer.getRight() == null) {
                pointer.setRight(node);
            } else {
                addNode(pointer.getRight(), node);
            }
        }
    }

    /*
     * This function prints the graff
     */
    public String printGraf() {
        return printGraf(root);
    }

    private String printGraf(Node pointer) {
        if (pointer == null) {
            return "";
        }

        return printGraf(pointer.getRight()) + " " + pointer.getValue() + " " + printGraf(pointer.getLeft());
    }

    public Node minimum() {
        return minimum(root);
    }

    private Node minimum(Node pointer) {
        if (pointer.getLeft() == null) {
            return pointer;
        }

        return minimum(pointer.getLeft());
    }

    public Node maximum() {
        return maximum(root);
    }

    private Node maximum(Node pointer) {
        if (pointer.getRight() == null) {
            return pointer;
        }

        return maximum(pointer.getRight());
    }

    public Node searchNode(int value) {
        return searchNode(root, value);
    }

    private Node searchNode(Node pointer, int value) {
        if (pointer != null) {
            if (pointer.getValue() == value) {
                return pointer;
            } else if (pointer.getLeft() != null && value < pointer.getValue()) {
                return searchNode(pointer.getLeft(), value);
            } else if (pointer.getRight() != null) {
                return searchNode(pointer.getRight(), value);
            }
        }

        return null;
    }

    public Node searchParentByValue(int value) {
        return searchParentByValue(root, value);
    }

    private Node searchParentByValue(Node pointer, int value) {
        if (pointer != null) {
            if (pointer.getLeft() != null && pointer.getLeft().getValue() == value) {
                return pointer;
            } else if (pointer.getRight() != null && pointer.getRight().getValue() == value) {
                return pointer;
            } else if (value < pointer.getValue()) {
                return searchParentByValue(pointer.getLeft(), value);
            } else {
                return searchParentByValue(pointer.getRight(), value);
            }
        }

        return null;
    }

    public void deleteNode(int targetValue) {
        Node parent = searchParentByValue(targetValue);
        Node target = parent.getLeft();
        boolean isRight = false;

        if (parent.getRight().getValue() == targetValue) {
            target = parent.getRight();
            isRight = true;
        }

        if (parent == null || target == null) {
            return;
        }

        deleteNode(parent, target, isRight);

        target = null;
    }

    private void deleteNode(Node parent, Node target, boolean isRight) {
        if (target.getLeft() == null && target.getRight() == null) {
            if (isRight) {
                parent.setRight(null);
            } else {
                parent.setLeft(null);
            }

            return;
        }

        if (isRight) {
            Node maximum = maximum(target.getLeft());
            maximum.setRight(target.getRight());
            parent.setRight(target.getLeft());
        } else {
            Node minimum = minimum(target.getRight());
            minimum.setLeft(target.getLeft());
            parent.setLeft(target.getRight());
        }

    }

    public Node getRoot() {
        return root;
    }
}
