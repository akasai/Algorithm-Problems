public class Main{
  public static void main(String[] args){
    LPS("LEVEL"); 
  }
  private static int LPS(String input){
    int size = input.length(); 
		int DP[][] = new int[size][size];	//DP[i][j] : i~j까지 회문의 길이
		//초기화
		for(int i = 0; i < size; i++){
			DP[i][i] = 1;
			//인접한 글자간 회문 확인
			if(i+1 < size && input.charAt(i) == input.charAt(i+1))	DP[i][i+1] = 2;
		}
		
		int j = 0;
		for(int g = 2; g <= size; g++){	//글자들 사이에 간격
			for(int i = 0; i < size-g+1; i++){  //세로 인덱스
				j = i + g - 1;  //가로 인덱스
				
				if(input.charAt(i) == input.charAt(j))	DP[i][j] = DP[i+1][j-1] + 2;  //회문일 경우
				else                                    DP[i][j] = MAX(DP[i+1][j], DP[i][j-1]); //회문이 아닐 
			}
		}
		return DP[0][size-1];
  }
}
