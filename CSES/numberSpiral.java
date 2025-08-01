public class numberSpiral {
    // Function to compute the value at position (Y, X) in the number spiral
    static void numberspiral(long Y, long X) {
        // If Y is greater than X, implying Yth row is the outer boundary
        if (Y > X) {
            // Compute the area of the inner square
            long ans = (Y - 1) * (Y - 1);
            long add;

            // Check parity of Y to determine if numbers are in increasing or decreasing order
            if (Y % 2 != 0) {
                // Add X to the area if Yth row is odd
                add = X;
            } else {
                // Add 2*Y - X to the area if Yth row is even
                add = 2 * Y - X;
            }

            // Print the final result
            System.out.println(ans + add);
        }
        // If X is greater than or equal to Y, implying Xth column is the outer boundary
        else {
            // Compute the area of the inner square
            long ans = (X - 1) * (X - 1);
            long add;

            // Check parity of X to determine if numbers are in increasing or decreasing order
            if (X % 2 == 0) {
                // Add Y to the area if Xth column is even
                add = Y;
            } else {
                // Add 2*X - Y to the area if Xth column is odd
                add = 2 * X - Y;
            }

            // Print the final result
            System.out.println(ans + add);
        }
    }

    // Driver Code
    public static void main(String[] args) {
        long Y = 2, X = 3;
        numberspiral(Y, X);
    }
}

// This code is contributed by akshitaguprzj3