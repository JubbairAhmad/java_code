import java.util.*;

public class rotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        int k = 3;
        for (int i = 0; i<n;i++){
            int m = i+k;
            if (m >= n){
                m = 0;
            }else{
                arr[m] = arr[i];
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
}
