#include <stdio.h>
#include <string.h>

int isPalindrome(char *);

int main(void) {
    int r = 0;
    int a, b;

    for (a = 100; a < 1000; a++) {
        for (b = 100; b < 1000; b++) {
            char s[7];
            int p = a*b;

            sprintf(s, "%d", p);

            if (p > r && isPalindrome(s)) {
                r = p;
            }
        }
    }

    printf("%d\n", r);

    return 0;
}

int isPalindrome(char * n) {
    int l = strlen(n);

    if (0 != l%2) {
        return 0;
    }

    int i;

    for (i = 0; i < l/2; i++) {
        if (n[i] != n[l - 1 - i]) {
            return 0;
        }
    }

    return 1;
}

