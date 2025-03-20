public class BSTTree<T extends Comparable> {
    private Node<T> root;
    private int size;

    public BSTTree() {
        root = null;
        size = 0;
    }

    public Node<T> createNode(T data) {
        return new Node<>(data);
    }

    public boolean insertNode(T data) {
        Node<T> newNode = createNode(data);
        if (root == null) {
            root = newNode;
            size++;
            return true;
        } else {
            Node<T> current = root;
            Node<T> parent = null;
            while (current != null) {
                parent = current;
                if (data.compareTo(current.getData()) < 0) {
                    current = current.getLeft();
                } else if (data.compareTo(current.getData()) > 0) {
                    current = current.getRight();
                } else {
                    return false;
                }
            }
            if (data.compareTo(parent.getData()) < 0) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }
            size++;
            return true;
        }
    }

    public void postorder(Node<T> node) {
        if (node == null) return;
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.println(node.getData() + " ");
    }

    public void postorderTraversal() {
        postorder(root);
    }

    public int getSize() {
        return size;
    }
}
