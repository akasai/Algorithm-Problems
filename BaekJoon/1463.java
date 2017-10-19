import java.util.Scanner;

public class Main{
  public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		System.out.println(DivDP(a));
	}
    public static int MIN(int a, int b){
		return a<=b?a:b;
	}
	/////////////////////BaekJoon:1463///////////////////
	private static int DivDP(int n){
		int d_DP[] = new int[n+1];
		d_DP[1] = 0;
		for(int i = 2; i <= n; i++){
			d_DP[i] = d_DP[i-1] + 1;
			if(i%3 == 0)
				d_DP[i] = MIN(d_DP[i], d_DP[i/3] + 1);

			if(i%2 == 0)
				d_DP[i] = MIN(d_DP[i], d_DP[i/2] + 1);
		}
		return d_DP[n];
	}
}
