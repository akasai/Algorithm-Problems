import java.util.Random;

public class Main{
  public static void main(String[] args){
    Random r = new Random();
		int a[] = new int[10];
		
		for(int i = 0; i < 10; i++) a[i] = r.nextInt(100);
		
		bubble(a);
  }
  /*
	 * Bubble Sorting
	 * Best : O(n^2)
	 * Avg  : O(n^2)
	 * Worst: O(n^2)
	 */
  private static void bubble(int[] a){
    int size = a.length;
    
    for(int i = size-1; i > 0; i--){
      for(int j = 0; j < i; j++){
        if(a[i] > a[i+1]){
          int tmp = a[j+1];
          a[j+1] = a[j];
          a[j] = temp;
        }
      }
    }
  }
}
