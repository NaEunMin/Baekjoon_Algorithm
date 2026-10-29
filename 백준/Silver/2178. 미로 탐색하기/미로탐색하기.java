import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int N, M;
    static int A[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N,M 값 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // A, visited 배열 초기화
        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                // 문자열을 한칸씩 끊어서 2차원 배열에 값을 넣어준다.
                A[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        BFS(0, 0);
        System.out.println(A[N - 1][M - 1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j}); // 배열로 행, 열 값을 표현한다.

        //큐가 비어있을 때까지 BFS 탐색
        while (!queue.isEmpty()) {
            int now[] = queue.poll(); // 실제로 사용해야해서 peek()가 아닌 poll() 사용
            visited[now[0]][now[1]] = true;
            for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && x < N && y >= 0 && y < M) { // 유효한 좌표인지 검사
                    if(A[x][y] == 1 && !visited[x][y]) { // 이동가능하며 방문하지 않은 좌표여야 한다.
                        visited[x][y] = true; // 검사를 통과했다면 방문한다.
                        A[x][y] = A[now[0]][now[1]] + 1; // 각 배열에 depth를 표현할 것이므로 +1을 더해준다.
                        queue.add(new int[]{x, y}); // 큐에 지금 검사한 좌표를 넣는다.
                    }
                }
            }
        }
    }
}
