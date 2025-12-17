import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[N];
        int max = 0;

        String scores = scanner.nextLine();
        String [] strArr = scores.split(" ");

        for(int i=0; i<strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
            if (arr[i] > max) {
                max = arr[i];
            }
        }


        int sum = 0;
        double result = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        result = (double)sum/max*100/N;

        System.out.println(result);

    }
}