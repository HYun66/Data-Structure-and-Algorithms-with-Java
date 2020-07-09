import java.util.*;
import java.util.Arrays;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int numRefills = 0, currentRefills = 0, lastRefill = 0;
        int n = stops.length;
        int[] allStops = Arrays.copyOf(stops, n + 1);
        allStops[n] = dist;
        
        if (dist <= tank) return 0;
 
        while (currentRefills < n) {
            lastRefill = currentRefills;
            if (currentRefills == 0) {
                if (allStops[0] <= tank) {
                    currentRefills += 1;
                }
            }
            
            while (currentRefills < n && (allStops[currentRefills+1] - allStops[lastRefill] <= tank)) {
                currentRefills += 1;
            } 

            if (currentRefills == lastRefill) return -1;
            if (currentRefills < n) {
                numRefills += 1;
            }
        }
        if (currentRefills == n) {
            if (allStops[currentRefills] - allStops[lastRefill] <= tank) {
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
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
