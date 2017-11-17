import java.util.Random;

public class Main{
  public static void main(String[] args){
    Random r = new Random();
    int a[] = new int[11];
    
    for(int i = 0; i < a.length; i++)
      a[i] = r.nextInt(100);
      
    Sorting(a, 0, a.length-1);
  }
  /*
   * Merge sorting
   * Best : O(nlogn)
   * Avg  : O(nlogn)
   * Worst: O(nlogn)
   */
  private static void Sorting(int[] a, int left, int right){
    if(right-left > 0){   //배열의 길이가 1일 때
      int mid = (right+left)/2;
      Sorting(a, left, mid);  //좌측 배열 분할
      Sorting(a, mid+1, right); //우측 배열 분할
      Merge(a, left, mid, right); //배열 결합
    }
  }
  private static void Merge(int[] a, int left, int mid, int right){
    int sortedArray[] = new int[right+1]; //공간복잡도 최소화(필요한 최소의 공간만 할당)
    int left_idx = left;    //좌측배열의 시작 index
    int right_idx = mid+1;  //우측배열의 시작 index
    int sorted_idx = left;  //임시배열의 시작 index
    
    while(left_idx <= mid && right_idx <= right){ //한쪽의 배열이 끝날 때까지
      if(a[left_idx] <= a[right_idx])
        sortedArray[sorted_idx++] = a[left_idx++];
      else
        sortedArray[sorted_idx++] = a[right_idx++];
    }
    
    if(left_idx <= mid){
      for(int i = left_idx; i <= mid; i++)
        sortedArray[sorted_idx++] = a[i];
    }else{
      for(int i = right_idx; i <= right; i++)
        sortedArray[sorted_idx++] = a[i];
    }
    
    for(int i = left; i <= right; i++)
      a[i] = sortedArray[i];
  }
}
