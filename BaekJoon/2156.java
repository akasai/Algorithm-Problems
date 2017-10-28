import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);

		int cup = s.nextInt();
		int wine[] = new int[cup];
		for(int i = 0; i < cup; i++) wine[i] = s.nextInt();

		System.out.println(solution(wine));
	}
	public static int MAX(int a, int b){
		return a>=b? a:b;
	}
	private static int solution(int[] w){
		if(w.length == 1)
			return w[0];
		else if(w.length == 2)
			return w[0]+w[1];

		int DP[] = new int[w.length];
		DP[0] = w[0];
		DP[1] = w[0] + w[1];

		for(int i = 2; i < w.length; i++){
			if(i == 2) DP[i] = MAX(w[i]+w[i-1], w[i]+w[i-2]);
			else DP[i] = MAX(w[i]+w[i-1]+DP[i-3], w[i]+DP[i-2]);

			DP[i] = MAX(DP[i], DP[i-1]);
		}

		return DP[w.length-1];
	}
}
