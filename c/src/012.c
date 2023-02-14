#include "../include/012.h"
#include <math.h>

static int ndiv(int);

int highly_divisible_triangular_number(void)
{
    int i = 1;
    int n = 0;
    int r;

    while (n < 500)
    {
        r = (i * (i + 1)) / 2;
        n = ndiv(r);
        ++i;
    }

    return r;
}

int ndiv(int n)
{
    int i = 0;
    int d = 1;

    for (i = 2; i < sqrt(n); i++)
    {
        if (0 == n % i)
        {
            ++d;
        }
    }

    return 2 * d;
}
