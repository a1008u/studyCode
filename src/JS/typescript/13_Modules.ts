/** ------------------------------------------
 Modules
 ------------------------------------------ */
// Introduction
// ECMAScript 2015 からモジュールという考え方が導入されましたが、TypeScriptも同様の考え方を持っています。
// モジュールは独自のスコープの中で実行されるため、
// いずれかのexport形式に従って明示的にエクスポートしない限り、
// モジュール外から参照することはできません。
// 逆に、他のモジュールからエクスポートされたものを使用するためには、
// いずれかのimport形式に従ってインポートする必要があります。
//
// モジュールは宣言的であり、モジュール間の依存関係はファイル単位で記述します。
//
// 各モジュールはモジュールローダーによってファイルの場所と依存関係の解決が行われます。
// JavaScriptでよく知られているモジュールローダーとしては、
// Node.jsで用いられているCommonJSやWebアプリケーションでよく使用されるrequire.jsが挙げられます。
//
// TypeScriptではECMAScript2015と同様に、トップレベルでimport、exportが使用されているファイルはすべてモジュールとして扱います。


// Export --------------------------------------------------------------------------------------------------------------
// Exporting a declaration --------------------------------
// 変数、関数、クラス、型エイリアス、インタフェースといった、任意の宣言をexport キーワードによってエクスポートすることが可能です。
export const numberRegexp = /^[0-9]+$/;

export class ZipCodeValidator implements StringValidator {
    isAcceptable(s: string) {
        return s.length === 5 && numberRegexp.test(s);
    }
}

let ZCV = new ZipCodeValidator()
console.log(ZCV.isAcceptable("12345")) // true

// Export statements --------------------------------------
// 別名でエクスポートする時には export 文が便利です。
class ZipCodeValidator2 implements StringValidator {
    isAcceptable(s: string) {
        return s.length === 5 && numberRegexp.test(s);
    }
}
export { ZipCodeValidator2 }; // 'ZipCodeValidator' としてエクスポート
export { ZipCodeValidator2 as mainValidator }; // 'mainValidator' としてエクスポート

// Re-exports ---------------------------------------------
// 他のモジュールを拡張したり、一部の機能のみを再利用することはよくありますが、モジュールを再エクスポートしても、
// 再エクスポートを行っているモジュール内に元のモジュールがインポートされたり、ローカル変数に格納されることはありません。
export class ParseIntBasedZipCodeValidator {
    isAcceptable(s: string) {return s.length === 5 && parseInt(s).toString() === s}
}

// 元のバリデータを別名でエクスポートする
export {ZipCodeValidatorX as RegExpBasedZipCodeValidator} from "./13_ZipCodeValidator";

// 複数のモジュールをまとめてエクスポート
export * from "./13_ZipCodeValidator";  // '13_ZipCodeValidator' クラスをエクスポート

// Import --------------------------------------------------------------------------------------------------------------
// Import a single export from a module  --------------------------------------------------------------
// モジュールのインポートはモジュールのエクスポートと同じくらい簡単です。
import { ZipCodeValidatorX } from "./13_ZipCodeValidator"
let myValidator4 = new ZipCodeValidator()
console.log(myValidator4.isAcceptable("12345")) // true

import { ZipCodeValidatorX as ZCV5 } from "./13_ZipCodeValidator"
let myValidator5 = new ZCV5()
console.log(myValidator5.isAcceptable("12345")) // true

// Import the entire module into a single variable, and use it to access the module exports -----------
import * as validator from "./13_ZipCodeValidator"
let myValidator6 = new validator.ZipCodeValidatorX()
console.log(myValidator6.isAcceptable("12345")) // true
// Import a module for side-effects only  -------------------------------------------------------------
// 非推奨のため割愛

// Default exports  ----------------------------------------------------------------------------------------------------
// 各モジュールは必要に応じてデフォルトエクスポートが可能です。
// デフォルトエクスポートは1モジュールにつき一回だけ宣言することが可能で、default キーワードを使用して宣言します。
// デフォルトエクスポートは非常に便利で例えばJQueryであればjQueryや$をデフォルトエクスポートしています。
// JQuery.d.ts
//    declare let $: JQuery;
//    export default $;
//App.ts
//    import $ from "JQuery";
//    $("button.continue").html( "Next Step..." );

// クラスや関数であれば宣言時に直接デフォルトエクスポートにすることが可能です。
// デフォルトエクスポートするクラスや関数は必ずしも名前を付ける必要はありません。
import validator2 from "./13_ZipCodeValidator";
let myValidator7 = new validator2();
console.log(myValidator7.isAcceptable("12345")) // true

// functionをimportする
import validate3 from "./13_StaticZipCodeValidator";
let strings = ["Hello", "98052", "101"];
// バリデート関数を使用する
/*
"Hello"  does not match
"98052"  matches
"101"  does not match
 */
strings.forEach(s => {
    console.log(`"${s}" ${validate3(s) ? " matches" : " does not match"}`);
});

// 値そのもののimport
import num from "./13_OneTwoThree";
console.log(num); // "123"

// export = and import = require()  ---------------------------------------------
// TypeScriptは従来のCommonJSやAMDで用いられていたexport = 構文をサポートしています。
// export = 構文では単一のオブジェクトをエクスポートすることができます。
//
// export = を使用したモジュールをインポートする時にはTypeScript独自の構文である
// import 〜 = require("module") を使用する必要があります。
import zip5 = require("./13_ZipCodeValidator2");

// バリデーション対象
let strings5 = ["Hello", "98052", "101"];

// 使用するバリデータ
let validator5 = new zip5();

// 各文字列がバリデーションを通過したかどうかを表示する
strings5.forEach(s => {
    console.log(`"${ s }" - ${ validator5.isAcceptable(s) ? "matches" : "does not match" }`);
});
/*
"Hello" - does not match
"98052" - matches
"101" - does not match
 */

// Code Generation for Modules -----------------------------------------------------------------------------------------
// また後で

// Simple Example ------------------------------------------------------------------------------------------------------
// Optional Module Loading and Other Advanced Loading Scenarios
// Working with Other JavaScript Libraries
// Ambient Modules
// Shorthand ambient modules
// Wildcard module declarations
// UMD modules
// Guidance for structuring modules
// Export as close to top-level as possible
// If you’re only exporting a single class or function, use export default
// If you’re exporting multiple objects, put them all at top-level
// Explicitly list imported names
// Use the namespace import pattern if you’re importing a large number of things
// Re-export to extend
// Do not use namespaces in modules
// Red Flags