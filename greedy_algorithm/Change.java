import java.util.*;

public class Change {
    private static int getChange(int m) {
        int numTen = 0, numFive = 0, numOne = 0;
        if (m < 5)
            return m;
        else if (m >= 5 && m < 10)
            return m - 4;
        else {
            numTen = m / 10;
            numFive = (m % 10) / 5;
            numOne = (m % 10) % 5;
            return numTen + numFive + numOne;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

