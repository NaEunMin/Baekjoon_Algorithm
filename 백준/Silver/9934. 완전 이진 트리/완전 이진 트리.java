import java.util.*;

public class Main {
    static Node head;
    static int count = 0;
    static int K;
    static int nodeCount;
    static int[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt(); // 깊이 K
        nodeCount = (int) Math.pow(2, K) - 1; // 문제 조건에 의해 존재해야할 노드의 개수
        A = new int[nodeCount];

        for (int i = 0; i < nodeCount; i++) {
            A[i] = sc.nextInt();
        }


        int first = 0;
        int last = nodeCount - 1;
        int mid = (first + last) / 2;

        head = new Node(A[mid], null, null);
        insertLeftNode(head, first, mid - 1);
        insertRightNode(head, mid + 1, last);

        printByLevel(head);
    }

    private static void insertLeftNode(Node head, int first, int last) {
        if (first > last) {
            return;
        }
        int tmp = (first + last) / 2;
        head.left = new Node(A[tmp], null, null);
        insertLeftNode(head.left, first, tmp - 1);
        insertRightNode(head.left, tmp + 1, last);
    }

    private static void insertRightNode(Node head, int first, int last) {
        if (first > last) {
            return;
        }
        int tmp = (first + last) / 2;
        head.right = new Node(A[tmp], null, null);
        insertLeftNode(head.right, first, tmp - 1);
        insertRightNode(head.right, tmp + 1, last);
    }

    private static void printByLevel(Node head) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(head);
        Node last = head;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value);
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
            if (last == current) {
                System.out.println();
                last = queue.peekLast();
            } else {
                System.out.print(" ");
            }
        }

    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
