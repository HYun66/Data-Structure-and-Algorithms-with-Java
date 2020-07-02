import java.beans.beancontext.BeanContextChild;
import java.util.*;

public class FibonacciSumLastDigit {
    private static long getPisanoPeriod(long m) {
        long a = 0, b = 1, c = a + b;
        int period = 0;
        for (int i = 0; i < m * m; i++) {
            c = (a + b) % m;
            a = b;
            b = c;
            if (a == 0 && b == 1) {
                period = i + 1;
                break;
            }
        }
        return period;
    }

    private static long getFibonacciSumLastDigit(long n) {
        if (n <= 1)
            return n;

        long remainder = n % getPisanoPeriod(10);
        if (remainder <= 1)
            return remainder;

        long a = 0, b = 1, sum = 1, c = 1;
    
        for (int i = 2; i <= remainder; i++) {
            c = (a + b) % 10;
            sum = (sum + c) % 10;
            a = b % 10;
            b = c;
        }

        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumLastDigit(n);
        System.out.println(s);
    }
}

