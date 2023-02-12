package solutions

import java.math.MathContext

/**
 * Used BigDecimal.sqrt(MathContext mc) added in Java 9. Could've also implemented Newton's method.
 */

fun squareRootDigitalExpansion() =
        (2..100).map { it.toBigDecimal().sqrt(MathContext(102)).toString() }
                .filter { it.length > 2 }
                .map { d -> d.filter { it != '.' }.take(100).sumBy { Character.getNumericValue(it) } }
                .sum()
