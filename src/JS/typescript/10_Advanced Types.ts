/** ---------------------------------------
 * Advanced Types
 --------------------------------------- */
// Intersection Types --------------------------------------------------------------------------------------------------
// 交差型は Person & Serializable & Loggableのように複数の型をひとつにまとめたもので、これらの型の全メンバを持ちます。
// 交差型を使用した mixin の例を以下に示します。
function extend<T, U>(first: T, second: U): T & U {
    let result = <T & U>{}
    for (let id in first) {(<any>result)[id] = (<any>first)[id]}
    for (let id in second) {
        if (!result.hasOwnProperty(id)) {(<any>result)[id] = (<any>second)[id]}
    }
    return result
}

class Person10 {constructor(public name: string) { }}
interface Loggable {
    log(): void;
}
class ConsoleLogger implements Loggable {
    log() {
        // ...
    }
}
var jim = extend(new Person10("Jim"), new ConsoleLogger());
var n = jim.name;
jim.log();

// Union Types ---------------------------------------------------------------------------------------------------------
// 共用型は交差型と似ていると思うかもしれませんが、まったくの別物です。
// 例として、numberとstring のいずれかの引数を取る関数を考えてみましょう。
/**
 * 文字列を受け取り、左側に "padding" を加える。
 * 'padding' が文字列の場合、'padding' を左側に加える。
 * 'padding' が数値の場合、その数だけ空白を左側に加える。
 */
function padLeft(value: string, padding: any) {
    if (typeof padding === "number") { return Array(padding + 1).join(" ") + value }
    if (typeof padding === "string") {return padding + value }
    throw new Error(`Expected string or number, got '${padding}'.`)
}

padLeft("Hello world", 4); // 戻り値は "    Hello world"
// この関数の問題点は、padding の型を any としていることです。
// そのため、number や string 以外の引数を渡してもコンパイルエラーになりません。

let indentedString = padLeft("Hello world", true); // コンパイルは通るが、実行時にエラーになる
// 伝統的なオブジェクト指向プログラミングでは共通の基底クラスを定義することでこれを実現しようとするかもしれませんが、ここでそれをするには若干大げさすぎます。
// そこで、padding の型として any の代わりに 共用型 を使用します。
// 共用型は複数の型のうち、どれかであることを表す型で、それぞれの型を縦棒 (|) で区切って記述します。(例: number | string | boolean)

/**
 * 文字列を受け取り、左側に "padding" を加える。
 * 'padding' が文字列の場合、'padding' を左側に加える。
 * 'padding' が数値の場合、その数だけ空白を左側に加える。
 */
function padLeft(value: string, padding: string | number) {/* .. */}

let indentedString = padLeft("Hello world", true); // コンパイル時にエラーになる
// 共用型の値に対しては、すべての型に共通のメンバにしかアクセスすることはできません。

interface Bird {
    fly();
    layEggs();
}

interface Fish {
    swim();
    layEggs();
}

function getSmallPet(): Fish | Bird {/* .. */}
let pet = getSmallPet()
// pet.layEggs() Bird、Fish 両方にあるので OK
// pet.swim()   Fish にしかないのでエラー

// Type Guards and Differentiating Types -------------------------------------------------------------------------------
// 共用型は複数の型を受け取るときに便利ですが、実際にどの型か判断するにはどうすれば良いでしょうか。
// JavaScript で一般的に用いられるのは以下のようにメンバの存在チェックを行う方法です。

// この書き方ではエラーになる
// let pet2 = getSmallPet()
// if (pet2.swim) {pet2.swim()} else if (pet2.fly) {pet2.fly()}

let pet3 = getSmallPet();
if ((<Fish>pet3).swim) {(<Fish>pet3).swim()} else {(<Bird>pet3).fly()}

// User-Defined Type Guards -------------------------------------------
// このままでは毎回キャストする必要がありますが、実際には、一度型チェックを行えばその条件分岐の中ではどの型か分かっていることになります。
// このように特定のスコープにおける型を保証することを 型ガードと読んでおり、それには以下のような型述語を返す関数を定義して使用します。
// 型述語はparameterName is Typeの形式で記述しますが、この時の parameterName は関数の引数名と同じである必要があります。
function isFish(pet: Fish | Bird): pet is Fish {
    return (<Fish>pet).swim !== undefined
}
// isFishを呼び出すと、もしそれが元の型と互換性がある型であれば、TypeScriptは自動的にその型として扱ってくれます。

