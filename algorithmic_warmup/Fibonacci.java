import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {

    // Naive Algorithm:
    // if (n <= 1)
    //   return n;
    // return calc_fib(n - 1) + calc_fib(n - 2);

    if (n <= 1){
      return n;
    } else {
      long F_array[] = new long[n+1];
      F_array[0] = 0;
      F_array[1] = 1;

      for (int i = 2; i < F_array.length; ++i) {
        F_array[i] = F_array[i-1] + F_array[i-2];
      }
      return F_array[n];
    }
    
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
