import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        int n; //배열의 크기를 지정
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] a = new int[n]; //문제의 A 배열
        int[] b = new int[n]; //문제의 B 배열
        //for문으로 n번 입력받기.
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt(); //A배열의 값을 입력 받는다.
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt(); //B배열의 값을 입력 받는다.
        }

        //A배열을 오름차순 정렬한다.
        Arrays.sort(a);

        //내림차순한 B배열의 인덱스를 저장할 배열 생성
        Integer[] temp = new Integer[n];
        for (int i = 0; i < n; i++) {
            temp[i] = i;
        }

        //compare는 Integer타입만 가능하다.
        //오름차순으로 정렬하고 싶다면 ex) 매개변수 i,j -> compare 매개변수 i,j
        //내림차순으로 정렬하고 싶다면 ex) 매개변수 i,j -> compare 매개변수 j,i
        //java가 알아서 i와 j는 정해서 알아서 정렬해준다.
        Arrays.sort(temp, (i, j) -> Integer.compare(b[j], b[i]));

        // A의 작은 값들을 B의 큰 값 자리에 맞게 매핑
        int[] A_reordered = new int[n];
        for (int i = 0; i < n; i++) {
            A_reordered[temp[i]] = a[i];
        }
//        i	    a[i]	temp[i]	A_reordered[temp[i]] = a[i]
//        0	    0	    2	    A_reordered[2] = 0
//        1	    1	    1	    A_reordered[1] = 1
//        2	    1	    3	    A_reordered[3] = 1
//        3	    1	    0	    A_reordered[0] = 1
//        4	    6	    4	    A_reordered[4] = 6
//A_reordered[] => 1 1 0 1 6
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += A_reordered[i] * b[i];
        }
        System.out.println(result);
    }
}