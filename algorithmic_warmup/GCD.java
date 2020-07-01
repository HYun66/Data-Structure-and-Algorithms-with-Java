import java.util.*;

public class GCD {
  private static int gcd(int a, int b) {
    // Naive Algorithm:
    // if (b == 0) {
    //   return a;
    // }
    // int current_gcd = 1;
    // for(int d = 2; d <= a && d <= b; ++d) {
    //   if (a % d == 0 && b % d == 0) {
    //     if (d > current_gcd) {
    //       current_gcd = d;
    //     }
    //   }
    // }
    
    if (b == 0) {
      return a;
    }

    int b_pre = 1;
    while (b != 0) {
      b_pre = b;
      b = a % b;
      a = b_pre;  
    }

    return a;

  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }
}
