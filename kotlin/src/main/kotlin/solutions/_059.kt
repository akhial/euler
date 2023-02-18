package solutions

import java.nio.file.Files
import java.nio.file.Paths

/**
 * For all keys of the form XYZ I decrypt the message, then check for the absence of certain non-english characters
 * ($, ], | and `). Sum the ASCII values of the resulting characters.
 */

fun xorDecryption(): Int {
    val l = Files.lines(Paths.get("../res/059_cipher.txt")).map { it.split(",") }.findFirst().get()
    for(a in 'a'..'z')
        for(b in 'a'..'z')
            for(c in 'a'..'z') {
                val key = "" + a + b + c
                val r = l.mapIndexed { i, s -> s.toInt().xor(key[i % 3].code) }
                if(r.none { it == '$'.code || it == ']'.code || it == '|'.code || it == '`'.code })
                    return r.sum()
            }
    return 0
}
