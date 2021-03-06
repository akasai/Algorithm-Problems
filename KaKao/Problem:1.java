import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		/* input 고정 */
		int size = 5;
		int arr1[] = {9,20,28,18,11};
		int arr2[] = {30,1,21,17,28};

		String ret[] = new String[size];  //최종 결과

		for(int i = 0; i < size; i++)
			ret[i] = toBinary(arr1[i] | arr2[i], size); //10진수 -> 2진수 문자열

		for(String r : ret)
			System.out.println(r);	
	}
	public static String toBinary(int n, int size){
		String ret = new String();
		int a = 0;

		for(int i = size-1; i >= 0; --i){
			a = n >> i & 1;
			if(a == 0)
				ret += " ";
			else
				ret += "#";
		}

		return ret;
	}
}
