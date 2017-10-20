package net.projecteuler.api

fun Int.getDigit(index: Int) : Int {
    var exponent = (this.getLength() - index - 1).toDouble()
    if(exponent < 0) exponent = 0.0
    val digit = this / Math.pow(10.0, exponent).toInt()
    return digit % 10
}

fun Int.getLength() : Int {
    if(this == 0) return 1
    var n = this
    var len = 0
    while(n > 0) {
        n /= 10
        len++
    }
    return len
}