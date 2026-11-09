import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] A; // 인접 리스트
    static boolean[] visited; // 방문 기록 저장 배열
    static int[] check; // 이분 그래프 체크 배열 0 : A집합, 1 : B집합
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] s = br.readLine().split(" "); // 공백을 두고 데이터가 들어오는 것을 활용
            int V = Integer.parseInt(s[0]); // 정점의 개수
            int E = Integer.parseInt(s[1]); // 간선의 개수

            A = new ArrayList[V + 1]; // 인덱스를 1부터 사용하기 위함
            visited = new boolean[V + 1]; // 방문 기록 저장 배열의 크기도 노드와 같이
            check = new int[V + 1];
            isEven = true;

            for (int j = 1; j <= V; j++) { // 인접 리스트 초기화
                A[j] = new ArrayList<Integer>();
            }

            for (int j = 0; j < E; j++) { // 엣지 개수 만큼 반복
                s = br.readLine().split(" "); // 시작 노드와 종료 노드를 공백을 기준으로 받아옴
                int startNode = Integer.parseInt(s[0]); // 시작 노드
                int endNode = Integer.parseInt(s[1]); // 종료 노드
                /*
                    방향이 없다면 양방향으로 다 넣어준다.
                 */
                A[startNode].add(endNode);
                A[endNode].add(startNode);
            }

            // 모든 노드에 대하여 DFS 실행
            for (int j = 1; j <= V; j++) {
                if (isEven) { // 이분 그래프일 때 DFS 실행
                    DFS(j);
                } else {
                    break;
                }
            }

            /*
                반복문 종료 후 isEven = true 라면 이분 그래프이다.
             */
            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    private static void DFS(int startNode) {
        visited[startNode] = true;
        for (int i : A[startNode]) { // 인접한 노드에 대하여 탐색을 진행
            if (!visited[i]) {
                check[i] = (check[startNode] + 1) % 2;
                DFS(i);
            } else {
                if (check[startNode] == check[i]) {
                    isEven = false;
                }
            }
        }
    }
}
