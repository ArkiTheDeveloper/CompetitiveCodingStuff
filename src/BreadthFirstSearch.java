import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    private static void traverse(Node root) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node temp = nodes.poll();
            System.out.println(temp.data);

            if (temp.left !=null) {
                nodes.add(temp.left);
            }

            if (temp.right != null) {
                nodes.add(temp.right);
            }
        }
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

        traverse(rN);
    }
}
