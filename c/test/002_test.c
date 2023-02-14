#include "../include/002.h"
#include "../lib/utils.h"
#include <string.h>

int main(void)
{
    return strcmp("4194eb91842c8e7e6df099ca73c38f28", md5(even_fibonacci_numbers()));
}