// 'swim'、'fly' の両方にアクセスしても問題ない
if (isFish(pet)) {pet.swim()} else {pet.fly()}

// typeof type guards -------------------------------------------------
// 最初のpadLeftの例について、型述語を使用して書き直してみましょう。
function isNumber1(x: any): x is number {return typeof x === "number"}
function isString1(x: any): x is string {return typeof x === "string"}

function padLeft(value: string, padding: string | number) {
    if (isNumber1(padding)) {return Array(padding + 1).join(" ") + value}
    if (isString1(padding)) {return padding + value}
    throw new Error(`Expected string or number, got '${padding}'.`)
}
// 毎回、このような型述語関数を定義するのは大変なため、TypeScript では一部の型に対して自動的に型ガードを認識してくれます。

function padLeft2(value: string, padding: string | number) {
    if (typeof padding === "number") {return Array(padding + 1).join(" ") + value}
    if (typeof padding === "string") {return padding + value}
    throw new Error(`Expected string or number, got '${padding}'.`)
}
// この時、自動的に型ガードとして認識してくれるのは typeof v === "typename" または typeof v !== "typename" のいずれかの形式で記述した時だけです。
// また、"typename" には "number"、 "string"、 "boolean"、 "symbol" のいずれかのみを指定可能です。

// instanceof type guards ---------------------------------------------
// JavaScript では typeof 以外に instanceof もよく使用します。
// instanceof 型ガード ではコンストラクタ関数を使用して型を特定します。
interface Padder {getPaddingString(): string}

class SpaceRepeatingPadder implements Padder {
    constructor(private numSpaces: number) { }
    getPaddingString() {return Array(this.numSpaces + 1).join(" ")}
}

class StringPadder implements Padder {
    constructor(private value: string) { }
    getPaddingString() {return this.value}
}

function getRandomPadder() {
    return Math.random() < 0.5 ?
        new SpaceRepeatingPadder(4) :
        new StringPadder("  ");
}

// 'SpaceRepeatingPadder | StringPadder' 型
let padder: Padder = getRandomPadder();
if (padder instanceof SpaceRepeatingPadder) { padder} // 'SpaceRepeatingPadder' 型として扱われる
if (padder instanceof StringPadder) { padder }        // 'StringPadder' 型として扱われる

// instanceofの右側はコンストラクタ関数である必要があります。
// また、TypeScriptは以下の順で型を特定します。
// ・型がanyでない場合、コンストラクタ関数のprototypeの型
// ・コンストラクタ関数の戻り値の型をまとめた共用型

// Nullable types ------------------------------------------------------------------------------------------------------
// --strictNullChecks を使用することで、 そのままでは null や undefined を代入できなくすることが可能です。
// その場合、null や undefined を代入できる変数は明示的に共用型として宣言する必要があります。
let s = "foo";
s = null; // エラー。'null' は 'string' に代入できない

let sn: string | null = "bar";
sn = null; // OK

sn = undefined; // エラー。'undefined' は'string | null' に代入できない
// JavaScript と異なり、TypeScript では null と undefined を区別して扱っていることに注意してください。
// つまり、string | null、 string | undefined、 string | undefined | null はすべて異なる型になります。


// Optional parameters and properties ---------------------------------
// --strictNullChecks を指定すると自動的に任意の引数に |　undefined が追加されます。
function f(x: number, y?: number) {return x + (y || 0)}
f(1, 2)
f(1)
f(1, undefined)
f(1, null) // エラー。'null' は 'number | undefined' には代入できない

//任意のプロパティについても同様です。
class C {
    a: number
    b?: number
}
let c = new C()
c.a = 12
c.a = undefined // エラー。'undefined' は 'number' には代入できない
c.b = 13
c.b = undefined // OK
c.b = null // エラー。'null' は 'number | undefined' には代入できない

