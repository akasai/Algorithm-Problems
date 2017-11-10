import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    for(int i = 0; i < n; i++)
	System.out.println(game(s.next()));
  }
  private static int game(String input){
    int score = 0;
    int total = 0;

    for(int i = 0; i < input.length(); i++){
      if(input.charAt(i) == 'O'){
        score++;
        total += score;
      }else
        score = 0;
     }

     return total;
   }
}
