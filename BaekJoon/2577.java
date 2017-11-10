import java.util.Scanner;

public class Main{
    public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      int cnt[] = new int[10];

      int a = s.nextInt();
      int b = s.nextInt();
      int c = s.nextInt();

      int total = a * b * c;

      for(int i = total; i > 0; i /=10){
        int num = i % 10;
        cnt[num]++;
      }

      for(int i: cnt)
        System.out.println(i);
      }
}
