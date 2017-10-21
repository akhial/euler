package net.projecteuler.api

data class PenceAmount(
        val one: Int,
        val two: Int,
        val five: Int,
        val ten: Int,
        val twenty: Int,
        val fifty: Int,
        val pound: Int,
        val twoPound: Int) {

    companion object {
        val ZERO =      PenceAmount(0, 0, 0, 0, 0, 0, 0, 0)
        val ONE =       PenceAmount(1, 0, 0, 0, 0, 0, 0, 0)
        val TWO =       PenceAmount(0, 1, 0, 0, 0, 0, 0, 0)
        val FIVE =      PenceAmount(0, 0, 1, 0, 0, 0, 0, 0)
        val TEN =       PenceAmount(0, 0, 0, 1, 0, 0, 0, 0)
        val TWENTY =    PenceAmount(0, 0, 0, 0, 1, 0, 0, 0)
        val FIFTY =     PenceAmount(0, 0, 0, 0, 0, 1, 0, 0)
        val POUND =     PenceAmount(0, 0, 0, 0, 0, 0, 1, 0)
        val TWO_POUND = PenceAmount(0, 0, 0, 0, 0, 0, 0, 1)
    }

    fun getAmount() : Int {
        return one*1 + two*2 + five*5 + ten*10 + twenty*20 + fifty*50 + pound*100 + twoPound*200
    }

    operator fun plus(other: PenceAmount) : PenceAmount {
        return PenceAmount(one + other.one,
                two + other.two,
                five + other.five,
                ten + other.ten,
                twenty + other.twenty,
                fifty + other.fifty,
                pound + other.pound,
                twoPound + other.twoPound)
    }

    operator fun times(multiplicand: Int) : PenceAmount {
        return PenceAmount(one*multiplicand,
                two*multiplicand,
                five*multiplicand,
                ten*multiplicand,
                twenty*multiplicand,
                fifty*multiplicand,
                pound*multiplicand,
                twoPound*multiplicand)
    }
}