// Type guards and type assertions ------------------------------------
// null を代入可能な型は共用型として表現されるため、
// null を取り除くためには型ガードを使用する必要がありますが、
// これはJavaScriptと同じように記述できます。
function f(sn: string | null): string {
    if (sn == null) {return "default"}
    else {return sn}
}

// 上記のやり方はnullを除外しようとしていることが非常に明確ですが、もっと簡潔な演算子を使用することもできます。
function f(sn: string | null): string {return sn || "default"}

// コンパイラがnullやundefinedを取り除くことができない場合、キャストを使用して明示的にそれらを取り除くことができます。
// 識別子の末尾に ! を付けることで、その識別子の型から null と undefined が取り除かれます。
function broken(name: string | null): string {
    // エラー。'name' は null の可能性がある
    function postfix(epithet: string) {return name.charAt(0) + '.  the ' + epithet}

    name = name || "Bob"
    return postfix("great")
}

function fixed(name: string | null): string {
    function postfix(epithet: string) {return name!.charAt(0) + '.  the ' + epithet} // OK
    name = name || "Bob";
    return postfix("great");
}
// この例ではネストされた関数を使用していますが、
// ネストされた関数の呼び出しのすべてを追跡することができないため、
// コンパイラは実行時の name の型が何になるか (null になるかどうか) を判断することはできません。


// Type Aliases --------------------------------------------------------------------------------------------------------
// 型エイリアスを使って、型に別名を付けることができます。
// 型エイリアスはインタフェースと似ていますが、プリミティブ型、共用型、タプル、その他の自作クラスに対して適用することができます。
type Name = string;
type NameResolver = () => string;
type NameOrResolver = Name | NameResolver;
function getName(n: NameOrResolver): Name {
    if (typeof n === "string") {return n}
    else {return n()}
}

// インタフェースと同様に、エイリアスもジェネリックにすることができます。
// そのためにはエイリアス宣言の右側に型引数を追加するだけです。
type Container<T> = { value: T };

// プロパティからエイリアス自身を参照することも可能です。
type Tree<T> = {
    value: T;
    left: Tree<T>;
    right: Tree<T>;
}

// これらと交差型を組み合わせることでクラクラするような型を作り出すことができます。
type LinkedList<T> = T & { next: LinkedList<T> }

interface Person { name: string }

var people: LinkedList<Person>
var s = people.name
var s = people.next.name
var s = people.next.next.name
var s = people.next.next.next.name
// ただし、上記の他には宣言の右側にエイリアスを記述することはできません。
// type Yikes = Array<Yikes>;  エラー

// Interfaces vs. Type Aliases ----------------------------------------
// 型エイリアスとインタフェースはよく似ていますが、微妙に異なる点があります。
// ひとつ目の違いは、
// インタフェースがどこでも使用できる新しい名前を作り出すのに対し、型エイリアスは新しい名前を作ることはしません。
// エラーメッセージではエイリアス名は表示されませんし、
// 以下のコードでは interfaced をエディタ上でマウスホバーするとInterfaceを返却する関数と表示されますが、
// aliasedをマウスホバーしてもオブジェクトリテラルを返却する関数としか表示されません。
type Alias = { num: number }
interface Interface {num: number}

declare function aliased(arg: Alias): Alias
declare function interfaced(arg: Interface): Interface
// ふたつ目の違いは、
// エイリアスを拡張したり、実装する (または他の型を拡張/実装してエイリアスを作る) ことができない点です。
// 理想的なソフトウェアは拡張に対して開いているべきであることを考慮すると、
// なるべく型エイリアスではなく、インタフェースを使用するようにしてください。
// 一方で、インタフェースを用いて型を表現できず、共用型やタプル型を使用する必要がある場合には型エイリアスを使用するべきです。

// String Literal Types ------------------------------------------------------------------------------------------------
// リテラル文字列型を使用し、文字列の取りうる値を限定することが可能です。
// さらに共用型、型ガード、型エイリアスと組み合わせることで、文字列を enum のように使用することができます。
type Easing = "ease-in" | "ease-out" | "ease-in-out";
class UIElement {
    animate(dx: number, dy: number, easing: Easing) {
        if (easing === "ease-in") { }
        else if (easing === "ease-out") { }
        else if (easing === "ease-in-out") { }
        else {/* エラー! null や undefined を渡すべきではない */}
    }
}

