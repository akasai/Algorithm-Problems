import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println(EasyStair(sc.nextInt()));
	}
    	public static int EasyStair(int n){
		int mod = 1000000000;	//나누기
		int DP[][] = new int[n][10];	//DP

		for(int i = 1; i < 10; i++) DP[0][i] = 1;	//DP초기화:한자리 숫자 초기화

		for(int i = 1; i < n; i++){	//자릿수만큼
			for(int j = 0; j < 10; j++){
				if(j == 0) //첫째자리수 일때
					DP[i][j] = DP[i-1][j+1] % mod;
				else if(j == 9)	//마지막자리수 일때
					DP[i][j] = DP[i-1][j-1] % mod;
				else	//나머지자리수 일때
					DP[i][j] = (DP[i-1][j-1] + DP[i-1][j+1]) % mod;
			}
		}

		int sum = 0;
		for(int i: DP[n-1])
			sum = (sum + i) % mod;
		return sum % mod;
	}
}
