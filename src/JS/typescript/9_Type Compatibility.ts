/** -----------------------------------------------------
 Type Compatibility
 ----------------------------------------------------- */
// TypeScriptでは、構造的部分型という考え方に基づいて型の互換性をチェックします。
// 構造的部分型は名目上の部分型と異なり、各型のメンバのみに基づいて互換性が判定されます。
interface Named {name: string }
class Person {name: string}
let p: Named;

// メンバが共通しているため、OK
p = new Person();
p.name = "test"
console.log(p); // Person { name: 'test' }

// A Note on Soundness ----------------------------------------------
// TypeScript の型システムはコンパイル時に安全であると判断できない操作についても許容しています。
// そのため、TypeScript がこのような不健全な振る舞いをする箇所について充分注意しておく必要があります。

// Starting out --------------------------------------------------------------------------------------------------------
// TypeScriptの構造的部分型の基本的なルールとして、yが少なくともxと同じメンバを持つ場合にxはyと互換性があるとみなします。
interface Named2 {name: string;}
let x2Tc: Named2
let y2Tc = { name: "Alice", location: "Seattle" } // y の型は { name: string; location: string; } とみなされる
x2Tc = y2Tc
console.log(x2Tc); // { name: 'Alice', location: 'Seattle' }

// Comparing two functions ---------------------------------------------------------------------------------------------
// x3Tcをy3Tcに代入できるか調べるためにまず引数リストを確認します。
// この時、x3Tcの各引数の型は対応するy3Tcの引数と互換性がないといけませんが、引数の数は一致する必要はありません。
// x3Tcの各引数はy3Tcの各引数と互換性があるため、x3Tcをy3Tcに代入することができます。
// 一方で、y3Tcの二番目の引数に対応する引数をx3Tcは持たないため、y3Tcをx3Tcに代入することはできません。

let x3Tc = (a3Tc: number) => 0;
let y3Tc = (b3Tc: number, s3Tc: string) => 0;

y3Tc = x3Tc // OK
// x3Tc = y3Tc エラー

// 余分な引数を受け取りたくはない
let items = [1, 2, 3]
items.forEach((item, index, array) => console.log(item)); // 1 2 3
items.forEach(item => console.log(item));// 1 2 3

// 続いて戻り値の型の扱いについても見ていきましょう。
// TypeScriptでは代入元の関数の戻り値の型は代入先の関数の戻り値の型の部分型である必要があります。
// 代入先にあるプロパティをすべて持っている必要があるということ
let x4Tc = () => ({name: "Alice"});
let y4Tc = () => ({name: "Alice", location: "Seattle"});

x4Tc = y4Tc; // OK
console.log(x4Tc()); // { name: 'Alice', location: 'Seattle' }
console.log(y4Tc()); // { name: 'Alice', location: 'Seattle' }
// y4Tc = x4Tc; エラー。xの戻り値には location プロパティがない

// Function Parameter Bivariance --------------------------------------------------------------
// 代入元先どちらかの関数の引数がもう一方の関数の引数に代入可能であれば、それらの関数の引数の型は等しいとみなされます。
// つまり、より具体的な型を引数に取る関数が指定されているにも関わらず、その部分型を引数に指定して関数を呼び出すことが可能ということであり、この仕様を不自然に思うかもしれません。
// 実際にはそれが問題となるようなケースは稀であり、また、これを許容することで JavaScript でよく用いられるパターンの多くを実現できるようになります。

enum EventType { Mouse, Keyboard }

interface Event { timestamp: number; }
interface MouseEvent extends Event { x5Tc: number; y5Tc: number }
interface KeyEvent extends Event { keyCode: number }

function listenEvent(eventType: EventType, handler: (n: Event) => void) {
    /* ... */
}

// MouseEvent を引数に取る関数に対し、Event を引数として呼び出すことになるため、
// 普通に考えるとまずいが、よく使われるパターンでもある
listenEvent(EventType.Mouse, (e: MouseEvent) => console.log(e.x5Tc + "," + e.y5Tc))

