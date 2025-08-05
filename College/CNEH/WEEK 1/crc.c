#include <stdio.h>
#include <string.h>

int main() {
    char data[100], key[20];
    printf("Enter the data to be sent: ");
    scanf("%s", data); 

    printf("Enter the key: ");
    scanf("%s", key);

    int data_len = strlen(data);
    int key_len = strlen(key);

    for (int i = data_len; i < data_len + key_len - 1; i++) {
        data[i] = '0';
    }
    data[data_len + key_len - 1] = '\0';

    printf("Modified data ( Before checksum ): %s\n", data);

    char temp[120];
    strcpy(temp, data);

    for (int i = 0; i <= strlen(temp) - key_len; i++) {
        if (temp[i] == '1') {
            for (int j = 0; j < key_len; j++) {
                if(temp[i + j] == key[j]){
                    temp[i + j]='0';
                }else{
                    temp[i+j]='1';
                }
            }
        }
    }

    for (int i = 0; i < key_len - 1; i++) {
        data[data_len + i] = temp[data_len + i];
    }
    data[data_len + key_len - 1] = '\0';

    printf("Data to be transmitted ( After checksum ): %s\n", data);
    return 0;
}
