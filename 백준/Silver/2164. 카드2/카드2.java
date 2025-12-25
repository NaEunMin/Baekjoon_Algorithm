import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 1~N의에서 N을 입력받음
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            q.poll(); //맨 위 정수 제거
            int x = q.poll(); //그 다음 맨위 정수 제거 후 저장
            q.add(x); //맨 아래로 넣기
        }

        System.out.println(q.peek());
    }
}