// code 1
// import java.util.Arrays;
// import java.util.Scanner;

// public class apartments {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             int n = sc.nextInt();
//             int m = sc.nextInt();
//             int k = sc.nextInt();

//             int[] req_size = new int[n];
//             int[] ava_size = new int[m];

//             for (int i = 0; i < n; i++) req_size[i] = sc.nextInt();
//             for (int i = 0; i < m; i++) ava_size[i] = sc.nextInt();

//             Arrays.sort(req_size);
//             Arrays.sort(ava_size);

//             int i = 0, j = 0, assigned = 0;

//             while (i < n && j < m) {
//                 if (ava_size[j] < req_size[i] - k) {
//                     j++; 
//                 } else if (ava_size[j] > req_size[i] + k) {
//                     i++; 
//                 } else {
//                     assigned++; 
//                     i++;
//                     j++;
//                 }
//             }

//             System.out.println(assigned);
//         }
//     }
// }

//optimal code 1
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Arrays;
// import java.util.StringTokenizer;

// public class apartments {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
        
//         int n = Integer.parseInt(st.nextToken());
//         int m = Integer.parseInt(st.nextToken());
//         int k = Integer.parseInt(st.nextToken());

//         int[] req_size = new int[n];
//         int[] ava_size = new int[m];

//         // Read required sizes
//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < n; i++) {
//             if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
//             req_size[i] = Integer.parseInt(st.nextToken());
//         }

//         // Read available sizes
//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < m; i++) {
//             if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
//             ava_size[i] = Integer.parseInt(st.nextToken());
//         }

//         Arrays.sort(req_size);
//         Arrays.sort(ava_size);

//         int i = 0, j = 0, assigned = 0;

//         while (i < n && j < m) {
//             if (ava_size[j] < req_size[i] - k) {
//                 j++;
//             } else if (ava_size[j] > req_size[i] + k) {
//                 i++;
//             } else {
//                 assigned++;
//                 i++;
//                 j++;
//             }
//         }

//         System.out.println(assigned);
//     }
// }


//best of all
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class apartments {
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int bId = 0, size = 0;
        private final InputStream in;

        FastScanner(InputStream in) { this.in = in; }

        private int readByte() throws IOException {
            if (bId >= size) {
                size = in.read(buffer);
                bId = 0;
                if (size == -1) return -1;
            }
            return buffer[bId++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            while ((c = readByte()) <= 32 && c != -1);
            if (c == '-') { sign = -1; c = readByte(); }
            while (c > 32 && c != -1) {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();

        int[] req = new int[n];
        int[] ava = new int[m];

        for (int i = 0; i < n; i++) req[i] = fs.nextInt();
        for (int i = 0; i < m; i++) ava[i] = fs.nextInt();

        int assigned = 0;

        // 🔥 Special optimization: If one of them is tiny, do direct scan
        if (m <= 5) {
            // Very few apartments - check each directly
            for (int aj : ava) {
                for (int rq : req) {
                    if (Math.abs(aj - rq) <= k) {
                        assigned++;
                        break; // Only one applicant per apartment
                    }
                }
            }
            System.out.println(assigned);
            return;
        } else if (n <= 5) {
            // Very few applicants - check directly
            for (int rq : req) {
                for (int aj : ava) {
                    if (Math.abs(aj - rq) <= k) {
                        assigned++;
                        break;
                    }
                }
            }
            System.out.println(assigned);
            return;
        }

        // ✅ Normal case: Sort & two-pointer
        Arrays.sort(req);
        Arrays.sort(ava);

        int i = 0, j = 0;
        while (i < n && j < m) {
            if (ava[j] < req[i] - k) {
                j++;
            } else if (ava[j] > req[i] + k) {
                i++;
            } else {
                assigned++;
                i++;
                j++;
            }
        }

        System.out.println(assigned);
    }
}
