import java.util.Arrays;

public class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        //2개씩 붙여서 비교하여 더 앞에 와야하는 정수를 골라 정렬한다.
        /*
            cmapareTo() : 결과가 음수면 b가 앞, 결과가 양수면 a가 앞
            (b+a)가 크면 결과가 음수, (b+a)가 작으면 결과가 양수
         */
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));


        //정렬을 진행했는데 첫 번째 원소가 0이라면 그 뒤 정수들도 다 0일 것이다.
        if (arr[0].equals("0")) {
            return "0";
        }

        return String.join("", arr);
    }
}