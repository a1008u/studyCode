/** ---------------------------------------------------
 * Interface
---------------------------------------------------- */
// Our First Interface -------------------------------------------------------------------------------------------------
function printLabel(labelledObj: { label: string }) {console.log(labelledObj.label)}
let myObj = {size: 10, label: "Size 10 Object"}
printLabel(myObj)

interface LabelledValue {label: string}
function printLabel2(labelledObj: LabelledValue) {console.log(labelledObj.label)}
let myObj2 = {size: 10, label: "Size 10 Object"}
printLabel2(myObj2)

// Optional Properties -------------------------------------------------------------------------------------------------
interface SquareConfig {
    color?: string; // プロパティが必須でない場合?をつける
    width?: number;
}

function createSquare(config: SquareConfig): {color: string; area: number} {
    let newSquare = {color: "white", area: 100}
    if (config.color) {/* newSquare.color = config.clor　エラー。'clor' プロパティは 'SquareConfig' に存在しない*/ }
    if (config.color) {newSquare.color = config.color}
    if (config.width) {newSquare.area = config.width * config.width}
    return newSquare
}

let mySquare = createSquare({color: "black"})

// Readonly properties -------------------------------------------------------------------------------------------------
interface Point {
    readonly x: number
    readonly y: number
}
let p1: Point = { x: 10, y: 20 }
console.log(p1);
// p1.x = 5 エラー

// 読み取り専用ReadonlyArray<T>クラス
let a: number[] = [1, 2, 3, 4];
let ro: ReadonlyArray<number> = a;
console.log( "読み取り専用ReadonlyArrayクラス：" + ro);
a = ro as number[];
console.log("ReadonlyArrayオブジェクトをキャストして配列へ：" + a);
// ro[0] = 12      エラー!
// ro.push(5)      エラー!
// ro.length = 100 エラー!
// a = ro          エラー!

// readonly vs const ---------------------------------------------------------------------------------------------------
// 対象が変数であればconst
// プロパティであればreadonly

// Excess Property Checks また後で

// Function Types ------------------------------------------------------------------------------------------------------
// インタフェースは特定のプロパティを持つオブジェクトを表す以外に、メソッドの型を表すこともできます。
// これには引数と戻り値だけを持つ関数宣言のように表現します。
// この時、引数リストには名前と型が必須です。
// 実装時型は省略できる。
interface SearchFunc {(source: string, subString: string): boolean}

let mySearch: SearchFunc;
mySearch = function(source: string, subString: string) {
    let result = source.search(subString)
    return result > -1
}
console.log(mySearch("test", "es"))

// Indexable Types -----------------------------------------------------------------------------------------------------
// インデックス可能な型は、インデックスとして指定可能な型とその戻り値の型を指定したインデックスシグネチャを持ちます。
// インデックスシグネチャは文字列型 と 数値型の2種類をサポート
// 両方の型をサポートすることも可能ですが、その場合、数値型のインデックスシグネチャの戻り値の型は、
// 文字列型のインデックスシグネチャの戻り値の型のサブクラスである必要があります。
// なぜなら、JavaScript では数値型のインデックスは文字列に変換されてから使用されるためです。
interface StringArray {[index: number]: string}

let myArray: StringArray
myArray = ["Bob", "Fred"]
let myStr: string = myArray[0]
console.log("myStr:" + myStr)

class Animal {name: string}
class Dog extends Animal {breed: string}

// エラー。文字列型でアクセスするとAnimalが返ってくることがある。
interface NotOkay {
    [x: number]: Animal
    [x: string]: Dog
}

// インデックスシグネチャはすべてのプロパティの型を統一させる
interface NumberDictionary {
    [index: string]: number;
    length: number;    // OK。length は数値型
    name: string;      // エラー。name は数値型またはそのサブクラスではない
}

