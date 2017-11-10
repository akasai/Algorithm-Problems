import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    int a[] = new int[8];
    int asc = 0, des = 0;

    for(int i = 0; i < 8; i++)	a[i] = s.nextInt();

    for(int i = 0; i < 8; i++){
      if(a[i] == i+1)			asc++;
      else if(a[i] == 8-i)	des++;
    }


    if(asc == 8)		System.out.println("ascending");
    else if(des == 8)	System.out.println("descending");
    else				System.out.println("mixed");
  }
}
