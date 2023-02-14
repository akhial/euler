#include <stdio.h>

int main(void) {
    long long p = 1;
    long long n = 1;
    long long o = 0;
    long long s = 0;

    while (n < 4000000) {
        o = n;
        n += p;
        p = o;
        if (0 == n%2) {
            s += n;
        }
    }

    printf("%d\n", s);

    return 0;
}

