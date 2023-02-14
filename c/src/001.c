#include <stdio.h>

int main(void) {
    int i = 0;
    int s = 0;

    for (i = 0; i < 1000; i++) {
        if (0 == i%5 || 0 == i%3) {
            s += i;
        }
    }

    printf("%d\n", s);

    return 0;
}

