import java.util.*;
import java.util.Arrays;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int numRefills = 0, currentRefills = 0, lastRefill = 0;
        int n = stops.length - 1;

        if (dist <= tank) return 0;
 
        while (currentRefills < n) {
            lastRefill = currentRefills;
     
            while (currentRefills < n && (stops[currentRefills + 1] - stops[lastRefill] <= tank)) {
                currentRefills += 1;
            } 

            if (currentRefills == lastRefill) return -1;
            if (currentRefills < n) {
                numRefills += 1;
            }
        }
   
        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n + 2];
        stops[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            stops[i] = scanner.nextInt();
        }
        stops[n + 1] = dist;

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
