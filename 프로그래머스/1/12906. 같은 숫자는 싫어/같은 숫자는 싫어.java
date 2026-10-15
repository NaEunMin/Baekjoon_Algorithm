import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = new int[arr.length];
        int index = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int j : arr) {
            queue.offer(j);
        }

        for (int i = 0; i < arr.length; i++) {
            int current = queue.poll();
            if (queue.isEmpty() || queue.peek() != current) {
                answer[index++] = current;
            }
        }
        return Arrays.copyOf(answer, index);
    }
}