/**--------------------------------------------------
 Symbols
 -------------------------------------------------- */

// Introduction --------------------------------------------------------------------------------------------------------
// ECMAScript2015からプリミティブ型に symbol が追加されました。
// symbol型の値はSymbolコンストラクタを呼ぶことで作成します。
let sym1 = Symbol()
let sym2 = Symbol("key") // 文字列キーは任意
console.log(sym2) // Symbol(key)

// シンボルは変更不可で、かつ、一意です。
let sym3 = Symbol("key")
sym2 === sym3 // false、シンボルは常に一意

// シンボルは文字列のようにオブジェクトのプロパティとして使用できます。
let sym = Symbol()
let obj = {[sym]: "value"}
console.log(obj[sym]); // value

// 計算されたプロパティとして使用することも可能です。
const getClassNameSymbol = Symbol()
class C {
    [getClassNameSymbol](){return "C"}
}
let c = new C()
let className = c[getClassNameSymbol]()
console.log(className) // C

// Well-known Symbols
// Symbol.hasInstance
// Symbol.isConcatSpreadable
// Symbol.iterator
// Symbol.match
// Symbol.replace
// Symbol.search
// Symbol.species
// Symbol.split
// Symbol.toPrimitive
// Symbol.toStringTag
// Symbol.unscopables






