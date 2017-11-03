public class Main{
  public static void main(String[] args){
    LPS("ACTAGGAM");
  }
  private static int LPS(String input){
    int size = input.length(); 
    int maxLength = 1;  //각각의 글자는 길이 1의 회문
		int DP[][] = new int[size][size];	//DP[i][j] : i~j까지 회문의 길이
    
		//초기화
		for(int i = 0; i < size; i++){
			DP[i][i] = 1;
			//인접글자간 회문확인
			if(i + 1 < size && input.charAt(i) == input.charAt(i+1)){
				DP[i][i+1] = 2;
				maxLength = 2;
			}
		}
		
		int j = 0;
		for(int g = 3; g <= size; g++){ //갭 3부터 확인
			for(int i = 0; i < size-g+1; i++){
				j = i + g - 1;
				
				if(input.charAt(i) == input.charAt(j) && DP[i+1][j-1] != 0){
					DP[i][j] = g;
					maxLength = g;  //최장회문길이
				
					System.out.println(String.format("Gap: %d, Palindrome: %s", g, input.substring(i, j+1)));
				}
			}
		}
  }
}
