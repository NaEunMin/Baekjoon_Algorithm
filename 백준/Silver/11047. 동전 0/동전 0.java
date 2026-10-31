import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int current = K;
        int coin_cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (current > A[i]) {
                coin_cnt += (current / A[i]);
                current %= A[i];
            }
        }

        System.out.println(coin_cnt);
    }
}