let button = new UIElement();
button.animate(0, 0, "ease-in");
button.animate(0, 0, "uneasy"); // エラー。 "uneasy" を指定することはできない
// 指定された 3 種類以外の文字列を引数として渡すと、以下のようなエラーになります。

// Argument of type '"uneasy"' is not assignable to parameter of type '"ease-in" | "ease-out" | "ease-in-out"'
// リテラル文字列型はオーバーロードにも使用することができます。

function createElement(tagName: "img"): HTMLImageElement;
function createElement(tagName: "input"): HTMLInputElement;

// ... 他のオーバーロード ...
function createElement(tagName: string): Element {
    // ... 処理をここに書く ...
}

// Discriminated Unions ------------------------------------------------------------------------------------------------
// リテラル文字列型、共用型、型ガード、型エイリアスを組み合わせることで、
// 判別共用型 (または タグ付き共用型、代数的データ型) と呼ばれるパターンを構築することができます。
// TypeScriptでの判別共用型は以下の3つの要素から成り立ちます。
// 1.リテラル文字列型の共通プロパティを持つ型 (判別子)
// 2.複数の判別子からなる型エイリアス (共用型)
// 3.共通プロパティに対する型ガード
// まず、後で結合させるインタフェースを定義します。
// 各インタフェースでは判別子(または タグ)となるリテラル文字列型のkindプロパティを個別に定義します。
// また、それ以外のプロパティも各インタフェースに定義します。
// この時、各インタフェースには何の関連もないことを覚えておいてください。
interface Square {
    kind: "square";
    size: number;
}
interface Rectangle {
    kind: "rectangle";
    width: number;
    height: number;
}
interface Circle {
    kind: "circle";
    radius: number;
}
// 続いてこれらのインタフェースを結合しましょう。

type Shape = Square | Rectangle | Circle;
// この判別共用型の使用方法は以下の通りです。

function area(s: Shape) {
    switch (s.kind) {
        case "square": return s.size * s.size;
        case "rectangle": return s.height * s.width;
        case "circle": return Math.PI * s.radius ** 2;
    }
}


// Exhaustiveness checking --------------------------------------------
// もしも判別共用型のすべての値を網羅していなかったらコンパイラに警告してほしいと思うことでしょう。
// 例えば、Shape に Triangle を追加した時に area の修正を忘れた場合です。

type Shape = Square | Rectangle | Circle | Triangle;
function area(s: Shape) {
    switch (s.kind) {
        case "square": return s.size * s.size;
        case "rectangle": return s.height * s.width;
        case "circle": return Math.PI * s.radius ** 2;
    }
    // "triangle" のパターンを追加していないため、エラーになってほしい
}
// これを実現するための方法として 2 通りのやり方があります。

// ひとつ目は --strictNullChecks と戻り値の型を指定することです。
// switch 文が網羅的でない場合、戻り値として undefinded が含まれることになります
// (number | undefied) が、実際に指定している戻り値の型 (number) と矛盾するため、エラーとなります。
function area(s: Shape): number { // エラー: 戻り値は number | undefined になる
    switch (s.kind) {
        case "square": return s.size * s.size;
        case "rectangle": return s.height * s.width;
        case "circle": return Math.PI * s.radius ** 2;
    }
}
// しかし、この方法は意図が分かりにくい上に、常に --strictNullChecks を使用できるとも限りません。

// ふたつ目の方法は never 型を使用することです。
// 以下の例の assertNever では条件分岐で指定されていない型がない (never 型である) ことをチェックしています。
// 条件分岐に漏れがあった場合には s がその型となるため、コンパイルエラーとなります。
function assertNever(x: never): never {throw new Error("Unexpected object: " + x);}
function area(s: Shape) {
    switch (s.kind) {
        case "square": return s.size * s.size;
        case "rectangle": return s.height * s.width;
        case "circle": return Math.PI * s.radius ** 2;
        default: return assertNever(s); // 条件分岐が不足している場合、ここでエラーになる
    }
}
// この方法は追加の関数が必要となりますが、やりたいことが非常に明確です。


