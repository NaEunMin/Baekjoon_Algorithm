import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        /*
            배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려한다.
            1. 자르기
            2. 정렬
            3. k번째 수
         */
        for (int i = 0; i < commands.length; i++) {

            //배열을 잘라서 복사 후 temp에 대입
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            
            //오름차순 정렬
            Arrays.sort(temp);

            //k번째 수 뽑아서 answer에 저장
            answer[i] = temp[commands[i][2] - 1];

        }
        return answer;
    }
}