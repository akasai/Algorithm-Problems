import java.util.Scanner;

public class Main{
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int line = sc.nextInt();
		
		int stairs[] = new int[line];
		
		for(int i = 0; i < line; i++)
			stairs[i] = sc.nextInt();
		
		System.out.println(Stairing(line, stairs));
	}
    public static int MAX(int a, int b){
		if(a >= b)	return a;
		else		return b;
	}
	/////////////////////BaekJoon:2579///////////////////
	private static int Stairing(int cnt, int[] s){
		int s_DP[] = new int[s.length];
		s_DP[0] = s[0];
		if(cnt == 1)	return s_DP[cnt-1];
		
		s_DP[1] = MAX(s[1] + s[0], s[1]);
		if(cnt == 2)	return s_DP[cnt-1];
		
		s_DP[2] = MAX(s[2] + s[1], s[2] + s_DP[0]);
		if(cnt == 3) return s_DP[cnt-1];
			
		for(int i = 3; i < cnt ; i++){
			s_DP[i] = MAX(s[i] + s[i-1] + s_DP[i-3], s[i] + s_DP[i-2]);
		}

		return s_DP[cnt-1];
	}
}
