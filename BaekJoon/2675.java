import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
		int cnt = s.nextInt();
		for(int i = 0; i < cnt; i++)
			QRcode(s.nextInt(), s.next());
  }
  private static void QRcode(int c, String str){
		String ret = new String();
		
		for(int i = 0; i < str.length(); i++)
			for(int j = 0; j < c; j++)
				ret += str.charAt(i);
		
		System.out.println(ret);
	}
}
