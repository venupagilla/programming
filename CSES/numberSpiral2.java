import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class numberSpiral2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder st = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] parts = br.readLine().split(" ");
            long x = Long.parseLong(parts[0]);
            long y = Long.parseLong(parts[1]);

            long max = Math.max(x, y);
            long base = (max - 1) * (max - 1);
            long addval;

            if (max % 2 == 0) {
                // even spiral layer: count in reverse
                if (y == max) {
                    addval = base + x;
                } else {
                    addval = base + 2 * max - y;
                }
            } else {
                // odd spiral layer: count forward
                if (x == max) {
                    addval = base + y;
                } else {
                    addval = base + 2 * max - x;
                }
            }

            st.append(addval).append("\n");
        }

        System.out.print(st);
    }
}
