import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n + 1];
        /*
            기본적으로 알 수 있는 수는 대입을 해둔다.
         */
        A[0] = 1;
        A[1] = 1;
        for (int i = 2; i <= n; i++) {
            A[i] = (A[i - 2] + A[i - 1]) % 10007;
        }
        System.out.println(A[n]);
    }
}