// Polymorphic this types ----------------------------------------------------------------------------------------------
// unded polymorphism と呼ばれるもので、階層構造を持つ流れるようなインタフェースを表現しやすくしてくれます。

// 以下の例では各演算の後に this を返却しています。
class BasicCalculator {
    public constructor(protected value: number = 0) { }
    public currentValue(): number {
        return this.value;
    }
    public add(operand: number): this {
        this.value += operand;
        return this;
    }
    public multiply(operand: number): this {
        this.value *= operand;
        return this;
    }
    // ... 他の演算が続く ...
}

let v = new BasicCalculator(2)
    .multiply(5)
    .add(1)
    .currentValue();
// このクラスでは this 型を使用しているため、このクラスを拡張した新しいクラスでもそのまま元のメソッドを使用できます。
class ScientificCalculator extends BasicCalculator {
    public constructor(value = 0) {super(value)}
    public sin() {
        this.value = Math.sin(this.value);
        return this;
    }
    // ... 他の演算が続く ...
}

let v = new ScientificCalculator(2)
    .multiply(5)
    .sin()
    .add(1)
    .currentValue();
// this 型を使用しなかった場合、流れるようなインタフェースを維持したまま BasicCalculator を継承することはできなかったでしょう。
// というのも、multiply の戻り値は BasicCalculator なので、そこから sin を呼び出すことはできないためです。
// this 型を使用すると multiply の戻り値が this (ここでは ScientificCalculator) になるため、このように記述することが可能です。

// Index types ---------------------------------------------------------------------------------------------------------
// インデックス型を使用すると動的なプロパティ名のチェックが可能になります。

// 例として、オブジェクトのプロパティの一部を取り出すパターンを見てみましょう。
//  JavaScript
function pluck(o, names) {
    return names.map(n => o[n]);
}
// TypeScript では以下のように インデックス型クエリ と 添字アクセス演算子 を使用します。

function pluck<T, K extends keyof T>(o: T, names: K[]): T[K][] {
    return names.map(n => o[n]);
}

interface Person {
    name: string;
    age: number;
}
let person: Person = {
    name: 'Jarid',
    age: 35
}
let strings: string[] = pluck(person, ['name']); // OK。string[] になる
// この例にはいくつか新しい演算子が登場するため、順番に説明していきましょう。

// 最初に登場する演算子は keyof T です。
// これは インデックス型クエリ演算子 と呼ばれるもので、任意の型 T に対し、T の public プロパティの名前の集合を表します。


let personProps: keyof Person; // 'name' | 'age'
// keyof Person は 'name' | 'age' と宣言するのと同じですが、
// 新たなプロパティを Person に追加した場合に keyof Person は自動的に更新される点が異なります。
// また、それ以外に keyof は pluck のようにジェネリッククラス/関数と組み合わせて使用することも可能です。
// つまり、pluck に正しいプロパティ名を渡しているかコンパイラがチェックしてくれるということです。

pluck(person, ['age', 'unknown']); // エラー。'unknown' は 'name' | 'age' に含まれない
// ふたつ目の演算子は T[K] です。
// これは 添字アクセス演算子 と呼ばれるもので、その式の表す型を表します。
// つまり、person['name'] は Person['name'] 型 (上記の例では string)　ということになります。
// また、インデックス型クエリと同様に T[K] はジェネリッククラス/関数で使用することが可能です。
// ただし、型変数として K extends keyof T を宣言し忘れないようにしてください。

// 以下の例では o: T、name: K であることから、o[name] は T[K] 型になります。
function getProperty<T, K extends keyof T>(o: T, name: K): T[K] {
    return o[name]; // o[name] は T[K] 型
}
// コンパイラは T[K] を実際の型に解釈してくれるため、getProperty は指定されたプロパティに応じて様々な型を返却できます。

let name: string = getProperty(person, 'name');
let age: number = getProperty(person, 'age');
let unknown = getProperty(person, 'unknown'); // エラー。'unknown' は 'name' | 'age' に含まれない

