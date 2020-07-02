import java.util.*;

public class FibonacciHuge {
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

    private static long getFibonacci(long n, long m) {
        if (n <= 1)
            return n % m;
        long remainder = n % getPisanoPeriod(m);

        long first = 0;
        long second = 1;
    
        long res = remainder;
    
        for (int i = 1; i < remainder; i++) {
            res = (first + second) % m;
            first = second;
            second = res;
        }

        return res % m;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacci(n, m));
    }
}

