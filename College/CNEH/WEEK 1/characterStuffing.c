#include <stdio.h>
#include <string.h>

#define FLAG 'F'
#define ESC  'E'

int main() {
    char input[100], stuffed[200];
    int i, j = 0;

    printf("Enter data (max 50 characters): ");
    fgets(input, sizeof(input), stdin);

    // Remove the newline if present
    input[strcspn(input, "\n")] = '\0';

    stuffed[j++] = FLAG;

    for (i = 0; i < strlen(input); i++) {
        if (input[i] == FLAG || input[i] == ESC) {
            stuffed[j++] = ESC;
        }
        stuffed[j++] = input[i];
    }

    stuffed[j++] = FLAG;
    stuffed[j] = '\0';

    printf("Stuffed data to transmit: ");
    for (i = 0; i < j; i++) {
        printf("%c ", stuffed[i]);
    }

    return 0;
}