// Index types and string index signatures ----------------------------
// keyof と T[K] は文字列型インデックスシグネチャの影響を受けます。
// 文字列型インデックスシグネチャを宣言した場合、keyof T は string になり、T[string] はそのインデックスシグネチャの型になります。

interface Map<T> {[key: string]: T}
let keys: keyof Map<number>; // string
// let value: Map<number>['foo']; number

// Mapped types --------------------------------------------------------------------------------------------------------
// 既存の型に対し、各プロパティを任意にしたり、
interface PersonPartial {
    name?: string;
    age?: number;
}
// 読み取り専用にしたいということはよくあるでしょう。

interface PersonReadonly {
    readonly name: string;
    readonly age: number;
}
// TypeScript ではこのような古い型に基づく新しい型 (マップ型) を作成する機能を提供しています。
// マップ型では古い型の各プロパティに対し、同じ変換を行うことで新しい型のプロパティを作成します。

// 例として、すべてのプロパティを readonly または任意にする例を見てみましょう。
type Readonly<T> = {readonly [P in keyof T]: T[P]}
type Partial<T> = {[P in keyof T]?: T[P]}
// type 〜 = は単なる型エイリアスの宣言で、キモは [P in keyof T]: T[P] の部分
// これらの使い方は以下の通りです。


type PersonPartial = Partial<Person>;
type ReadonlyPerson = Readonly<Person>;
// また、一番簡単なマップ型の例を見てみましょう。

type Keys = 'option1' | 'option2';
type Flags = { [K in Keys]: boolean };
// マップ型の構文は for ... in の構文と似ており、3 つのパートから成ります。

// 型変数 K: 各プロパティを表す
//     リテラル文字列共用体 Keys: プロパティ名の集合
//     そのプロパティの型
//     上記の例では Keys はハードコーディングされたプロパティ名のリストで、プロパティの型は常に boolean でした。
// つまり、このマップ型は以下のようになります。
type Flags = {
    option1: boolean;
    option2: boolean;
}
// 実際のアプリケーションでは最初の Readonly や Partial のように既存の型に対して変換を行うでしょう。
// そのため、keyof と添字アクセス演算子を使って以下のように記述します。

type NullablePerson = { [P in keyof Person]: Person[P] | null }
type PartialPerson = { [P in keyof Person]?: Person[P] }
// これのジェネリック版はもっと役に立つことでしょう。

type Nullable<T> = { [P in keyof T]: T[P] | null }
type Partial<T> = { [P in keyof T]?: T[P] }
// この例では keyof T がプロパティリスト、T[P] を変換したものがプロパティの型になります。

// また、元のプロパティの修飾子は新しいプロパティにも引き継がれます。
// つまり、Person.name が読み取り専用であれば Partial<Person>.name は読み取り専用かつ任意になります。

// 他の例として、T[P] を Proxy<T> でラップした例を見てみましょう。
type Proxy<T> = {
    get(): T;
    set(value: T): void;
}

type Proxify<T> = {
    [P in keyof T]: Proxy<T[P]>;
    }
function proxify<T>(o: T): Proxify<T> {
    // ... プロキシでラップする ...
}

let proxyProps = proxify(props);
// Readonly<T> と Partial<T> は非常に便利なため、Pick、Record と一緒にTypeScript の標準ライブラリに含まれています。
type Pick<T, K extends keyof T> = {
    [P in K]: T[P];
}
type Record<K extends string, T> = {
    [P in K]: T;
}
// Readonly、Partial、Pick は準同型であるのに対し、Record はコピー元となる入力クラスを受け取らないため、準同型ではありません。

type ThreeStringProps = Record<'prop1' | 'prop2' | 'prop3', string>
// 非準同型な型は新しいプロパティを作るため、修飾子 (readonly 等) はコピーされません。


// Inference from mapped types ----------------------------------------
// ラップしたプロパティの取り出しは非常に簡単です。
function unproxify<T>(t: Proxify<T>): T {
    let result = {} as T
    for (const k in t) {result[k] = t[k].get()}
    return result
}

let originalProps = unproxify(proxyProps)
// マップ型が準同型である場合のみ、型推論が行われることに注意してください。
// もしマップ型が非準同型の場合、明示的に型引数を指定する必要があります。









































