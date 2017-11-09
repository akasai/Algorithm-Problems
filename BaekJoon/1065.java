import java.util.Scanner;
public class Main{
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    int max = s.nextInt();
    if(max == 1000) max--;

    int cnt = 0;
    if(max < 100)
      cnt = max;
    else{
      cnt = 99;
      for(int i = 100; i <= max; i++)
        if(isHan(i))
          cnt++;
    }
    System.out.println(cnt);
  }
  private static boolean isHan(int n){
    int tmp[] = new int[3];

    for(int i = n,  j = 2; i > 0; i /= 10, j--)
      tmp[j] = i%10;

    return tmp[1]-tmp[0] == tmp[2]-tmp[1]; 
  }
}
