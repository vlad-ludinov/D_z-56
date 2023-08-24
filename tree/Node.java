package tree;
/**
 * класс Node, в нем есть значение, цвет, и левый и правый ребенки
 */
public class Node {

    private int value;

    private Color color;

    private Node rigthChild = null;

    private Node leftChild = null;

    // новый Node всегда красный
    public Node(int value) {
        this.value = value;
        this.color = Color.RED;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRigthChild() {
        return rigthChild;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRigthChild(Node rigthChild) {
        this.rigthChild = rigthChild;
    }

    @Override
    public String toString() {
        return String.format("value: %s, color: %s", getValue(), getColor());
    }
}