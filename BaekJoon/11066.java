import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
		int caseCNT = s.nextInt();
		
		for(int i = 0; i < caseCNT; i++){
			int numCNT = s.nextInt();
			int testCase[] = new int[numCNT];
			
			for(int j = 0; j < numCNT; j++)	testCase[j] = s.nextInt();
            
			System.out.println(solution(testCase));
		}
    }
    public static int MIN(int a, int b){
		return a <= b? a:b;
	}
    public static int sum(int[] a, int s, int e){
		if(s == 0)    return a[e];
		else          return a[e] - a[s-1];
	}
    private static int solution(int[] a){
		int size = a.length;
		int DP[][] = new int[size][size];
		int s[] = new int[size];
		
		s[0] = a[0];
		for(int i = 1; i < size; i++) s[i] += s[i-1] + a[i];
		
		for(int i = 0; i < size-1; i++) DP[i][i+1] = a[i] + a[i+1];
		
		for(int gap = 2; gap < size; gap++){
			for(int i = 0; i+gap < size; i++){
				int j = i+gap;
				DP[i][j] = Integer.MAX_VALUE;
				
				for(int k = i; k < j; k++){
					DP[i][j] = MIN(DP[i][k] + DP[k+1][j] + sum(s, i, j), DP[i][j]);
				}
			}
		}
		return DP[0][a.length-1];
	}
}
