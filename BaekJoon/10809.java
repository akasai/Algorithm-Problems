import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    int cnt[] = new int[26];

    for(int i = 0; i < cnt.length; i++) cnt[i] = -1;
    String str = s.next();

    for(int i = 0; i < str.length(); i++){
      int idx = (int)str.charAt(i)-97;
      if(cnt[idx] == -1)
        cnt[idx] = i;
    }
    for(int i: cnt)
      System.out.print(String.format("%d ", i));
  }
}
