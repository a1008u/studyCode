/** --------------------------------------------------
 Namespaces
 -------------------------------------------------- */
// First steps
// コード例として、ユーザ入力や外部ファイルをバリデーションするための簡単な文字列バリデータを使用します。
interface StringValidator {isAcceptable(s: string): boolean;}
let lettersRegexp = /^[A-Za-z]+$/
let numberRegexp = /^[0-9]+$/

class LettersOnlyValidator implements StringValidator {
    isAcceptable(s: string) {return lettersRegexp.test(s)}
}

class ZipCodeValidator implements StringValidator {
    isAcceptable(s: string) {return s.length === 5 && numberRegexp.test(s)}
}

// 使用するバリデータ
let validators: { [s: string]: StringValidator; } = {}
validators["ZIP code"] = new ZipCodeValidator()
validators["Letters only"] = new LettersOnlyValidator()

// 各文字列がバリデーションを通過したかどうかを表示する
// チェック対象
let strings = ["Hello", "98052", "101"]
for (let s of strings) {
    for (let name in validators) {
        let isMatch = validators[name].isAcceptable(s)
        console.log(`'${ s }' ${ isMatch ? "matches" : "does not match" } '${ name }'.`)
    }
}

/*
'Hello' does not match 'ZIP code'.
'Hello' matches 'Letters only'.
'98052' matches 'ZIP code'.
'98052' does not match 'Letters only'.
'101' does not match 'ZIP code'.
'101' does not match 'Letters only'.
*/

// Namespacing
// バリデータを追加するにつれて、バリデータの管理や名前の衝突の回避のためになんらかの方法でバリデータを整理したいと思うかもしれません。
// その場合、個別に名前を付けてグローバル名前空間に配置する代わりに、オブジェクトを名前空間でラップしてみましょう。
// 先ほどの例について、バリデータに関係するコードを Validation に移動し、外部に公開するインタフェース/クラスに export を付与します。
// 逆に、lettersRegexp、numberRegexp は実装の詳細であるため、エクスポートしないようにします。
// 名前空間の外からバリデータを使用するためには、名前空間名付きで指定する必要があります。(例: Validation.LettersOnlyValidator)
namespace Validation {
    export interface StringValidator {isAcceptable(s: string): boolean}

    const lettersRegexp = /^[A-Za-z]+$/;
    const numberRegexp = /^[0-9]+$/;

    export class LettersOnlyValidator implements StringValidator {
        isAcceptable(s: string) {return lettersRegexp.test(s)}
    }

    export class ZipCodeValidator implements StringValidator {
        isAcceptable(s: string) {return s.length === 5 && numberRegexp.test(s)}
    }
}

// 使用するバリデータ
let validators2: { [s: string]: Validation.StringValidator; } = {};
validators2["ZIP code"] = new Validation.ZipCodeValidator();
validators2["Letters only"] = new Validation.LettersOnlyValidator();

// 各文字列がバリデーションを通過したかどうかを表示する
// チェック対象
let strings2 = ["Hello", "98052", "101"];
for (let s of strings2) {
    for (let name in validators2) {
        console.log(`"${ s }" - ${ validators[name].isAcceptable(s) ? "matches" : "does not match" } ${ name }`);
    }
}

/*
"Hello" - does not match ZIP code
"Hello" - matches Letters only
"98052" - matches ZIP code
"98052" - does not match Letters only
"101" - does not match ZIP code
"101" - does not match Letters only
*/

// Splitting Across Files ----------------------------------------------------------------------------------------------
// Multi-file namespaces
// 次に、Validation名前空間を複数のファイルに分割してみましょう。
// ファイルが分かれていても、参照タグを基にそれらの間の依存関係を解決するため、あたかも一箇所で定義されているかのように扱うことが可能です。

// 別ファイル
namespace Validation2 {
    export interface StringValidator {isAcceptable(s: string): boolean}
}

// 別ファイル
namespace Validation3 {
    const numberRegexp = /^[0-9]+$/;
    export class ZipCodeValidator implements StringValidator {
        isAcceptable(s: string) {return s.length === 5 && numberRegexp.test(s)}
    }
}

// 別ファイル
namespace Validation4 {
    const lettersRegexp = /^[A-Za-z]+$/;
    export class LettersOnlyValidator implements StringValidator {
        isAcceptable(s: string) {
            return lettersRegexp.test(s);
        }
    }
}

// 使用するバリデータ　mainファイル
let validators3: { [s: string]: Validation2.StringValidator } = {}
validators3["ZIP code"] = new Validation3.ZipCodeValidator()
validators3["Letters only"] = new Validation4.LettersOnlyValidator()
// 各文字列がバリデーションを通過したかどうかを表示する// チェック対象
let strings3 = ["Hello", "98052", "101"]
for (let s of strings3) {
    for (let name in validators3) {
        console.log("" + s + " " + (validators[name].isAcceptable(s) ? " matches " : " does not match ") + name)
    }
}
/*
Hello  does not match ZIP code
Hello  matches Letters only
98052  matches ZIP code
98052  does not match Letters only
101  does not match ZIP code
101  does not match Letters only
*/

// 分割したファイルはすべて読み込まれるようにしないといけませんが、そのためには 2 種類の方法があります。
// ひとつ目の方法は、--outFile フラグを使用してコンパイル時にひとつの JavaScript ファイルにまとめることです。

//コマンド
// tsc --outFile sample.js Test.ts
// 出力ファイル中における各ファイルの順番は参照タグを基に自動的に判定されますが、以下のように個別にファイルを指定することも可能です。

// コマンド
// tsc --outFile sample.js Validation.ts LettersOnlyValidator.ts ZipCodeValidator.ts Test.ts

// Aliases -------------------------------------------------------------------------------------------------------------
// 名前空間を簡単に取り扱う別の方法として、import q = x.y.z を使用して短縮名を作ることが可能です。
namespace Shapes {
    export namespace Polygons {
        export class Triangle { }
        export class Square { }
    }
}

import polygons = Shapes.Polygons;
let sq = new polygons.Square(); // ('new Shapes.Polygons.Square()' と同等)
// ここでrequireを使用する代わりに、シンボルの修飾名を直接代入していることに注意してください。
// varを使用した変数宣言に似ていますが、型や名前空間にも使用することができます。
// 重要なポイントとして、値に対してimportを使用した場合、
// 元のオブジェクトとは区別して扱われるため、値を変更しても元の値には反映されません。

// Working with Other JavaScript Libraries -----------------------------------------------------------------------------
// TypeScript で書かれていないライブラリについては、
// そのライブラリの提供す APIを宣言する必要があります。
// この実装を伴わない宣言のことを "ambient" と呼んでいます。
// Ambient Namespaces --------------------------------------------------------------------------------------
// 有名なライブラリであるD3はd3というグローバルオブジェクトを提供しています。
// このライブラリは (モジュールローダーを使用せずに) <script>タグ経由で読み込まれるため、ライブラリの宣言に名前空間を使用しています。
// TypeScript からこの宣言を参照するには、アンビエント名前空間を使用します。

// D3.d.ts（上級者向け簡易版）
declare namespace D3 {
    export interface Selectors {
        select: {
            (selector: string): Selection;
            (element: EventTarget): Selection;
        };
    }

    export interface Event {
        x: number;
        y: number;
    }

    export interface Base extends Selectors {
        event: Event;
    }
}

declare var d3: D3.Base;



