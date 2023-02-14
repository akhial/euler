#include <stdio.h>
#include <math.h>

static int ndiv(int);

int main(void) {
    int i = 1;
    int n = 0;
    int r;

    while (n < 500) {
        r = (i*(i + 1))/2;
        n = ndiv(r);
        ++i;
    }

    printf("%ld\n", r);

    return 0;
}

int ndiv(int n) {
    int i = 0;
    int d = 1;

    for (i = 2; i < sqrt(n); i++) {
        if (0 == n%i) {
            ++d;
        }
    }

    return 2*d;
}

