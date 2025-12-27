import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String arr =  sc.nextLine();
        int [] myArr = new int [arr.length()];

        for(int i = 0; i < myArr.length; i++){
            myArr[i] = Integer.parseInt(arr.substring(i,i+1));
        }

        for(int i = 0; i < myArr.length; i++){
            int max = i;
            for(int j=i; j<myArr.length; j++){
                if(myArr[j] > myArr[max]){
                    max = j;
                }
            }

            if(myArr[i] < myArr[max]){
                int temp = myArr[i];
                myArr[i] = myArr[max];
                myArr[max] = temp;
            }
        }
        for(int i = 0; i < myArr.length; i++){
            System.out.print(myArr[i]);
        }
    }
}