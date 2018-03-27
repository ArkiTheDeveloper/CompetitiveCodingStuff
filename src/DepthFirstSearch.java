public class DepthFirstSearch {

    public static void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.data);
        inOrderTraversal(node.right);
    }

    public static void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.data);
    }

    /**
     *            12
     *          /   \
     *         10   30
     *        /  \  / \
     *       8  11 20 40
     * @param args
     */

    public static void main(String[] args) {
        Node rN = new Node(12);
        Node rLN = new Node(10);
        Node rRN = new Node(30);
        Node rLLN = new Node(8);
        Node rLRN = new Node(11);
        Node rRLN = new Node(20);
        Node rRRN = new Node(40);

        rN.left = rLN;
        rN.right = rRN;
        rLN.left = rLLN;
        rLN.right = rLRN;
        rRN.left = rRLN;
        rRN.right = rRRN;

        System.out.println("In Order Traversal");
        inOrderTraversal(rN);

        System.out.println("Pre Order Traversal");
        preOrderTraversal(rN);

        System.out.println("Post Order Traversal");
        postOrderTraversal(rN);
    }
}
