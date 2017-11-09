public class Main{
  public static void main(String[] args){
    int bool[] = new int[10035+1];

    for(int i = 1; i <= 10000; i++)
      bool[d(i)] = 1;

    for(int i = 1; i <= 10000; i++)
      if(bool[i] != 1)
        System.out.println(i);
  }
  private static int d(int n){
    int sum = n;
    for(int i = n; i > 0; i/=10)
      sum += i%10;
    return sum;
  }
}
