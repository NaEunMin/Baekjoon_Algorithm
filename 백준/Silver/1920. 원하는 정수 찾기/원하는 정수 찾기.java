import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int M = sc.nextInt();
        int[] target = new int[M];
        for (int i = 0; i < M; i++) {
            target[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {

            int start_index = 0;
            int last_index = arr.length - 1;
            int mid_index = (start_index + last_index) / 2;
            boolean find = false;

            while (start_index <= last_index) {
                if (target[i] == arr[mid_index]) { // 같으면 바로 1 출력
                    find = true;
                    break;
                }
                if (target[i] > arr[mid_index]) { // 찾아야할 값이 탐색 배열의 중앙값보다 크다면
                    start_index = mid_index + 1;
                    mid_index = (start_index + last_index) / 2;
                }
                if (target[i] < arr[mid_index]) { // 찾아야할 값이 탐색 배열의 중앙값보다 작다면
                    last_index = mid_index - 1;
                    mid_index = (start_index + last_index) / 2;
                }
            }
            if (!find) {
                System.out.println("0");
            } else {
                System.out.println("1");
            }

        }

    }
}
