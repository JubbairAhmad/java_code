import java.util.*;

public class array_list {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        int n = sc.nextInt();sc.nextLine();
        for(int i=0;i<n;i++){
            String s = sc.nextLine();
            names.add(s);
        }
        System.out.println(names);
    }
}
