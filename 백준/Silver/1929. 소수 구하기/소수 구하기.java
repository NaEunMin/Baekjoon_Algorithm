import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // M 이상
        int N = sc.nextInt(); // N 이하
        int[] A = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = i;
        }

        for (int i = 2; i * i <= N; i++) { // i <= Math.sqrt(N) 으로 해도 됨
            if (A[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= N; j += i) {
                A[j] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (A[i] == 0) {
                continue;
            }
            System.out.println(A[i]);
        }
    }
}
