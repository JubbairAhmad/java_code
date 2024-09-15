import java.util.Scanner;
public class Average{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student s1[] = new Student[n];
        for(int i=0;i<n;i++){
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            float c = sc.nextFloat();
            s1[i] = new Student(a,b,c);
        }
        float h = findAvg(s1); 
        if (h > 0){
            System.out.printf("%.2f",h);
        }

    }
    public static float findAvg(Student[] s1){
        float avg = 0;
        float cnt = 0;
        for(int i =0;i<s1.length;i++){
            cnt = cnt + s1[i].getStdmarks();
        }
        avg = cnt/s1.length;
        return avg;
    }
}
class Student{
    private int stdid;
    private String stdname;
    private float stdmarks;
    public Student(int stdid,String stdname,float stdmarks){
        this.stdid = stdid;
        this.stdname = stdname;
        this.stdmarks = stdmarks;
    }
    // public void setStdid(int stdid){
    //     this.stdid = stdid;
    // }
    // public void setStdname(String stdname){
    //     this.stdname = stdname;
    // }
    // public void setStdmarks(float stdmarks){
    //     this.stdmarks = stdmarks;
    // }
    public int getStdid(){
        return stdid;
    }
    public String getStdname(){
        return stdname;
    }
    public float getStdmarks(){
        return stdmarks;
    }


}
