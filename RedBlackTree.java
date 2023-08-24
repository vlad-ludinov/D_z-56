/**
 * RedBlackTree
 */
public class RedBlackTree {

    Node root;

    public boolean add(int value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.setColor(Color.BLACK);
            return result;
        } else {
            root = new Node(value);
            root.setColor(Color.BLACK);
            return true;
        }
    }

    private boolean addNode(Node node, int value) {
        if (node.getValue() == value) {
            return false;
        } else {
            if (node.getValue() > value) {
                if (node.getLeftChild() != null) {
                    boolean result = addNode(node.getLeftChild(), value);
                    node.setLeftChild(rebalance(node.getLeftChild()));
                    return result;
                } else {
                    node.setLeftChild(new Node(value));
                    return true;
                }
            } else {
                if (node.getRigthChild() != null) {
                    boolean result = addNode(node.getRigthChild(), value);
                    node.setRigthChild(rebalance(node.getRigthChild()));
                    return result;
                } else {
                    node.setRigthChild(new Node(value));
                    return true;
                }
            }
        }
    }


    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance = true;
        while (needRebalance) {
            needRebalance = false;
            if (result.getRigthChild() != null &&
                result.getRigthChild().getColor() == Color.RED && 
                (result.getLeftChild() == null || 
                result.getLeftChild().getColor() == Color.BLACK)) {
                    needRebalance = true;
                    result = rightSwap(result);
                }
            if (result.getLeftChild() != null &&
                result.getLeftChild().getColor() == Color.RED && 
                result.getLeftChild().getLeftChild() != null && 
                result.getLeftChild().getLeftChild().getColor() == Color.RED) {
                    needRebalance = true;
                    result = leftSwap(result);
                }
            if (result.getRigthChild() != null &&
                result.getRigthChild().getColor() == Color.RED && 
                result.getLeftChild() != null || 
                result.getLeftChild().getColor() == Color.RED) {
                    needRebalance = true;
                    colorSwap(result);
                }
        }
        return result;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.getRigthChild();
        Node betweenChild = rightChild.getLeftChild();
        rightChild.setLeftChild(node);
        node.setRigthChild(betweenChild);
        rightChild.setColor(node.getColor());
        node.setColor(Color.RED);
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.getLeftChild();
        Node betweenChild = leftChild.getRigthChild();
        leftChild.setRigthChild(node);
        node.setLeftChild(betweenChild);
        leftChild.setColor(node.getColor());
        node.setColor(Color.RED);
        return leftChild;
    }

    private void colorSwap(Node node) {
        node.getLeftChild().setColor(node.getColor());
        node.getRigthChild().setColor(node.getColor());
        node.setColor(Color.RED);
    }

    public String toString() {
        String result = String.format("root - %s\n", root);
        result = printChildren(root, result, 1);
        return result;
    }

    private String printChildren(Node node, String text, int count) {
        if (node.getLeftChild() != null) {
            text += String.format("%sleftChild - %s\n", space(count), node.getLeftChild());
            text = printChildren(node.getLeftChild(), text, count + 1);
        }
        if (node.getRigthChild() != null) {
            text += String.format("%srigthChild - %s\n", space(count), node.getRigthChild());
            text = printChildren(node.getRigthChild(), text, count + 1);
        }
        return text;
    }

    private String space(int count) {
        String space = "";
        for (int i = 0; i < count; i++) {
            space += " ";
        }
        return space;
    }
}