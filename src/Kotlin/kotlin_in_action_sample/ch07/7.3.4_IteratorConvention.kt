package ch07.ex3_4_IteratorConvention

import java.util.Date
import java.time.LocalDate

// forループに置けるiterator規約
//
operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
        // このオブジェクトはLocalDate要素を繰り返すIteratorを実装する
        object : Iterator<LocalDate> { var current = start
                                       override fun hasNext() = current <= endInclusive
                                       override fun next() = current.apply { current = plusDays(1) }
                                     }

fun main(args: Array<String>) {
    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for (dayOff in daysOff) { println(dayOff) }
}
/*
2016-12-31
2017-01-01
 */

