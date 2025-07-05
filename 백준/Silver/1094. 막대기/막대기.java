import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt(); //목표 길이
        scanner.close();

        int count = 0;
        int stick = 64;
        while (X > 0) {
            if (stick > X) {
                stick /= 2; //막대를 자르기
            } else {
                count++;
                X -= stick; //X는 목표까지 남은 길이을 알려주는 역할을 하게된다.
            }
        }
        System.out.println(count);

//        stick = 64 → 64 > 23 → 자르기 → 32
//        stick = 32 → 32 > 23 → 자르기 → 16
//        16 ≤ 23 → 사용 → X = 7, count = 1
//        stick = 16 → 유지
//        stick > 7 → 자르기 → 8
//        8 > 7 → 자르기 → 4
//        4 ≤ 7 → 사용 → X = 3, count = 2
//        4 > 3 → 자르기 → 2
//        2 ≤ 3 → 사용 → X = 1, count = 3
//        2 > 1 → 자르기 → 1
//        1 ≤ 1 → 사용 → X = 0, count = 4
    }
}
