//var declarations ----------------------------------------------
var aaaaa = 10;

/** -----------------------------------------------------------------
 let declarations
 ----------------------------------------------------------------- */
// Block-scoping (var と異なり、let で宣言された変数はブロックスコープになります。) --------------------------------------------
function fffff(input: boolean) {
    let a = 100;

    if (input) {
        // ここからでも 'a' にアクセスすることができる
        let b = a + 1;
        return b;
    }

    // エラー。 ここでは 'b' にはアクセスできない
    // return b;
}

try {
    throw "oh no!";
}
catch (e) {
    console.log("Oh well.");
}

// エラー。ここでは 'e' にアクセスできない
// console.log(e);

// a++; エラー。まだ 'a' は宣言していない。
// let a;

// Re-declarations and Shadowing ---------------------------------------------------------------------------------------
let x = 10;
// let x = 20; エラー。同じスコープでは 1 回しか変数宣言できない

// 比較（変数宣言）-------------------------------------------------------------------------------------------------------
// function f(x) {
//     let x = 100; // エラー。引数と重複している
// }

function g() {
    let x1 = 100
    // var x1 = 100; // エラー。すでに変数宣言している
}

// ブロックを分割
function ff(condition, x2) {
    if (condition) {
        let x2 = 100
        return x2
    }

    return x2
}

console.log(ff(false, 0)) // 0 (引数の 'x' が返ってくる)
console.log(ff(true, 0))  // 100 (if 文の中の 'x' が返ってくる)

// シャドーイング(入れ子になったブロックの中で同じ変数を宣言すること) -----------------------------------------------------------
function sumMatrix(matrix: number[][]) {
    let sum = 0;
    for (let i = 0; i < matrix.length; i++) {
        var currentRow = matrix[i];
        for (let i = 0; i < currentRow.length; i++) { // また 'i' を宣言している
            sum += currentRow[i];
        }
    }

    return sum;
}

// Block-scoped variable capturing -------------------------------------------------------------------------------------
// 一度キャプチャした変数はスコープを抜けた後でもアクセスできる
function theCityThatAlwaysSleeps() {
    let getCity;

    if (true) {
        let city = "Seattle";
        getCity = function() {
            return city;
        }
    }


    return getCity();
}

// let キーワードはループの中で使われると、繰り返しごとに新たなスコープを作成
function test(){
    for (let i = 0; i < 10 ; i++) {
        setTimeout(function() { console.log(i); }, 100 * i);
    }
}
console.log("testの結果" + test()); // 0123456789

// const declarations 定数宣言 ------------------------------------------------------------------------------------------
const numLivesForCat = 9;
const kitty = {
    name: "Aurora",
    numLives: numLivesForCat,
}

// すべて OK。 'kitty' は定数でも、そのプロパティまでは定数にならない。
kitty.name = "Rory";
kitty.name = "Kitty";
kitty.name = "Cat";
kitty.numLives--;

// エラー。'kitty' は変更できない
// kitty = {
//     name: "Danielle",
//     numLives: numLivesForCat
// };


/** -----------------------------------------------------------------
 Destructuring
 ----------------------------------------------------------------- */
// Array destructuring -------------------------------------------------------------------------------------------------
// 変数分割の単純な例は以下の通りです
let input = [1, 2];
let [first1, second2] = input;
console.log(first1); // 1
console.log(second2); // 2
[first1, second2] = [second2, first1];

// methodでの利用
function ffff([first11, second22]: [number, number]) {
    console.log(first11);
    console.log(second22);
}
ffff([1, 2]);

// ... を使って変数の残り部分を受け取る
let [first111, ...rest111] = [1, 2, 3, 4];
console.log(first111); // 1
console.log(rest111); // [ 2, 3, 4 ]

let [firstF] = [1, 2, 3, 4];
console.log(firstF); // 1 後続無視
let [, secondS, , fourthF] = [1, 2, 3, 4]; // 使用しない要素は無視

// Object destructuring ------------------------------------------------------------------------------------------------
let o = {aa: "foo",
         bb: 12,
         cc: "bar"
        }
let { aa, bb } = o;

// 変数宣言なしに分割する
({ aa, bb } = { aa: "baz", bb: 101 });

let { ...passthrough2 } = o;
let total = passthrough2.bb + passthrough2.cc.length;
console.log("total:::" + total);

// Property renaming ---------------------------------------------------------------------------------------------------
let o2 = {
    a: "foo",
    b: 12,
    c: "bar"
}
// let { a: newName1, b: newName2 } = o2; // 型指定なし + 別名（プロパティ名を）
// let { a, b }: { a: string, b: number } = o; // 型指定 + 別名（プロパティ名を）なし
// let { a: newName1, b: newName2 }: { a: string, b: number } = o;　// 型指定 + 別名（プロパティ名を）

// Default values ------------------------------------------------------------------------------------------------------
// プロパティが指定されていない場合のデフォルト値
let keepWholeObject = (wholeObject: { aC: string, bC?: number }) =>  {
    let { aC, bC = 1001 } = wholeObject;
    console.log(aC)
    console.log(bC)
    return { aC, bC }
}

console.log(keepWholeObject({ aC: "a"}));
console.log(keepWholeObject({ aC: "a", bC: 1 }));


// Function declarations -----------------------------------------------------------------------------------------------
// 変数分割はメソッドの引数にも使うことができます。
type C = { aC: string, bC?: number }
function f2({ aC, bC }: C): void {
    // ...
}

function f3({ af3, bf3 } = { af3: "", bf3: 0 }): void {
    // ...
}
f3(); // OK。デフォルト値の { a: "", b: 0 } が使われる

function f({ a, b = 0 } = { a: "" }): void {
    // ...
}
f({ a: "yes" }) // OK。変数分割時のデフォルト値 b = 0 が使われる
f() // OK。デフォルト引数の { a: "" } と、変数分割時のデフォルト値 b = 0 が使われる
// f({})  エラー。メソッドの引数は 'a' プロパティを持つ必要がある

// Spread --------------------------------------------------------------------------------------------------------------
// スプレッド演算子 (...) は変数分割とは逆に、ある配列を他の配列の中に展開します。
let first = [1, 2];
let second = [3, 4];
let bothPlus = [0, ...first, ...second, 5];
console.log(bothPlus); // [0, 1, 2, 3, 4, 5]

let defaults = { food: "spicy", price: "$$", ambiance: "noisy" };
let search = { ...defaults, food: "rich" };
console.log(search); // { food: "rich", price: "$$", ambiance: "noisy" };

// 同名のプロパティは、より後に指定された値で上書きされるため、展開した値で上書きしたい場合は以下のように変数の順番を入れ替えます。
let defaults2 = { food: "spicy", price: "$$", ambiance: "noisy" };
let search2 = { food: "rich", ...defaults2 };
console.log(search2); // { food: "spicy", price: "$$", ambiance: "noisy" };

// 例外 原則としてオブジェクトインスタンスを展開するとメソッドが失われる。
class D {
    p = 12;
    m() {
    }
}
let d = new D();
let clone = { ...d };
// clone.p; エラー!
// clone.m(); エラー!