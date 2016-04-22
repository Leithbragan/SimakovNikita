package ru.kpfu.itis.group11506.homework.Tree;

public class BinTree {

    private Node root;

    public Node findMin(Node right) {
        Node min = root;
        if (min == null) return null;
        while (min.getLeft() != null) {
            min = min.getLeft();
        }
        return min;
    }

    public void add(int data) {
        root = add(root, data, null);
    }

    private Node add(Node current, int data, Node parent) {
        if (current == null) {
            current = new Node();
            current.setData(data);
            current.setLeft(null);
            current.setRight(null);
            current.setParent(parent);
        } else if (data < current.getData()) {
            current.setLeft(add(current.getLeft(), data, current));
        } else {
            current.setRight(add(current.getRight(), data, current));
        }
        return current;
    }

    public void remove(int data) {
        root = remove(root, data);
    }

    private Node remove(Node startNode, int data) {
        Node element = find(startNode, data);
        if (element == null) return startNode;
        boolean hasParent = element.getParent() != null;
        boolean isLeft = hasParent && element.getData() < element.getParent().getData();
        if (element.getLeft() == null && element.getRight() == null) {
            if (hasParent) {
                if (isLeft) {
                    element.getParent().setLeft(null);
                } else {
                    element.getParent().setRight(null);
                }
            }
        } else if (element.getLeft() != null && element.getRight() == null) {
            if (hasParent) {
                if (isLeft) {
                    element.getParent().setLeft(element.getLeft());
                } else {
                    element.getParent().setRight(element.getLeft());
                }
            } else {
                startNode = element.getLeft();
            }
        } else if (element.getLeft() == null && element.getRight() != null) {
            if (hasParent) {
                if (isLeft) {
                    element.getParent().setLeft(element.getRight());
                } else {
                    element.getParent().setRight(element.getRight());
                }
            } else {
                startNode = element.getRight();
            }
        } else {
            Node rightMin = findMin(element.getRight());
            element.setData(rightMin.getData());
            return remove(rightMin, rightMin.getData());
        }
        return startNode;
    }

    public Node find(int data) {
        return find(root, data);
    }

    private Node find(Node current, int data) {
        if (current == null)
            return null;
        if (current.getData() == data)
            return current;
        if (data < current.getData()) {
            return find(current.getLeft(), data);
        }
        else {
            return find(current.getRight(), data);
        }
    }
}

