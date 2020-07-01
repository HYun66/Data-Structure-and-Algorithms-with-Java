import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {

        // Naive Algorithm:
        // for (int first = 0; first < n; ++first) {
        //     for (int second = first + 1; second < n; ++second) {
        //         max_product = Math.max(max_product,
        //             (long)numbers[first] * (long)numbers[second]);
        //     }
        // }

        long max_product = 0;
        int n = numbers.length;
        int index_1 = 0;
        int index_2 = 0;
        for (int first = 1; first < n; ++first) {
            if (numbers[first] > numbers[index_1]) {
                index_1 = first;
            }
        }

        if (index_1 == 0) {
            index_2 = 1;
        } else {
            index_2 = 0;
        }

        for (int second = 0; second < n; ++second) {
            if (second != index_1 && numbers[second] > numbers[index_2]) {
                index_2 = second;
            }
        }

        max_product = (long)(numbers[index_1]) * (long)(numbers[index_2]);

        return max_product;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
