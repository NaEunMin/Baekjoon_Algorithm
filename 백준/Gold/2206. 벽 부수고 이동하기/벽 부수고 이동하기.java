import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        boolean[][][] visited = new boolean[N][M][2]; // 행, 열, 0 : 벽을 안부수고 온 경로 1: 벽을 부수고 온 경로

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0, 1}); // 행, 열, 지금까지 벽을 부수고 온적 있는지 0 : 부수고 오지않음 1: 부수고 왔음, 지금까지 거리
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == N - 1 && current[1] == M - 1) {
                System.out.println(current[3]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = current[1] + dx[i];
                int ny = current[0] + dy[i];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue; // 상하좌우 확인
                if (map[ny][nx] == '1' && current[2] == 1) { // 다음 갈 구역이 벽인데 지금까지 이미 벽을 부수고 왔다면 못간다.
                    continue;
                }
                if (map[ny][nx] == '1' && current[2] == 0 && !visited[ny][nx][1]) { // 다음 갈 구역이 벽인데 지금까지 벽을 부수고 온 적이 없다면
                    queue.offer(new int[]{ny, nx, 1, current[3] + 1});
                    visited[ny][nx][1] = true;
                }
                if (map[ny][nx] == '0' && !visited[ny][nx][current[2]]) { // 다음 갈 구역이 0이고 다음 구역을 방문한 적이 없다면
                    queue.offer(new int[]{ny, nx, current[2], current[3] + 1});
                    visited[ny][nx][current[2]] = true;
                }
            }
        }
        System.out.println(-1);

    }
}