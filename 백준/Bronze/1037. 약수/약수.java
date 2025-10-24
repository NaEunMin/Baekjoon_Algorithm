import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
            첫째 줄 ---> 진짜 약수의 개수
            둘째 줄 ---> N의 진짜 약수
            N ===> 2 <= N <= 1.000,000
            N ===> N이 A의 배수
            A ==> A가 1과 N이 아니여야 함.
         */
        int count; //첫째 줄인 N의 진짜 약수의 개수
        Scanner scanner = new Scanner(System.in);
        count = scanner.nextInt();
        int numArray[] = new int[count];

        for(int i=0; i< count; i++){
            int num = scanner.nextInt();
            numArray[i] = num;
        }

        Arrays.sort(numArray);
        System.out.println(numArray[0] * numArray[numArray.length-1]);
    }
}
