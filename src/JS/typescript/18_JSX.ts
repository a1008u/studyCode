/** ---------------------------------
JSX
 --------------------------------- */
// Introduction ---------------------------------
// JSXはXMLに似た、埋め込み構文であり、JavaScriptコードに変換することができます。
// JSXはReactフレームワークによって有名になりましたが、他のアプリケーションでも使用されています。
// TypeScriptではJSXの埋め込み、型チェック、およびJavaScriptへの直接変換をサポートしています。

// Basic usage ---------------------------------------------------------------------------------------------------------
// JSXを使用するには以下のふたつが必要です。
//
// 1.ファイルの拡張子を .tsx にする
// 2.jsx オプションを有効にする
//
// TypeScriptではperserve、react、react-native の3種類のJSXモードを提供しています。
// preserveモードでは他の変換フェーズ (Babel 等)で処理するためにJSXをそのまま出力します。
// この時の出力ファイルの拡張子は .jsxになります。
// reactモードでは React.createElementを出力するため、他のツールでJSXを変換する必要がありません。
// また、出力ファイルの拡張子は.jsになります。
// react-nativeモードはpreseveモードと同じく、JSXをそのまま出力しますが、拡張子は.jsになります。
//
// Mode	         Input	   Output
// preserve	    <div />	   <div />
// react	    <div />	   React.creteElement("div")
// react-native	<div />	   <div />
// JSX モードは --jsx コマンドラインオプションまたは tsconfig.json で指定します。
//
// Reactという識別子はハードコーディングされているため、大文字のRで始まる識別子(React)が使用可能でなければなりません。

// The as operator -----------------------------------------------------------------------------------------------------
// TypeScriptでは以下のように角括弧を使用してキャストすることができますが、
// JSXの構文と区別することが困難であるため、.tsxファイルでは角括弧によるキャストを禁止しています。
var foo = <foo>bar

// .tsx ファイルでキャストを行うために as 演算子が追加されています。
// as演算子を使用すると先ほどの例は以下のように書き換えることができます。

var foo = bar as foo // as演算子は .tsファイルと.tsxファイルのどちらでも使用することができます。


// Type Checking -------------------------------------------------------------------------------------------------------
// JSXにおける型チェックを理解するために、まず固有要素と値に基づく要素の違いを理解しておきましょう。
// <expr /> というJSX文が与えられた場合、exprは環境固有のもの (DOM 環境下における divやspan等) か、
// 自作コンポーネントのいずれかを指すことになります。
// これは以下の 2 点において重要です。
//
// 1.React では固有要素は文字列として出力 (React.createElement("div")) されるのに対し、
//   自作コンポーネントはそのまま出力されます (React.createElement(MyComponent))。
// 2.JSX 要素に渡された属性はそれぞれ異なる方法で解決されます。
//   固有要素の場合、属性は 固有の ものである必要がありますが、自作コンポーネントであれば独自の属性を指定することができます。
//
// TypeScriptではReactと同じ方法でこれらの要素を区別します。
// つまり、小文字で始まる要素は固有要素として、大文字で始まる要素は値に基づく要素として扱います。

// Intrinsic elements -------------------------------------------------
// 固有要素は JSX.IntrinsicElements という特殊なインタフェースの中から検索されます。
// デフォルトでは、このインタフェースが指定されていなければ型チェックは行われません。
// このインタフェースが指定されている場合は JSX.IntrinsicElements のプロパティの中から固有要素の名前が検索されます。

declare namespace JSX {
    interface IntrinsicElements {
        foo: any
    }
}

// <foo />; // OK
// <bar />; // エラー


// 上記の例では <foo /> は正しく動作しますが、<bar /> は JSX.IntrinsicElements内に指定されていないため、正しく動作しません。
// 以下のように、すべての要素用の文字列インデクサを指定することも可能です
declare namespace JSX {
    interface IntrinsicElements {
        [elemName: string]: any;
    }
}



// Value-based elements ------------------------------------------------------------------------------------------------
// 値に基づく要素は単純にスコープ内の識別子の中から検索されます。
import MyComponent from "./myComponent";

// <MyComponent />; // OK
// <SomeOtherComponent />; // エラー

// 値に基づく要素の型を制限することも可能ですが、そのためには要素のクラス型と要素のインスタンス型について理解する必要があります。
//
// <Expr /> が与えられた場合、Expr の型が 要素のクラス型に該当します。
// 上記の例で言うと、MyComponentがES6のクラスの場合には要素のクラス型はそのクラスそのものになりますし、
// MyComponentがファクトリ関数の場合には関数になります。
//
// クラス型が決まると、そのクラス型のシグネチャとコンストラクチャシグネチャの戻り値の共用体がインスタンス型になります。
// 先ほどの例で言うと、クラス型が ES6 のクラスの場合はそのクラスのインスタンスの型がインスタンス型になりますし、
// ファクトリ関数の場合はその関数の戻り値の型がインスタンス型になります。

