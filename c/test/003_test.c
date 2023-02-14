#include "../include/003.h"
#include "../lib/utils.h"
#include <string.h>

int main(void)
{
    return strcmp("94c4dd41f9dddce696557d3717d98d82", md5(largest_prime_factor()));
}
