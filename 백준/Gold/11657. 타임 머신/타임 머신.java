import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Edge>> A = new ArrayList<>();
        int[] D = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
            D[i] = Integer.MAX_VALUE;
        }
        D[1] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            A.get(start).add(new Edge(start, end, time));
        }

        for (int round = 1; round <= N; round++) {
            boolean update = false;
            for (int start = 1; start <= N; start++) {
                for (Edge e : A.get(start)) {
                    if (D[e.start] == Integer.MAX_VALUE) {
                        continue;
                    }
                    int next = D[e.start] + e.weight;
                    if (D[e.end] > next) {
                        if (round == N) { // 마지막 순회인데 시간이 감소하여 음수 사이클임을 호가인
                            System.out.println(-1);
                            break;
                        }
                        D[e.end] = next;
                        update = true;
                    }
                }
            }
            if (!update) {
                break;
            }
        }

    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
