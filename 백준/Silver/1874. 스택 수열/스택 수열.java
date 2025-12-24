import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //수열의 크기

        int[] arr = new int[n]; //입력받을 수열
        Stack<Integer> stack = new Stack<>();
        boolean flag = true;

        //StringBuilder보다 안전하다. 내부적으로 synchronized가 적용
        StringBuffer result = new StringBuffer();


        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) { //만약 입력받은 연산의 수가 오름차순 자연수(num)보다 크거나 같다면
                while (arr[i] >= num) { //오름차순 수가 arr[i]에 도달할때까지 push를 진행한다. 1,2,3,4....
                    stack.push(num++);
                    result.append("+\n"); //push를 진행하였으니 +\n으로 문자열에 더해준다.
                }
                stack.pop(); //arr[i] == num이 되었다면 pop을 진행한다.
                result.append("-\n"); //pop을 진행하였으므로 -\n을 문자열에 더해준다.
            }
            else{ //오름차순의 수가 arr[i]보다 큰 경우
                int popNum = stack.pop();
                if(popNum > arr[i]){
                    System.out.print("NO");
                    flag = false;
                    break;
                }
                else{
                    result.append("-\n");
                }
            }
        }
        if(flag){
            System.out.print(result.toString());
        }

    }
}