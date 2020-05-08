import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class BikeTour {
    public static void main(String[] args) {
        File fileInput = new File("input.txt");
        try {
            Scanner input = new Scanner(fileInput);

            int testCases = input.nextInt();
            int checkpoints;
            int[] n;
            for (int i = 0; i < testCases; i++) {
                checkpoints = input.nextInt();
                n = new int[checkpoints];
                //System.out.println("Checkpoints: " + checkpoints);
                int j = 0;
                while (input.hasNextInt()) {
                    if (j == checkpoints) {
                        break;
                    }
                    n[j] = input.nextInt();
                    j++;
                }
                //System.out.println(Arrays.toString(n));
                System.out.println("Case #" + (i + 1) + ": " + findPeak(n));
            }


        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }
    }

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
