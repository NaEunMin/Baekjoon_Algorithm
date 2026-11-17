import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정점 개수
        int M = sc.nextInt(); // 간선 개수

        ArrayList<ArrayList<Node>> A = new ArrayList<>(); // 인접 리스트
        boolean[] visited = new boolean[N + 1]; // 방문 확인 배열
        int[] D = new int[N + 1]; // 최단 거리 배열

        int startNode = sc.nextInt();
        for (int i = 0; i <= N; i++) { // 배열 초기화
            A.add(new ArrayList<>());
            D[i] = Integer.MAX_VALUE;
        }
        D[startNode] = 0;

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            Node node = new Node(end, cost);

            A.get(start).add(node);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        queue.offer(new Node(startNode, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int u = current.vertex; // 이번에 검사할 정점

            if (visited[u]) continue; // 이번에 검사할 정점이 이미 방문했다면 통과
            visited[u] = true; // 방문 안했으면 방문 표시

            for (Node next : A.get(u)) { // 인접한 노드 검사 실시
                int v = next.vertex; // 인접한 노드
                int newDistance = D[u] + next.cost; // 인접한 노드의 새로운 거리 계산 = 현재 노드까지의 거리 + 다음 노드의 거리
                if (D[v] > newDistance) {
                    D[v] = newDistance;
                    queue.offer(new Node(v, newDistance));
                }
            }

        }

        for (int i = 1; i <= N; i++) {
            System.out.println(D[i] == Integer.MAX_VALUE ? "INF" : D[i]);
        }

    }

    static class Node {
        int vertex;
        int cost;

        Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}
