import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int c = 0,a;
        while(num > 0){
            a = num % 10;
            num = num / 10;
            if ((a%2) == 1){
                c = c + a;
            }
        }
        if (((c % 3) == 0) && ((c % 2) == 0)){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
}
