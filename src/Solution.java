import java.util.Scanner;

/**
 * @author Alan Choi
 */
public class Solution {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //System.out.print("T: ");
        int testCases = input.nextInt();
        int checkpoints;
        int[] n;
        for (int i = 0; i < testCases; i++) {
            //System.out.print("N: ");
            checkpoints = input.nextInt();
            n = new int[checkpoints];
            //System.out.println("Checkpoints: " + checkpoints);
            for (int j = 0; j < checkpoints; j++) {
                //System.out.print("H" + (j + 1) + ": ");
                n[j] = input.nextInt();
            }
            //System.out.println(Arrays.toString(n));
            System.out.println("Case #" + (i + 1) + ": " + findPeak(n));
        }
    }

    /**
     * @param n input for checkpoints
     * @return number of peaks between the checkpoints
     */
    public static int findPeak(int[] n) {
        if (n.length < 3 || n.length > 100) {
            throw new IllegalArgumentException();
        }

        int peaks = 0;
        for (int i = 1; i < n.length - 1; i++) {
            if (n[i - 1] < n[i] && n[i] > n[i + 1]) {
                peaks += 1;
            }
        }
        return peaks;
    }
}
