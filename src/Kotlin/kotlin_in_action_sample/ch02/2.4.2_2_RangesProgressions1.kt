package ch02.ex4_2_2_RangesProgressions1

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

// downTo 後進
// step ステップ変更
fun main(args: Array<String>) {
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }
}

/*
Buzz 98 Fizz 94 92 Fizz
Buzz 88 86 Fizz 82
Buzz Fizz 76 74 Fizz
Buzz 68 Fizz 64 62 Fizz
Buzz 58 56 Fizz 52
Buzz Fizz 46 44 Fizz
Buzz 38 Fizz 34 32 Fizz
Buzz 28 26 Fizz 22
Buzz Fizz 16 14 Fizz
Buzz 8 Fizz 4 2
Process finished with exit code 0
 */