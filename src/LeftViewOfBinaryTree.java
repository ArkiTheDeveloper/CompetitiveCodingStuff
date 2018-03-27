public class LeftViewOfBinaryTree {



    static void leftView(Node root)
    {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        recPrintTree(root);
    }

    static void recPrintTree(Node node) {
        if(node == null ) {
            return;
        }
        Node leftNode = node.left;
        Node rightNode = node.right;
        if (leftNode == null) {
            return;
        }
        System.out.print(leftNode.data + " ");
        recPrintTree(leftNode);
        recPrintTree(rightNode);
    }

    public static void main(String[] args) {
        Node rN = new Node(12);
        Node rLN = new Node(10);
        Node rRN = new Node(30);
        Node rRLN = new Node(20);
        Node rRRN = new Node(40);

        rN.left = rLN;
        rN.right = rRN;
        rRN.left = rRLN;
        rRN.right = rRRN;

        leftView(rN);
    }
}

class Node {
    public Node(int data) {
        this.data = data;
    }
    int data;
    Node left = null, right = null;
}
