public class BST<E extends Comparable<E>> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public int getSize() {
        return size;
    }

    public boolean insert(E element) {
        if (root == null) {
            root = new TreeNode<>(element);
            size++;
            return true;
        } else {
            TreeNode<E> current = root;
            TreeNode<E> parent = null;
            while (current != null) {
                parent = current;
                if (element.compareTo(current.element) < 0) {
                    current = current.left;
                } else if (element.compareTo(current.element) > 0) {
                    current = current.right;
                } else {
                    return false;
                }
            }
            TreeNode<E> newNode = new TreeNode<>(element);
            if (element.compareTo(parent.element) < 0) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }
            size++;
            return true;
        }
    }
    public TreeNode<E> getRoot() {
        return root;
    }
    public void inorder(TreeNode<E> node) {
        if (node == null) return;
        inorder(node.left);
        System.out.println(node.element + " ");
        inorder(node.right);
    }
}
