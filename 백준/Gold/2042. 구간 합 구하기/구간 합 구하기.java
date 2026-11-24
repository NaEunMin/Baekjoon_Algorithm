import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나는 횟수
        int K = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수
        int nodeSize;
        int startIndex = 1;
        /*
            총 노드의 개수를 구하는 법
            리프 노드의 수가 N일 때 2^k >= N을 만족하는 최소의 k를 구한 후 2^k * 2로 총 노드의 개수를 구한다.
         */
        while (startIndex < N) {
            startIndex *= 2;
        }
        nodeSize = startIndex * 2;
        long[] tree = new long[nodeSize];

        // startIndex부터 리프 노드에 입력 노드들을 저장
        for (int i = startIndex; i < N + startIndex; i++) {
            st = new StringTokenizer(br.readLine());
            tree[i] = Long.parseLong(st.nextToken());
        }

        // 구간 합 계산 함수 호출
        rangeSum(tree);

        // 수 변경 및 구간 합 계산 후 출력
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // a = 1이면 수 변경, a = 2이면 출력
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) { // 수 변경
                int segmentTreeIndex = b + startIndex - 1;
                tree[segmentTreeIndex] = Long.parseLong(st.nextToken());
                while (segmentTreeIndex > 1) {
                    segmentTreeIndex /= 2;
                    tree[segmentTreeIndex] = tree[segmentTreeIndex * 2] + tree[segmentTreeIndex * 2 + 1];
                }
            }

            if (a == 2) { // 질의 구간 출력
                int c = Integer.parseInt(st.nextToken());
                int segmentTreeStartIndex = b + startIndex - 1;
                int segmentTreeLastIndex = c + startIndex - 1;
                printRangeSum(tree, segmentTreeStartIndex, segmentTreeLastIndex);
            }
        }
    }

    private static void rangeSum(long[] tree) {
        for (int i = tree.length / 2 - 1; i >= 1; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1]; // 부모 노드 = 왼쪽 자식 + 오른쪽 자식
        }
    }

    private static void printRangeSum(long[] tree, int segmentTreeStartIndex, int segmentTreeLastIndex) {
        long sum = 0;
        while (segmentTreeStartIndex <= segmentTreeLastIndex) {
            if (segmentTreeStartIndex % 2 == 1) sum += tree[segmentTreeStartIndex];
            if (segmentTreeLastIndex % 2 == 0) sum += tree[segmentTreeLastIndex];

            segmentTreeStartIndex = (segmentTreeStartIndex + 1) / 2;
            segmentTreeLastIndex = (segmentTreeLastIndex - 1) / 2;

        }
        System.out.println(sum);
    }
}
