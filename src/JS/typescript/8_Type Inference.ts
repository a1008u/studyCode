/** ----------------------------------------------------
 Type Inference
 ----------------------------------------------------- */
// Basics --------------------------------------------------------------------------------------------------------------
// TypeScriptでは、型が明示されていない場合に型推論が行われるところが何箇所かあります。

let TIx = 3; // xの型はnumberと推論されます。
// このタイプの推論は、変数やメンバの初期化時、デフォルト引数の設定時、関数の戻り値の型の決定時に行われます。

// Best common type ----------------------------------------------------------------------------------------------------
// 複数の式に対して型推論が行われる場合、それらの式の "最適な共通型" が型として採用されます。
// 以下の例では、配列の各要素の型を基にxの型が推論されますが、各要素の型としてnumberまたはnullが考えられます。
let TIx2 = [0, 1, null];
    // --strictNullChecks を指定していない場合、nullをnumberに代入できるので x の型は number[] になる。
    // --strictNullChecks を指定している場合、nullをnumberに代入できないため、x の型は (number|null)[] になる。


// 最適な共通型は指定された型を基に選択されるため、
// 以下の例ではzooの型がAnimal[]として推論されてほしいと思うかもしれませんが、
// 実際には各要素がAnimalを継承したクラスではないのでそのようには推論されません。
let zoo = [new Rhino1(), new Elephant1(), new Snake1()]; // 共用配列型 ((Rhino | Elephant | Snake)[]) を指定
let zoo2: Animal[] = [new Rhino2(), new Elephant2(), new Snake2()]; // 明示的に型指定

// Contextual Type -----------------------------------------------------------------------------------------------------
// TypeScriptは他にも"文脈に基づく型付け"と呼ばれる推論も行いますが、これは型推論が行われる場所に基づいて行われます。
// これは右辺がWindow.onmousedownに代入可能な関数であることに基づいて、mouseEvent引数の型が自動的に推論されるためです。
window.onmousedown = function(mouseEvent) {
    console.log(mouseEvent.buton);  //<- エラー。正しくは 'button'
};

// 明示的に型が指定されている場合には、文脈に基づく型付けは行われません。
window.onmousedown = function(mouseEvent: any) {
    console.log(mouseEvent.buton);  //<- エラーにならなくなる
};

// 文脈に基づく型付けは、最適な共通型の候補にもなります。
// 以下の例では最適な共通型として、Animal、Rhino、Elephant、Snakeの中からAnimalが選択されます。
function createZoo3(): Animal[] {
    return [new Rhino3(), new Elephant3(), new Snake3()];
}


