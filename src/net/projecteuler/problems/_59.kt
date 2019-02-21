package net.projecteuler.problems

import java.nio.file.Files
import java.nio.file.Paths

/**
 * For all keys of the form XYZ I decrypt the message, then check for the absence of certain non-english characters
 * ($, ], | and `). Sum the ASCII values of the resulting characters.
 */

fun main() = println(xorDecryption())

private fun xorDecryption(): Int {
    val l = Files.lines(Paths.get("res/cipher.txt")).map { it.split(",") }.findFirst().get()
    for(a in 'a'..'z')
        for(b in 'a'..'z')
            for(c in 'a'..'z') {
                val key = "" + a + b + c
                val r = l.mapIndexed { i, s -> s.toInt().xor(key[i%3].toInt()) }
                if(r.none { it == '$'.toInt() || it == ']'.toInt() || it == '|'.toInt() || it == '`'.toInt() })
                    return r.sum()
            }
    return 0
}