import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int cnt = sc.nextInt();
		int ret = sc.nextInt();
		int coins[] = new int[cnt];


		for(int i = 0; i < cnt; i++)
		coins[i] = sc.nextInt();

		System.out.println(Coin(coins, ret));
	}
	private static int Coin(int[] c, int max){
		int DP[] = new int[max+1];
		DP[0] = 1;	//초기화
		
		for(int i = 0; i < c.length; i++){
			for(int n = 1; n <= max; n++){
				if(n-c[i] >= 0)	DP[n] += DP[n-c[i]];	//누적된 총 경우의 수이므로 +=연산
			}
		}
		return DP[max];
	}
}
