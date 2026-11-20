import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 도시 수
        int M = Integer.parseInt(br.readLine()); // 버스 수

        int[][] D = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) { // 최단 거리 리스트 초기화
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    D[i][j] = 0;
                } else {
                    D[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < M; i++) { // M번 만큼 입력받고 최단 거리 리스트에 저장
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 출발 도시
            int end = Integer.parseInt(st.nextToken()); // 도착 도시
            int cost = Integer.parseInt(st.nextToken()); // 버스 비용
            D[start][end] = Math.min(D[start][end], cost);
        }

        /*
            3개의 변수 경유지 : K, 출발 도시 : S, 도착 도시 : E를 비교하기 위하여 3중 for문
         */
        for (int K = 1; K <= N; K++) {
            for (int S = 1; S <= N; S++) {
                for (int E = 1; E <= N; E++) {
                    if (D[S][K] == Integer.MAX_VALUE || D[K][E] == Integer.MAX_VALUE) {
                        continue;
                    }
                    D[S][E] = Math.min(D[S][E], D[S][K] + D[K][E]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print((D[i][j] == Integer.MAX_VALUE ? 0 : D[i][j]) + " ");

            }
            System.out.println();
        }
    }
}
