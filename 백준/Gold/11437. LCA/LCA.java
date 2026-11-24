import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> A;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드 개수

        A = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }

        // 트리 데이터를 인접 리스트에 저장
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A.get(a).add(b);
            A.get(b).add(a);
        }
        nodes = new Node[N + 1];
        BFS();

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            searchMinSameParent(a, b);
        }

    }

    private static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        // 1은 미리 사전 작업
        nodes[1] = new Node(0, 0);
        visited[1] = true;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int next : A.get(parent)) {
                if (visited[next]) continue;
                visited[next] = true;
                nodes[next] = new Node(parent, nodes[parent].depth + 1);
                queue.offer(next);
            }
        }

    }

    private static void searchMinSameParent(int a, int b) {
        while (nodes[a].depth < nodes[b].depth) {
            b = nodes[b].parent;
        }
        while (nodes[a].depth > nodes[b].depth) {
            a = nodes[a].parent;
        } // 여기까지는 깊이를 같게 함

        while (a != b) {
            a = nodes[a].parent;
            b = nodes[b].parent;
        }

        System.out.println(a);
    }

    static class Node {
        int parent;
        int depth;

        public Node(int parent, int depth) {
            this.parent = parent;
            this.depth = depth;
        }
    }
}
