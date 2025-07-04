import java.util.Scanner;

public class Main {
    public static long combination(int wp, int ep) {
        //int으로 처리하면 숫자가 매우 커져 int의 범위를 넘어설 우려가 있음
        //아래의 로직처럼 combination을 한 단계씩 처리하고 넘어가고 처리하고 넘어가고 하지 않으면 위에서 언급한
        //수가 매우 커지는 우려가 있음.
        long result = 1;
        for (int i = 1; i <= wp; i++) {
            result = result * (ep - i + 1) / i;
        }
        return result;
    }

    public static void main(String[] args) {
        int westPoint;
        int eastPoint;
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); //테스트 케이스 개수 입력
        for (int t = 0; t < T; t++) {
            westPoint = scanner.nextInt();
            eastPoint = scanner.nextInt();
            System.out.println(combination(westPoint, eastPoint));
        }
        scanner.close();

    }
}
