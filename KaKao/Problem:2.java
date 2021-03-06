public class Main{
	public static void main(String[] args){
		String[] inputStr = {"1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"};

		for(String str : inputStr)
			System.out.println(Scoring(str));
	}
	
	private static int Scoring(String inputStr){
		String[] scores = inputStr.split("[A-Z](\\*)?(\\#)?");	//score 분리
		String[] command = inputStr.split("\\d+");	//command분리
		int result[] = new int[3];
		
		for(int i = 0; i < 3; i++){
			if(command[i+1].length() != 0){
				if(command[i+1].charAt(0) == 'S')
					result[i] = Integer.parseInt(scores[i]);
				else if(command[i+1].charAt(0) == 'D'){
					result[i] = Integer.parseInt(scores[i]);
					result[i] *= result[i];
				}
				else if(command[i+1].charAt(0) == 'T'){
					result[i] = Integer.parseInt(scores[i]);
					result[i] *= result[i] * result[i];
				}
			}
			if(command[i+1].length() == 2){
				if(command[i+1].charAt(1) == '*'){
					for(int j = i; j >= i-1 && j >= 0; j--)
						result[j] *= 2;
				}else if(command[i+1].charAt(1) == '#'){
					result[i] *= -1;
				}
			}
		}
		int total = 0;
		for(int i : result)
			total += i;
		
		return total;
	}
}
