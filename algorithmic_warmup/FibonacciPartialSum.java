import java.util.*;

public class FibonacciPartialSum {
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

    private static long getFibonacciSumLastDigit(long n, long m) {
        if (n <= 1)
            return n;

        long remainder = n % getPisanoPeriod(m);
        if (remainder <= 1)
            return remainder;

        long a = 0, b = 1, sum = 1, c = 1;
    
        for (int i = 2; i <= remainder; i++) {
            c = (a + b) % m;
            sum = (sum + c) % m;
            a = b % m;
            b = c;
        }

        return sum;
    }

    private static long getFibonacciPartialSum(long from, long to) {
        if (from <= 1) {
            if (from == to) {
                return from;
            } else {
                return getFibonacciSumLastDigit(to, (long)10);
            }
        }
    
        long lastDigitOfSumFrom = getFibonacciSumLastDigit(from-1, (long)100);
        long lastDigitOfSumTo = getFibonacciSumLastDigit(to, (long)1000);
        long result = Math.abs(lastDigitOfSumTo - lastDigitOfSumFrom) % 10;

        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}

