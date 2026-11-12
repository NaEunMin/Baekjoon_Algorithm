import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 학생 번호 (1~N)
        int M = Integer.parseInt(s[1]); // 키를 비교한 횟수
        ArrayList<ArrayList<Integer>> A = new ArrayList<>(); // 인접리스트
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }
        int[] indegree = new int[N + 1]; // 진입 차수 배열

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            A.get(start).add(end); // 인접 리스트 저장
            indegree[end]++; // 진입 차수 배열 저장
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(indegree[i] == 0) { // 진입 차수 값이 0이라면 큐에 삽입
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) { // 큐가 빌 때까지 반복
            int current = queue.poll(); // 현재 노드를 큐에서 가져옴
            sb.append(current).append(" "); // 현재 노드 출력
            for(int next : A.get(current)) { // 현재 노드가 바라보는 노드 개수만큼 순회
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