interface ReadonlyStringArray {readonly [index: number]: string}
let myArray: ReadonlyStringArray = ["Alice", "Bob"];
// myArray[2] = "Mallory" エラー! Readonlyのため

// Class Types -------------------------------------------------------------------------------------------------
// Implementing an interface
interface ClockInterface {currentTime: Date}

class Clock implements ClockInterface {
    currentTime: Date
    constructor(h: number, m: number) { }
}

interface ClockInterface2 {
    currentTime: Date
    setTime(d: Date)
}

class Clock2 implements ClockInterface2 {
    currentTime: Date
    setTime(d: Date) {this.currentTime = d}
    constructor2(h: number, m: number) { }
}

// Difference between the static and instance sides of classes -----------------------------------------------------
// クラスとインタフェースを使用するにあたって、
// クラスは静的メンバとインスタンスメンバという2種類のメンバを持つ点を意識しておいてください。

/* error -------------------------------------------------------
// インタフェースを実装する際にはインスタンスメンバしかチェックされないため、
// 静的メンバであるコンストラクタがチェックの対象にならないからです。

interface ClockConstructor3 {new (hour: number, minute: number);}
class Clock3 implements ClockConstructor3 {
    currentTime: Date
    constructor(h: number, m: number) { }
}
-------------------------------------------------------------- */

// 静的メンバを直接使用
interface ClockConstructor5 {new (hour: number, minute: number): ClockInterface5}
interface ClockInterface5 {tick5()}

function createClock5(ctor5: ClockConstructor5, hour: number, minute: number): ClockInterface5 {
    return new ctor5(hour, minute)
}

class DigitalClock5 implements ClockInterface5 {
    constructor(h: number, m: number) { }
    tick5() {console.log("beep beep")}
}
class AnalogClock5 implements ClockInterface5 {
    constructor(h: number, m: number) { }
    tick5() {console.log("tick tock")}
}

let digital = createClock5(DigitalClock5, 12, 17);
let analog = createClock5(AnalogClock5, 7, 32);

// Extending Interfaces
interface Shape {color: string}
interface Square extends Shape {sideLength: number}

let square = <Square>{}
square.color = "blue"
square.sideLength = 10
console.log("square" + square)

interface PenStroke {penWidth: number}
interface Square2 extends Shape, PenStroke {sideLength: number}
let square2 = <Square2>{}
square2.color = "blue"
square2.sideLength = 10
square2.penWidth = 5.0
console.log("square2" + square2)

// Hybrid Types --------------------------------------------------------------------------------------------------------
interface Counter {
    (start: number): string
    interval: number
    reset(): void
}

function getCounter(): Counter {
    // まだインタフェースをすべて実装していないため、'Counter' 型として宣言していない (できない)
    let counter = <Counter>function (start: number) { }
    counter.interval = 123
    counter.reset = function () { }
    return counter // 'Counter' 型のすべてのプロパティ/メソッドを用意したため、'Counter' 型として返却できる
}

let c = getCounter()
c(10)
c.reset()
c.interval = 5.0
console.log("c:"+c)

// Interfaces Extending Classes ----------------------------------------------------------------------------------------
// クラスを拡張してインタフェースを作成した場合
// private/protectedメンバも含めてクラスのメンバはすべて継承されますが、その実装は引き継がれません。
// つまり、private/protected メンバを持つクラスを継承したインタフェースは、
// そのクラス自身、またはそのサブクラスでしか実装することはできないということです。
// このことは特定のプロパティを持つサブクラスに対してのみ、動作するコードを作成したい場合に役立ちます。
// この時、サブクラスで必要なことは基底クラスを継承することだけです。
class Control {private state: any}
interface SelectableControl extends Control {select(): void}
class Button extends Control implements SelectableControl {select() { }}
class TextBox extends Control {}
class Location {}
/* -----------------------------------------------------
エラー: 'state' プロパティが 'Image' クラスに存在しない
class Image implements SelectableControl {select() { }}
----------------------------------------------------- */