class MyComponent {
    render() {}
}

// コンストラクタシグネチャを使用する
var myComponent = new MyComponent();

// 要素のクラス型 => MyComponent
// 要素のインスタンス型 => { render: () => void }
function MyFactoryFunction() {
    return {
        render: () => {
        }
    }
}

// 呼び出しシグネチャを使用する
var myComponent = MyFactoryFunction();

// 要素のクラス型 => FactoryFunction
// 要素のインスタンス型 => { render: () => void }
// 要素のインスタンス型は JSX.ElementClass に代入可能である必要があり、そうでない場合はエラーとなります。
// デフォルトでは JSX.ElementClass は {} ですが、このインタフェースを拡張することで、
// 特定のインタフェースを持つ型だけをJSXで使用できるようにすることが可能です。

declare namespace JSX {
    interface ElementClass {
        render: any;
    }
}

class MyComponent {
    render() {}
}
function MyFactoryFunction() {
    return { render: () => {} }
}

// <MyComponent />; OK
// <MyFactoryFunction />; OK

class NotAValidComponent {}
function NotAValidFactoryFunction() {
    return {};
}

// <NotAValidComponent />; エラー
// <NotAValidFactoryFunction />; エラー

// Attribute type checking ---------------------------------------------------------------------------------------------
// 属性の型チェックを行うためには、まず要素の属性の型を判定する必要があります。
// この判定方法は固有要素と値に基づく要素とで若干異なります。
// 固有要素の場合、JSX.IntrinsicElementsのプロパティの型が使用されます。
declare namespace JSX {
    interface IntrinsicElements {
        foo: { bar?: boolean }
    }
}

// 'foo' の属性型は '{bar?: boolean}'
// <foo bar />;
// 値に基づく要素の場合、要素のインスタンス型 のプロパティの型に基づいて判定されます。
// また、そのプロパティは JSX.ElementAttributesProperty に定義する必要があります。
declare namespace JSX {
    interface ElementAttributesProperty {
        props; // 使用するプロパティ名を指定する
    }
}

class MyComponent {
    // 要素のインスタンス型のプロパティを指定する
    props: {
        foo?: string;
    }
}

// 'MyComponent' の属性型は '{foo?: string}'
// <MyComponent foo="bar" />
//また、任意のプロパティと必須のプロパティにも対応しています。
declare namespace JSX {
    interface IntrinsicElements {
        foo: { requiredProp: string; optionalProp?: number }
    }
}

<foo requiredProp="bar" />; // OK
<foo requiredProp="bar" optionalProp={0} />; // OK
<foo />; // エラー、requiredProp が足りない
<foo requiredProp={0} />; // エラー、requiredProp は文字列型でないといけない
<foo requiredProp="bar" unknownProp />; // エラー、unknownProp は存在しない
<foo requiredProp="bar" some-unknown-prop />; // OK、なぜなら 'some-unknown-prop' は正しい識別子ではないため。
// 属性名が正しい JavaScript の識別子 (data-* 属性等) でない場合、該当するプロパティが存在しなくてもエラーにはなりません。

// 展開演算子も使用できます。
var props = { requiredProp: "bar" };
// <foo {...props} />; // OK

var badProps = {};
// <foo {...badProps} />; // エラー


// The JSX result type -------------------------------------------------------------------------------------------------
// デフォルトではJSX式の戻り値はany型です。
// JSX.Elementインタフェースを指定することでこれを変更することが可能ですが、
// 要素、属性、子要素の型情報はブラックボックス化されており、このインタフェースから取得することはできません。

// Embedding Expressions -------------------------------------
// 波括弧 ({ }) で囲むことで、タグ内に式を埋め込むことが可能です。
var a = <div>
    {["foo", "bar"].map(i => <span>{i / 2}</span>)}
</div>
// 上記のコードは文字列を数値で割ることができないため、エラーになるでしょう。
// pereserve オプションを使用した場合、以下のようなコードが出力されます。

var a = <div>
    {["foo", "bar"].map(function (i) { return <span>{i / 2}</span>; })}
</div>

// React integration ---------------------------------------------------------------------------------------------------
// JSXをReactと一緒に使用する場合、React typeingsを使用する必要があります。
// このtypingsではReactと一緒に使用するために必要なJSX名前空間が定義されています。

// <reference path="react.d.ts" />

interface Props {
    foo: string;
}

class MyComponent extends React.Component<Props, {}> {
    render() {
        return <span>{this.props.foo}</span>
    }
}

// <MyComponent foo="bar" />; // OK
// <MyComponent foo={0} />; // エラー

