import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] myArr = new int[N];
        for (int i = 0; i < N; i++) {
            myArr[i] = scanner.nextInt();
        }

        for (int i = 0; i < N - 1; i++) { //맨 뒤는 1회마다 어차피 정렬된다.
            for (int j = 0; j < N - 1 - i; j++) { //루프가 한 번 돌때마다 정렬된 부분이 뒤쪽에 생긴다.
                if (myArr[j] > myArr[j + 1]) {
                    int temp = myArr[j];
                    myArr[j] = myArr[j + 1];
                    myArr[j + 1] = temp;
                }
            }
        }

        for(int i = 0; i < myArr.length; i++){
            System.out.println(myArr[i]);
        }
    }
}