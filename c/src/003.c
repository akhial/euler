#include "../include/003.h"
#include <math.h>

long long largest_prime_factor(void)
{
    long long x = 600851475143;
    long long f = 0;

    for (f = 2; f < sqrt(x); f++)
    {
        while (0 == x % f && x != f)
        {
            x /= f;
        }
    }

    return x;
}
