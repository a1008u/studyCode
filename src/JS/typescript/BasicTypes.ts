/** ----------------------------------------------------------------------------------------
 型の理解
----------------------------------------------------------------------------------------*/
// Boolean
let isDone: boolean = false;

// Number
let decimal: number = 6;
let hex: number = 0xf00d;
let binary: number = 0b1010;
let octal: number = 0o744;

// String
let color: string = "blue";
color = 'red';

// バッククォート(`)で囲んだ文字列には ${　expr　} で変数・式を埋め込める
let fullName: string = `Bob Bobbington`;
let age: number = 37;
let sentence: string = `Hello, my name is ${ fullName }.
　　　　　　　　　　　　　　I'll be ${ age + 1 } years old next month.`
console.log(sentence);


// Tuple ----------------------------------------------------------------------------------------
// 宣言 初期化
let x2: [string, number];
x2 = ["hello", 10]; // OK
console.log(x2[0].substr(1)); // ello

x2[3] = "world"; // OK。 'string' は 'string | number' 型に代入可能。
console.log(x2[5].toString()); // OK。 'string' と 'number' 両方にあるメソッドは呼び出し可。

// (間違い)
// 初期化
// x = [10, "hello"]; エラー
// console.log(x[1].substr(1));　エラー
// x[6] = true; エラー。 'boolean' は 'string | number' 型には代入できない。

// Enum ----------------------------------------------------------------------------------------
// ナンバリング変更(default, 1から, 全部変更, index)（defaultは0）
enum Color1 {Red, Green, Blue};
let c1: Color1 = Color1.Green;

enum Color2 {Red = 1, Green, Blue};
let c2: Color2 = Color2.Green;

enum Color3 {Red = 1, Green = 2, Blue = 4};
let c3: Color3 = Color3.Green;

enum Color4 {Red = 1, Green, Blue};
let colorName: string = Color4[2];
console.log("colorNameは" + colorName);// Green

// Any ----------------------------------------------------------------------------------------
let notSure1: any = 4;
notSure1 = "maybe a string instead";
notSure1 = false; // 今度は boolean

// Object型でも似たようなことができますが、任意の型を代入できるだけで、その型のメソッドを呼ぶことはできません。
let notSure: any = 4;
notSure.ifItExists(); // OK。 実行時には ifItExists メソッドが存在するはず
notSure.toFixed(); // OK。 toFixed メソッドは存在する (けど、コンパイル時チェックはしない)

let prettySure: Object = 4;
// prettySure.toFixed(); エラー。 toFixed メソッドは Object 型には存在しない。

// Void Null Undefined ---------------------------------------------------------------------------
// Void 型には undefined か null しか代入できません。
function warnUser(): void {
    let u: undefined = undefined;
    let n: null = null;
    let unusable: void = undefined;
    console.log("void ======= This is my warning message");
}

// Never ----------------------------------------------------------------------------------------
// 例外をスローするのでメソッドの最後まで絶対に到達しない
function error(message: string): never {throw new Error(message);}

// Never 型を return するなら、そのメソッドの戻り値も Never 型になる
function fail() : never { return error("Something failed");}

// 無限ループするのでメソッドの最後まで絶対に到達しない
function infiniteLoop(): never {while (true) {} }

// キャスト(Type assertion)
let someValue: any = "this is a string";

let strLength1: number = (<string>someValue).length;
let strLength2: number = (someValue as string).length;
console.log("strLength1の結果：：：" + strLength1);
console.log("strLength2の結果：：：" + strLength2);