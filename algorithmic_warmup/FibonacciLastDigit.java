import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        // Naive Algorithm:
        // if (n <= 1)
        //     return n;

        // int previous = 0;
        // int current  = 1;

        // for (int i = 0; i < n - 1; ++i) {
        //     int tmp_previous = previous;
        //     previous = current;
        //     current = tmp_previous + current;
        // }

        // return current % 10;
        
        if (n <= 1){
            return n;
          } else {
            int F_array[] = new int[n+1];
            F_array[0] = 0;
            F_array[1] = 1;
      
            for (int i = 2; i < F_array.length; ++i) {
              F_array[i] = (F_array[i-1] + F_array[i-2]) % 10;
            }
            return F_array[n];
          }

    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

