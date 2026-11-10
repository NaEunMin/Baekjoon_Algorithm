import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 원소의 개수
        int M = Integer.parseInt(s[1]); // 질의 개수
        parent = new int[N + 1]; // 대표 노드 배열

        for (int i = 0; i < N + 1; i++) {
            parent[i] = i; // 자기자신으로 대표 노드 배열 초기화
        }

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int operation = Integer.parseInt(s[0]); // 연산할 종류
            int a = Integer.parseInt(s[1]); // 노드
            int b = Integer.parseInt(s[2]); // 노드

            if (operation == 0) {
                union(a, b);
            } else {
                boolean result = checkSame(a, b);
                if (result) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA > rootB) {
            parent[rootA] = rootB;
        } else if (rootA < rootB) {
            parent[rootB] = rootA;
        }
    }

    private static int find(int x) {
/*
         if (x == parent[x]) { // x가 대표 노드인 상황
            return x;
        } else { // x가 대표 노드가 아닌 상황
            parent[x] = find(parent[x]); // 경로 압축 부분
            return parent[x];
        }

 */
        // 위 코드처럼 작성하면 재귀가 깊어져 오류가 발생한다. -> 반복문으로 개선

        int root = x;
        while (root != parent[root]) { // 대표 찾기
            root = parent[root]; // ex) x = 5, root = 5, parent[root] = 4라면 root = 4로 바뀐다. 이렇게 점점 대표 노드를 찾아감.
        }

        while (x != root) { // 입력 노드인 x가 루트가 아닐 때
            int next = parent[x]; // 다음 노드를 저장
            parent[x] = root; // 경로압축
            x = next;
        }

        return root;
    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }
}
