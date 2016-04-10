package ru.kpfu.itis.group11506.homework.list;

public class LinkedNodes<T> {

    private Node<T> startNode;

    private Node<T> lastNode;

    public Node<T> getStartNode() {
        return startNode;
    }

    public Node<T> getLastNode() {
        return lastNode;
    }

    /**
     * Инициализирует начальные данные
     */
    public void init() {
        startNode = null;
        lastNode = null;
    }

    /**
     * Добавляет последний элемент в списке с указанным в параметре
     * значением
     *
     * @param value
     * @return Добавленный элемент
     */
    public Node<T> addLastNode(T value) {
        Node<T> newNode = new Node<>();
        newNode.setValue(value);
        if (startNode == null) {
            startNode = newNode;
        }
        if (lastNode != null)
            lastNode.setNode(newNode);
        lastNode = newNode;
        return newNode;
    }

    public void addLastNode(Node<T> node) {
        if (node != null) {
            lastNode.setNode(node);
        }
        lastNode = node;
    }

    /**
     * Удаляет последний элемент в списке
     */
    public void removeLastNode() {
        Node<T> node = startNode;
        while (!(node.getNextNode() == lastNode)){
            node = node.getNextNode();
        }
        lastNode = node;
        lastNode.setNode(null);
    }
}
