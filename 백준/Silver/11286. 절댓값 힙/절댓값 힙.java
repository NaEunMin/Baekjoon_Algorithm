import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {

            //큐에 정수가 추가되는 규칙을 정의한다.
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            //절대값이 같을 때 작은 정수 우선
            if(first_abs == second_abs){
                return o1 > o2 ? 1 : -1;
            }
            //절대값 작은 데이터 우선
            return first_abs - second_abs;
        });

        for(int i = 0; i < N; i++){
            int request = Integer.parseInt(br.readLine());
            if(request == 0){ //0이 입력되면
                if(myQueue.isEmpty()){ //큐가 비어있다면 0을 출력하고
                    System.out.println("0");
                } else { //큐가 비어있지 않다면 가장 작은 절대값을 가지는 정수를 출력한다.
                    System.out.println(myQueue.poll());
                }
            } else { //입력이 0이 아니면 큐에 정수를 추가한다.
                myQueue.add(request);
            }
        }

    }
}