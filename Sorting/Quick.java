import java.util.Random;

public class Main{
  public static void main(String[] args){
    Random r = new Random();
    
    int a[] = new int[10];
    
    for(int i = 0; i < 10; i++)
      a[i] = r.nextInt(100);
      
    Quick(a);
  }
/*
 * Quick sorting
 * Best : O(nlogn)
 * Avg  : O(nlogn)
 * Worst: O(n^2)
 */
 private static void Quick(int[] a, int left, int right){
  if(right - left > 0){
    int q = Partition(a, left, right);
    Quick(a, left, q-1);
    Quick(a, q+1, right);
  }
 }
 private static int Partition(int[] a, int left, int right){
  int low = left+1;
  int high = right;
  int pivot = a[left];
  
  while(low < high){
    while(low <= right && a[low] < pivot) low++;
    while(high >= left && a[high] > pivot)  high--;
    
    if(low < high){
      int tmp = a[low];
      a[low] = a[high];
      a[high] = tmp;
    }
  }
  int temp = a[left];
  a[left] = a[high];
  a[high] = temp;
  
  return high;
 }
}
