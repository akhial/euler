#include "utils.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <openssl/md5.h>

char *md5(int i)
{
    char str[100];
    unsigned char digest[MD5_DIGEST_LENGTH];

    sprintf(str, "%d", i);

    MD5_CTX ctx;
    MD5_Init(&ctx);
    MD5_Update(&ctx, str, strlen(str));
    MD5_Final(digest, &ctx);

    char *buf = malloc(sizeof digest * 2 + 1);

    for (int i = 0, j = 0; i < MD5_DIGEST_LENGTH; i++, j += 2)
    {
        sprintf(buf + j, "%02x", digest[i]);
    }
    buf[sizeof digest * 2] = 0;

    return buf;
}
