#include <stdio.h>

int main() {
    int n, i;
    printf("Enter the number of bits in the data: ");
    scanf("%d", &n);

    int data[n];
    printf("Enter the data bits (0s and 1s only):\n");
    for (i = 0; i < n; i++) {
        scanf("%d", &data[i]);
    }

    int stuffed[50], j = 0, count = 0;
    for (i = 0; i < n; i++) {
        stuffed[j++] = data[i];
        if (data[i] == 1) {
            count++;
            if (count == 5) {
                stuffed[j++] = 0; // Insert a 0 after 5 consecutive 1s
                count = 0;
            }
        } else {
            count = 0;
        }
    }

    printf("Stuffed Data: ");
    for (i = 0; i < j; i++) {
        printf("%d", stuffed[i]);
    }
    printf("\n");

    return 0;
}
