/** ----------------------------------------
 Hello World of Generics
 ---------------------------------------- */

// Genericsを使用せずに実施
function identity(arg: number): number {return arg}

// any
// anyを使用するとどんな型でも受け付けることができますが、戻り値として引数をそのまま返却した場合に型情報を失ってしまいます。
function identity2(arg: any): any {return arg}

// Generics
// 型変数を使用することで型情報を保持できる
function identity3<T>(arg: T): T {return arg}

// 記載方法
// 1.型変数に渡す型を <> で囲んで指定する方法
let output2 = identity3<string>("myString");  // output の型は 'string'
console.log(output2); // myStrin

// 2.型変数に渡す型を型推論
let output3 = identity3("myString");  // output の型は 'string'
console.log(output3); // myString

// Working with Generic Type Variables ---------------------------------------------------------------------------------
// 引数を配列対応にする
function loggingIdentity<T>(arg: T[]): T[] {
    console.log(arg.length);  // 配列であれば 'length' を持つため、エラーにならない
    return arg;
}

function loggingIdentity2<T>(arg: Array<T>): Array<T> {
    console.log(arg.length);  // Array は 'length' を持つため、エラーにならない
    return arg;
}

// Generic Types -------------------------------------------------------------------------------------------------------
function identity4<T>(arg: T): T {return arg}
let myIdentity4: <T>(arg: T) => T = identity4

// 型変数名をT → U へ
function identity5<T>(arg: T): T {return arg}
let myIdentity5: <U>(arg: U) => U = identity5

// オブジェクトリテラルのように型変数名を指定
function identity6<T>(arg: T): T {return arg;}
let myIdentity6: {<T>(arg: T): T} = identity6;

// interfaceの宣言(オブジェクトリテラルによる宣言をインタフェース内に記述します。)
interface GenericIdentityFn7 { <T>(arg: T): T }
function identity7<T>(arg: T): T { return arg }
let myIdentity7: GenericIdentityFn7 = identity7
console.log(myIdentity7("myString")) // myString

// 型変数をインタフェース全体に適用させる(他のメンバでも型変数を共用)
interface GenericIdentityFn8<T> { (arg: T): T }
function identity8<T>(arg: T): T { return arg }
let myIdentity8: GenericIdentityFn8<number> = identity8
console.log(myIdentity8(123)) // 123

// ジェネリックなクラスを作成することも可能ですが、ジェネリックな Enum、名前空間は作成することはできません。

// Generic Classes -----------------------------------------------------------------------------------------------------
// ジェネリッククラスはジェネリックインタフェースと同じように、クラス名の後ろの角括弧(<>)に型変数を記述します。
class GenericNumber<T> {
    zeroValue: T
    add: (x: T, y: T) => T
}

let myGenericNumber = new GenericNumber<number>()
myGenericNumber.zeroValue = 0
myGenericNumber.add = function(x, y) { return x + y; }
console.log(myGenericNumber.add(2, 3)); // 5

// GenericNumberは数値型に限定されることはありません。
// 他に文字列や、より複雑なオブジェクトに対して使用することもできます。
// クラスはインスタンスメンバと静的メンバの2種類のメンバを持ちますが、ジェネリッククラスの型変数は静的メンバで使用することはできません。
let stringNumeric2 = new GenericNumber<string>();
stringNumeric2.zeroValue = "";
stringNumeric2.add = function(x, y) { return x + y; };
console.log(stringNumeric2.add(stringNumeric2.zeroValue, "test")); // test

// Generic Constraints -------------------------------------------------------------------------------------------------
// ジェネリック関数を使う時に、型の持つメンバを使用したいと考えるかもしれません。
// 先ほどのloggingIdentityの例ではarg引数のlengthプロパティを使用したかったのですが、
// 引数に指定された型が必ずしもlengthプロパティを持つとは限らないため、使用することはできませんでした。
function loggingIdentity3<T>(arg: T): T {
    // console.log(arg.length);  エラー。T 型は length プロパティを持たない
    return arg;
}

interface Lengthwise {length: number}
function loggingIdentity4<T extends Lengthwise>(arg: T): T {
    console.log(arg.length);  // argがlengthプロパティを持っていることを知っているため、これはエラーにならない
    return arg;
}
console.log(loggingIdentity4) // [Function: loggingIdentity4]

// loggingIdentity(3);  エラー。数値型はlengthプロパティを持たない
loggingIdentity4({length: 10, value: 3}) // 10 (必要なプロパティを持つ型を渡す必要があります)

// Using Type Parameters in Generic Constraints ------------------------------------------------------------------------
// 型引数を指定する時に、他の型引数に依存した型引数を指定することも可能
// 指定されたオブジェクトに存在するプロパティのみを引数に受け取りたい場合
function getProperty9<T, K extends keyof T>(obj: T, key: K) {return obj[key]}
let x9 = { a: 1, b: 2, c: 3, d: 4 }

getProperty9(x9, "a"); // OK
// getProperty(x, "m"); エラー。'm' 型の引数は 'a' | 'b' | 'c' | 'd' 型に代入できない

// Using Class Types in Generics ---------------------------------------------------------------------------------------
// ジェネリック関数でファクトリを受け取る場合、型引数としてコンストラクタ関数の型を指定する必要があります。
function create<T>(c: {new(): T; }): T {return new c()}

// sample({new(): T;} の代わりに new () => A )
class BeeKeeper {hasMask: boolean}
class ZooKeeper {nametag: string}
class Animal1 {numLegs: number}

class Bee extends Animal1 {keeper: BeeKeeper}
class Lion extends Animal1 {keeper: ZooKeeper}

function createInstance<A extends Animal1>(c: new () => A): A {return new c()}
// createInstance(Lion).keeper.nametag)  型チェック!
// createInstance(Bee).keeper.hasMask)   型チェック!






