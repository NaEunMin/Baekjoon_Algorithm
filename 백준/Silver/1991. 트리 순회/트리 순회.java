import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, parent, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);

    }

    // 전위 순회
    private static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preOrder(node.leftNode);
        preOrder(node.rightNode);
    }

    // 중위 순회
    private static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.leftNode);
        System.out.print(node.value);
        inOrder(node.rightNode);
    }

    // 후위 순회
    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.leftNode);
        postOrder(node.rightNode);
        System.out.print(node.value);
    }

    private static void insertNode(Node head, char parent, char left, char right) {
        if (head.value == parent) { // 부모 노드의 value가 parent와 같을 때
            head.leftNode = (left != '.') ? new Node(left, null, null) : null;
            head.rightNode = (right != '.') ? new Node(right, null, null) : null;
        } else {
            if (head.leftNode != null) {
                insertNode(head.leftNode, parent, left, right);
            }
            if (head.rightNode != null) {
                insertNode(head.rightNode, parent, left, right);
            }
        }
    }

    static class Node {
        char value;
        Node leftNode;
        Node rightNode;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.leftNode = left;
            this.rightNode = right;
        }
    }
}
