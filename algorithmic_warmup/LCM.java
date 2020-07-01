import java.util.*;

public class LCM {
  private static long lcm(int a, int b) {
    // Naive Algorithm:
    // for (long l = 1; l <= (long) a * b; ++l)
    //   if (l % a == 0 && l % b == 0)
    //     return l;

    // return (long) a * b;

    if (b == 0) {
      return 0;
    }

    int b_pre = 1;
    long ab = (long)a * (long)b;

    while (b != 0) {
      b_pre = b;
      b = a % b;
      a = b_pre; 
    }

    return (ab / a);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
