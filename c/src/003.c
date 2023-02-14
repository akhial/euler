#include <stdio.h>
#include <math.h>

int main(void) {
    long long x = 600851475143;
    long long f = 0;

    for (f = 2; f < sqrt(x); f++) {
        while (0 == x%f && x != f) {
           x /= f;
        }
    }

    printf("%d\n", x);

    return 0;
}

