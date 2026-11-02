import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int a = gcd(N, M);
        int b = N * M / a;
        System.out.println(a);
        System.out.println(b);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int result = a % b;
            a = b;
            b = result;
        }
        return a;
    }
}
