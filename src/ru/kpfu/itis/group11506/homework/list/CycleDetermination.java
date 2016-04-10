package ru.kpfu.itis.group11506.homework.list;

public class CycleDetermination {

    public boolean hasCicle(LinkedNodes<Boolean> nodes) {
        if (nodes.getStartNode() != null) {
            if (nodes.getLastNode() != nodes.getStartNode()) {

                Node<Boolean> checkNode = nodes.getStartNode();

                while (!checkNode.getValue()) {
                    checkNode.setValue(true);
                    checkNode = checkNode.getNextNode();

                    if (checkNode == null) {
                        nodes = check(nodes);
                        return false;
                    }
                }
                nodes = check(nodes);
                return true;
            }
            nodes = check(nodes);
            return nodes.getLastNode().getNextNode() == nodes.getStartNode();

        }
        return false;
    }

    private LinkedNodes<Boolean> check(LinkedNodes<Boolean> nodes) {
        Node<Boolean> checkNode = nodes.getStartNode();
        while (checkNode.getValue()) {
            checkNode.setValue(false);
            checkNode = checkNode.getNextNode();

            if (checkNode == null) {
                break;
            }
        }
        return nodes;
    }
}
