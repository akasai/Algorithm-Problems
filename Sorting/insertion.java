import java.util.Random;

public class Main{
  public static void main(String[] args){
    Random r = new Random();
    int a[] = new int[10];

    for(int i = 0; i < 10; i++)
      a[i] = r.nextInt(100);
    insertion(a);
  }
/*
 * Bubble Sorting
 * Best : O(n^2)
 * Avg  : O(n^2)
 * Worst: O(n^2)
 */
  private static void insertion(int[] a){
    int size = a.length;
    int key = 0;
    
    for(int i = 1; i < size; i++){
      key = a[i];
      for(int j = i-1; j >= 0 && key < a[j]; j--){
        a[j+1] = a[j];
        a[j] = key;
      }
    }
  }
}
