import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();

        String[] range = answer.split("-");
        int result = 0;

        for (int i = 0; i < range.length; i++) {
            int sum = 0;
            String[] numbers = range[i].split("\\+");

            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }

            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);
    }
}
