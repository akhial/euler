#include "../include/001.h"
#include "../lib/utils.h"
#include <string.h>

int main(void)
{
    return strcmp("e1edf9d1967ca96767dcc2b2d6df69f4", md5(multiples_of_3_or_5()));
}
