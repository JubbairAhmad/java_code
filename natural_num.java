
import java.util.Scanner;

public class natural_num {
    public static void main(String[] args) {
        int sums = 0;
        Scanner sc = new Scanner(System.in);
        int range = sc.nextInt();
        System.out.println("entered number :"+range);
        for (int i = 0; i < range; i++) {
            sums += i;
        }
        System.out.println("the sum of entered numbers are :"+sums);
    }
}
