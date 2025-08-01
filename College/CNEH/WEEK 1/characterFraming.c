
#include <stdio.h>

int main() {
    int n;
    printf("Enter total number of data items: ");
    scanf("%d", &n);

    int data[n];
    printf("Enter the data items (integers): ");
    for(int i = 0; i < n; i++) {
        scanf("%d", &data[i]);
    }

    // Let's assume fixed frame size of 4 (excluding count)
    int frameSize = 4;
    int i = 0;

    printf("\nFramed data (Character Count Framing):\n");
    while (i < n) {
        int remaining = n - i;
        int currentFrameLen = remaining >= frameSize ? frameSize : remaining;
        printf("%d ", currentFrameLen + 1); // count = data + count byte itself

        for (int j = 0; j < currentFrameLen; j++) {
            printf("%d ", data[i + j]);
        }
        printf("\n");
        i += currentFrameLen;
    }

    return 0;
}
