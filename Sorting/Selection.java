import java.util.Random;

public class Main{
  public static void main(String[] args){
    Random r = new Random();
    int a[] = new int[10];

    for(int i = 0; i < 10; i++)
      a[i] = r.nextInt(100);
    selection(a);
  }
  private static void selection(int[] a){
    int size = a.length;
    int min = 0;
    
    for(int i = 0; i < size-1; i++){
      min = i;
      for(int j = i+1; j < size; j++){
        if(a[min] > a[j])
          min = j;
      }
            
      int tmp = a[min];
      a[min] = a[i];
      a[i] = tmp;
    }
  }
}
