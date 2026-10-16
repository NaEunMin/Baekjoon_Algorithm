import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean[] V;
    static int[] S;
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //N까지의 숫자가 타겟
        M = sc.nextInt(); //M개의 수를 뽑아 수열 만들기

        V = new boolean[N + 1];
        S = new int[M];
        backTracking(0);
    }

    private static void backTracking(int arraySize) {
        if (arraySize == M) {
            System.out.println(Arrays.toString(S)); //만들어진 배열 출력
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!V[i]) {
                V[i] = true;
                S[arraySize] = i;
                backTracking(arraySize + 1);
                V[i] = false;
            }
        }

    }
}
