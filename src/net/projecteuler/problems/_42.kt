package net.projecteuler.problems

import java.nio.file.Files
import java.nio.file.Paths
import java.util.regex.Pattern

/**
 * For this solution I calculated the first 30 triangular numbers (the largest value for a word being 15*26 = 390 and
 * the 30th triangular number being larger), then you only have to split the text file and count the triangular words.
 */

private val triangles = Array(30, { (0.5*it*(it + 1)).toInt() })

fun main(args: Array<String>) = println(triangleWords())

private fun triangleWords() = Files.lines(Paths.get("res/words.txt"))
        .map { it.replace("\"", "") }
        .map { it.replace(",", " ") }
        .flatMap { Pattern.compile("\\s+").splitAsStream(it) }
        .filter({ it.isTriangular() }).count().toInt()

private fun String.isTriangular() = triangles.contains(sumBy { it.toInt() - 64 })