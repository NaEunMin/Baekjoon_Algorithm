import java.util.Scanner;

public class Main {
    static int[] myArr;
    static int[] checkArr;
    static int checkSecret;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt(); //입력받을 문자열의 길이
        int P = scanner.nextInt(); //비밀번호로 사용할 부분문자열의 길이

        int result = 0; //가능한 비밀번호 카운트 변수
        checkSecret = 0; //조건에 맞는 비밀번호 개수

        char[] arr = new char[S]; //입력받을 문자열
        checkArr = new int[4]; //체크 기준 문자
        myArr = new int[4]; //현재 내 부분문자열 상태 체크 배열

        arr = scanner.next().toCharArray();

        for (int i = 0; i < checkArr.length; i++) {
            checkArr[i] = scanner.nextInt();
            if (checkArr[i] == 0) {
                checkSecret++; //이미 0이면 문자열에 없어도 되는 것이니 ++진행.
            }
        }
//===========================================> 지금까지 입력받았음
        for (int i = 0; i < P; i++) {
            add(arr[i]);
        }

        if (checkSecret == 4) {
            result++;
        }

        //슬라이딩윈도우
        /*
            P부터 시작하는 이유는 위쪽 반복문에 P직전까지 다루었으므로 해당 반복문에서 P부터 시작한다면
            한 칸 나아가는 효과가 있다.

            매 연산 시행 후 checkSecret을 검사하여 result 연산을 해주어야한다.
        */
        for (int i = P; i < S; i++) {
            int j = i - P;
            add(arr[i]);
            remove(arr[j]);
            if(checkSecret == 4) {
                result++;
            }
        }

        System.out.print(result);
    }

    private static void remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }

    //문자를 가져와서 각종 연산들을 진행한다.
    /*
        1. 문자가 A일때, myArr의 A상태를 증가시킨다.
        2. myArr, checkArr을 비교한다.
            같을때만 checkSecret을 증가시켜야한다. myArr이 더 크다고 조건을 걸면 나중에 추가로
            들어오는 문자에 대해서도 checkSecret을 연산하기에 부적절한 상황이 연출된다.
     */
    private static void add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }
}