// 厳密に呼び出そうとするとこうなるが、こんなことはしたくない
listenEvent(EventType.Mouse, (e: Event) => console.log((<MouseEvent>e).x5Tc + "," + (<MouseEvent>e).y5Tc))
listenEvent(EventType.Mouse, <(e: Event) => void>((e: MouseEvent) => console.log(e.x5Tc + "," + e.y5Tc)))

// もちろん、まったく互換性のない型は許容されない (エラーになる)。
// listenEvent(EventType.Mouse, (e: number) => console.log(e))

// Optional Parameters and Rest Parameters ----------------------------------------------------
// 関数の型を比較する時に、任意の引数と必須の引数はお互いに入れ替え可能です。
// 代入元の関数に余分な任意の引数があってもエラーになりませんし、代入先の関数にしかない任意の引数があってもエラーになりません。
// また、可変長引数は無限個の任意の引数として扱われます。
// これも不自然に聞こえるかもしれませんが、大抵の関数では任意の引数が指定されないことは、その引数に undefined が指定されていることと同義なため、問題になることはありません。

function invokeLater(args: any[], callback: (...args: any[]) => void) {
    /* ... 'args' を引数に取るコールバックを呼び出す ... */
}

// invokeLater は任意の数の引数でコールバックを呼び出す "かも" しれないため、脆弱である
invokeLater([1, 2], (x6Tc, y6Tc) => console.log(x6Tc + ", " + y6Tc))

// (x と y は実際には必須であるため) 紛らわしく、引数の妥当性を検証することもできない
invokeLater([1, 2], (x7Tc?, y7Tc?) => console.log(x7Tc + ", " + y7Tc))


// Functions with overloads -------------------------------------------------------------------
// 関数がオーバーロードされている場合、代入元の関数のすべてのオーバーロードについて、代入先の関数と互換性がなければなりません。
// これにより、常に代入元の関数と同じ条件で代入先の関数を呼び出すことができるようになります。

// Enums ---------------------------------------------------------------------------------------------------------------
// enumと数値型は互いに互換性があります。
// しかし、他のenumとは互換性はありません。
enum Status { Ready, Waiting }
enum Color { Red, Blue, Green }

let status2 = Status.Ready;
// status = Color.Green; error
console.log(status2) // 0

// Classes -------------------------------------------------------------------------------------------------------------
// クラスはオブジェクトリテラルやインタフェースと同じように使用できますが、静的なメンバとインスタンスメンバを持つ点が異なります。
// 2つのオブジェクトの型を比較する際には、静的なメンバは無視され、インスタンスメンバのみが比較の対象となります。
class Animal {
    feet: number;
    constructor(name: string, numFeet: number) { }
}

class Size {
    feet: number;
    constructor(numFeet: number) { }
}

let a8Tc: Animal = s8Tc;  //OK
let s8Tc: Size = a8Tc;  //OK

// Private and protected members in classes ---------------------------------------------------
// private/protected メンバを持つクラスのインスタンスを比較する場合、
// 比較対象のクラスは同じクラスから派生した private/protected メンバを持つ必要があります。
// そのため、自身の基底クラスに対して代入することは可能ですが、
// 例え同じメンバを持っていても継承関係のないクラスには代入することはできません。

// Generics ------------------------------------------------------------------------------------------------------------
// TypeScript は構造的部分型を採用しているため、型引数はメンバの型の一部として使用されない限り、型の互換性には影響を与えません。
interface Empty<T> {}
let x9Tc: Empty<number>
let y9Tc: Empty<string>
x9Tc = y9Tc  // OK。x9Tc と y9Tc の構造は同じ

// 型引数が指定されている場合、ジェネリックな型は非ジェネリックな型のように扱われます。
interface NotEmpty<T> {data: T}
let x10Tc: NotEmpty<number>
let y10Tc: NotEmpty<string>
x10Tc = y10Tc  // エラー。x10Tc と y10Tc は互換性がない

// ジェネリックな型の型引数が指定されていない場合、型引数にanyが指定されているものとして比較が行われます。
let identity = function<T>(x: T): T {
    // ...
}

let reverse = function<U>(y: U): U {
    // ...
}

identity = reverse;  // OK。(x: any)=>any は (y: any)=>any と互換性がある







