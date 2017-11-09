import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();

		String a[] = str.split(" ");

		int cnt = 0;
		for(int i = 0; i < a.length; i++)
			if(!a[i].equals(""))
				cnt++;

		System.out.println(cnt);
	}
}
