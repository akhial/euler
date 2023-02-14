
#include "../include/004.h"
#include "../lib/utils.h"
#include <string.h>

int main(void)
{
    return strcmp("d4cfc27d16ea72a96b83d9bdef6ce2ec", md5(largest_palindrome_product()));
}
