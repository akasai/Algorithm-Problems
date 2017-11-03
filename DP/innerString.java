public class Main{
  public static void main(String[] args){
	System.out.println(findWordsCount("ab", "acabdb"));
  }
  private static int findWordsCount(String s, String t){
	int s_length = s.length();
	int t_length = t.length();

	//비교 문자열이 없을때 : 일치 없음
	if(t_length == 0)	System.out.println("0");
	//대상 문자열이 없을때 : 전부 일치
	else if(s_length == 0)	System.out.println("1");

	int DP[][] = new int[s_length+1][t_length+1];		//DP

	for(int i = 0; i <= s_length; i++)	DP[i][0] = 0;	//일치 없음
	for(int i = 0; i <= t_length; i++)	DP[0][i] = 1;	//전부 일치

	for(int i = 1; i <= s_length; i++){
		for(int j = 1; j <= t_length; j++){
			if(s.charAt(i-1) == t.charAt(j-1))	DP[i][j] = DP[i-1][j-1] + DP[i][j-1];
			else					DP[i][j] = DP[i][j-1];
		}
	}
	return DP[s_length][t_length];
  }
}
