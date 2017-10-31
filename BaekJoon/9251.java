import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);

		String str1 = s.next();
		String str2 = s.next();

		System.out.println(findLCS(str1, str2));
	}
	private static int findLCS(String a, String b){
		int DP[][] = new int[b.length()+1][a.length()+1];

		for(int i = 1; i <= b.length(); i++){
			for(int j = 1; j <= a.length(); j++){
				if(a.charAt(j-1) == b.charAt(i-1))
					DP[i][j] = DP[i-1][j-1] + 1;
				else{
					if(DP[i][j-1] > DP[i-1][j])	DP[i][j] = DP[i][j-1];
					else				DP[i][j] = DP[i-1][j];
				}
			}
		}
		return DP[b.length()][a.length()];
	}
}
