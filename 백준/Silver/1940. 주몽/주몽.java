import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); //재료의 개수
        int M = scanner.nextInt(); //갑옷을 만드는데 필요한 수, 즉 합
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

        int start_index = 0;
        int end_index = arr.length - 1;
        int count = 0;
        while (start_index < end_index) {
            if (arr[start_index] + arr[end_index] < M) {
                start_index++;
            } else if (arr[start_index] + arr[end_index] > M) {
                end_index--;
            } else { //합이 성립한 경우
                count++;
                start_index++;
                end_index--;
            }
        }
        System.out.println(count);
    }
}