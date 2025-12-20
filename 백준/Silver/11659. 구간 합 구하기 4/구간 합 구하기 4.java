import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); //수의 개수 N
        int M = scanner.nextInt(); //합을 구해야하는 횟수 M

        //배열 사용시 편의성을 위해 0번 인덱스를 0으로 만들어두는 것이 킥
        int[] arr = new int[N + 1];
        long[] sumArr = new long[N + 1];
        for (int i = 1; i < N+1; i++) {
            arr[i] = scanner.nextInt();
            sumArr[i] = sumArr[i - 1] + arr[i];
        }


        for (int x = 0; x < M; x++) {
            int i = scanner.nextInt(); //합을 구해야하는 구간 i
            int j = scanner.nextInt(); //합을 구해야하는 구간 j

            System.out.println(sumArr[j] - sumArr[i - 1]);
        }


    }
}