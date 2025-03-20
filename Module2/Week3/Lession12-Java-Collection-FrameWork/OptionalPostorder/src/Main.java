public class Main {
    public static void main(String[] args) {
        BSTTree<Integer> integerBSTTree = new BSTTree<>();
        integerBSTTree.insertNode(27);
        integerBSTTree.insertNode(42);
        integerBSTTree.insertNode(19);
        integerBSTTree.insertNode(31);
        integerBSTTree.insertNode(35);
        integerBSTTree.insertNode(14);
        integerBSTTree.insertNode(10);
        System.out.println("Postorder of BST Tree: ");
        integerBSTTree.postorderTraversal();
    }
}
