/** ------------------------------------------------
 Iterators and Generators
 ------------------------------------------------ */

// Iterables -----------------------------------------------------------------------------------------------------------
// Symbol.iterator プロパティを持つオブジェクトは反復可能なオブジェクトとして扱われます。

// for..of statements
// for...of はオブジェクトの持つ Symbol.iteratorプロパティを使用してループを行います。
let someArray = [1, "string", false]
for (let entry of someArray) {
    console.log(entry) // 1, "string", false
}

// for..of vs. for..in statements --------------------------------------------------------------------------------------
// for..of と for..in はともにリストをループしますが、
// for..in はオブジェクトの キー のリストを返却するのに対し、
// for..of は数値インデックスで参照できる値を返却する点が異なります。
let list = [4, 5, 6]
for (let i in list) {
    console.log(i); // "0", "1", "2",
}

for (let i of list) {
    console.log(i); // "4", "5", "6"
}

// それ以外に、for..in は任意のオブジェクトの持つプロパティを検査する目的で使用されるのに対し、
// for..of は反復対象のオブジェクトの持つ値に焦点を当てている点が異なります。
// Map や Set のような組み込み型は格納している値を参照するための Symbol.iterator を持っています。
let pets = new Set(["Cat", "Dog", "Hamster"])
pets["species"] = "mammals"
for (let pet in pets) {
    console.log(pet) // "species"
}

for (let pet of pets) {
    console.log(pet) // "Cat", "Dog", "Hamster"
}

// Code generation -----------------------------------------------------------------------------------------------------
// Targeting ES5 and ES3
// ES5 または ES3 を対象としている場合、反復対象とできるのはArrayのみです。
// それ以外の型を対象とした場合、それがSymbol.iteratorを実装していたとしてもエラーとなります。
// この時、コンパイラは for..of から単純な for ループを生成します。
let numbers = [1, 2, 3];
for (let num of numbers) {
    console.log(num); // 1, 2, 3
}

// Targeting ECMAScript 2015 and higher
// ECMAScipt 2015 を対象としている場合、ネイティブの for..of を使用するコードが生成されます。





