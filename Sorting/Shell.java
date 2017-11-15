import java.util.Random;

public class Main{
  public static void main(String[] args){
    Random r = new Random();
    
    int a[] = new int[10];
    
    for(int i = 0; i < 10; i++)
      a[i] = r.nextInt(100);
      
    Shell(a);
  }
  private static void Shell(int[] a){
    int size = a.length;
    int key = 0;
    
    for(int gap = size/2; gap > 0; gap/=2){ //분할되는 부분배열의 기준
      if(gap%2 == 0) gap++;
      for(int start = 0; start < gap; start++){ //각 부분배열의 시작 Index
        /* Insertion */
        for(int i = start+gap; i < size; i+=gap){ //비정렬 구간
          key = a[i];
          for(int j = i-gap; i >= 0 && key < a[j]; j-=gap){ //정렬 구간
            a[j+gap] = a[j];
            a[j] = key;
          }
        }
      }
    }
  }
}
