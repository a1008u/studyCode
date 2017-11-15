/** ----------------------------------------------------------------------
 Functions
---------------------------------------------------------------------- */
// 名前付き関数
function add(x, y) {return x + y}
console.log(add(3, 5)) // 8

// 無名関数
let myAdd = function(x, y) { return x+y }
console.log(myAdd(3, 5)) // 8

// キャプチャ
let z = 100
function addToZ(x, y) {return x + y + z}
console.log(addToZ(3, 5)) // 108

// Function Types ======================================================================================================
// Typing the function  ------------------------------------------------------------------------------------------------
// 関数の引数や戻り値の型を指定することができます。
// この時、TypeScriptはretur 文から戻り値の型を推測するため、大抵の場合で戻り値の型を省略することができます。
function add2(x: number, y: number): number {return x + y}
console.log(add2(3, 5)) // 8

let myAdd2 = function(x: number, y: number): number { return x+y }
console.log(myAdd2(3, 5)) // 8

// Writing the function type  ------------------------------------------------------------------------------------------
// (x: number, y: number) => number の部分が関数の型
// 関数の型では戻り値の型も必須なため、戻り値を持たない関数の場合には戻り値の型として void を使用します。
let myAdd3: (x: number, y: number) => number = function(x: number, y: number): number { return x+y }
console.log(myAdd3(3, 5)) // 8
let myAdd4: (baseValue:number, increment:number) => number = function(x: number, y: number): number { return x + y }
console.log(myAdd4(3, 5)) // 8

// Inferring the types  ------------------------------------------------------------------------------------------------
// 文脈に基づく型付け: 代入元/先のどちらからで型が省略された場合でも、TypeScript は型推論を行ってくれます。
// myAdd は関数の型として推論される
let myAdd5 = function(x: number, y: number): number { return  x + y }
console.log(myAdd5(3, 5)) // 8

// 引数 'x'、'y' は数値型として推論される
let myAdd6: (baseValue:number, increment:number) => number = function(x, y) { return x + y }
console.log(myAdd6(3, 5)) // 8

// Optional and Default Parameters -------------------------------------------------------------------------------------
// TypeScriptでは、デフォルトですべての引数が必須として扱われるため、関数を呼び出す際はすべての引数を指定する必要があります。
function buildName(firstName: string, lastName: string) { return firstName + " " + lastName }

// let result1 = buildName("Bob")                  エラー。引数が少ない
// let result2 = buildName("Bob", "Adams", "Sr.")  エラー。引数が多い
let result3 = buildName("Bob", "Adams") // OK
console.log(result3) // Bob Adams

// JavaScript ではすべての引数が任意であり、指定しなかった引数はundefinedになっていましたが、
// これをTypeScriptで実現するには引数名の後ろに ? を付与します。
// ただし、任意の引数は必須の引数よりも 後ろ に配置する必要がある点に注意してください。
function buildName2(firstName: string, lastName?: string) {
    if (lastName)  return firstName + " " + lastName
    else return firstName
}

let result2_1 = buildName2("Bob")                 // 今回は OK
console.log(result2_1) // ç
let result2_4 = buildName2("Bob", "Adams")        // OK
console.log(result2_4) // Bob Adams
// let result2_2 = buildName2("Bob", "Adams", "Sr.")  // エラー。引数が多い

function buildName3(firstName: string, lastName = "Smith") {return firstName + " " + lastName}
let result3_1 = buildName3("Bob")                  // 今はOK。戻り値は "Bob Smith"
let result3_2 = buildName3("Bob", undefined)       // これも動作する。戻り値は "Bob Smith"
let result3_4 = buildName3("Bob", "Adams")         // OK。戻り値は "Bob Adams"
// let result3_3 = buildName3("Bob", "Adams", "Sr.")   エラー。引数が多い

function buildName4(firstName = "Will", lastName: string) {return firstName + " " + lastName}

// let result4_1 = buildName4("Bob")                  // エラー。引数が少ない
// let result4_2 = buildName4("Bob", "Adams", "Sr.")  // エラー。引数が多い
let result4_3 = buildName4("Bob", "Adams")         // OK。戻り値は "Bob Adams"
let result4_4 = buildName4(undefined, "Adams")     // OK。戻り値は "Will Adams"

// Rest Parameters -----------------------------------------------------------------------------------------------------
// 複数の引数をまとめて受け取りたい場合や引数の数が不定の場合には、
// JavaScriptではarguments変数を直接使用していましたが、
// TypeScriptでは引数名の前に省略記号 (...) を付与することで、配列としてまとめて引数を受け取ることができます。
function buildName5(firstName: string, ...restOfName: string[]) {return firstName + " " + restOfName.join(" ")}
let employeeName = buildName5("Joseph", "Samuel", "Lucas", "MacKinzie")
console.log(employeeName) // Joseph Samuel Lucas MacKinzie

function buildName6(firstName: string, ...restOfName: string[]) {return firstName + " " + restOfName.join(" ")}
let buildNameFun: (fname: string, ...rest: string[]) => string = buildName6
console.log(buildNameFun("aaaa", "bbbb")) // aaaa bbbbbbb

// this ================================================================================================================
// this and arrow functions --------------------------------------------------------------------------------------------
let deck2 = {
    suits: ["hearts", "spades", "clubs", "diamonds"],
    cards: Array(52),
    createCardPicker: function() {
        // アロー関数を用いることで 'this'をキャプチャする
        return () => {
            let pickedCard = Math.floor(Math.random() * 52);
            let pickedSuit = Math.floor(pickedCard / 13);

            return {suit: this.suits[pickedSuit], card: pickedCard % 13};
        }
    }
}

let cardPicker2 = deck2.createCardPicker()
let pickedCard2 = cardPicker2()
console.log("card: " + pickedCard2.card + " of " + pickedCard2.suit) // card: 9 of hearts

/* アローを利用しない
let deck3 = {
    suits: ["hearts", "spades", "clubs", "diamonds"],
    cards: Array(52),
    createCardPicker: function() {
        return function() {
            let pickedCard = Math.floor(Math.random() * 52)
            let pickedSuit = Math.floor(pickedCard / 13)

            return {suit: this.suits[pickedSuit], card: pickedCard % 13}
        }
    }
}

let cardPicker3 = deck3.createCardPicker()
let pickedCard3 = cardPicker3()
console.log("card: " + pickedCard3.card + " of " + pickedCard3.suit)
*/

// this parameters -----------------------------------------------------------------------------------------------------
// 前述の例ではオブジェクトリテラル内で関数式を使用したため、this.suits[pickedSuit] の型が any になってしまっていました。
// これを修正するには明示的に this 引数を渡す必要があります。
// this 引数はダミーの引数であり、引数リストの最初に指定する必要があります。
interface Card {
    suit: string
    card: number
}
interface Deck {
    suits: string[]
    cards: number[]
    createCardPicker(this: Deck): () => Card
}

let deck4: Deck = {
    suits: ["hearts", "spades", "clubs", "diamonds"],
    cards: Array(52),
    // この関数の呼び出し先が Deck であることを明示的に指定する
    createCardPicker: function(this: Deck) {
        return () => {
            let pickedCard = Math.floor(Math.random() * 52)
            let pickedSuit = Math.floor(pickedCard / 13)

            return {suit: this.suits[pickedSuit], card: pickedCard % 13}
        }
    }
}

let cardPicker = deck4.createCardPicker()
let pickedCard = cardPicker()
console.log("card: " + pickedCard.card + " of " + pickedCard.suit) // card: 6 of diamonds

// this parameters in callbacks ----------------------------------------------------------------------------------------
// this: void と宣言することで、コールバック関数で this を使用しない
interface UIElement {addClickListener(onclick: (this: void, e: Event) => void): void}
/*
class Handler {
    info: string;
    onClickBad(this: Handler, e: Event) {
        // おっと、ここで this を使おうとしている
        this.info = e.message;
    };
}
let h = new Handler();
uiElement.addClickListener(h.onClickBad);  エコンパイルエラー

// 解決策
class Handler2 {
    info: string;
    // this の型が void なので、this を使用することはできない!
    onClickGood(this: void, e: Event) {console.log('clicked!')}
}
let h2 = new Handler2();
uiElement.addClickListener(h2.onClickGood)

// コールバック関数でのthisの利用
class Handler3 {
    info: string;
    onClickGood = (e: Event) => { this.info = e.message }
}
*/

// Overloads -----------------------------------------------------------------------------------------------------------
// オーバーロードは宣言された順番に、指定された引数にマッチするものがないか検索されるため、より限定的なものから順に宣言することが一般的です。
let suits = ["hearts", "spades", "clubs", "diamonds"];

function pickCard(x: {suit: string; card: number; }[]): number;
function pickCard(x: number): {suit: string; card: number; };
function pickCard(x): any {
    // 引数が object または array の場合、
    // デッキが渡されたとみなしてその中からカードを引く
    if (typeof x == "object") {
        let pickedCard = Math.floor(Math.random() * x.length);
        return pickedCard; // 戻り値はデッキ内のインデックス
    }
    // それ以外の場合、指定されたカードを引く
    else if (typeof x == "number") {
        let pickedSuit = Math.floor(x / 13);
        return { suit: suits[pickedSuit], card: x % 13 }; // 戻り値は引いたカード (object)
    }
}

let myDeck = [{ suit: "diamonds", card: 2 }, { suit: "spades", card: 10 }, { suit: "hearts", card: 4 }];
let pickedCard1 = myDeck[pickCard(myDeck)];
console.log("card: " + pickedCard1.card + " of " + pickedCard1.suit) // card: 4 of hearts

let pickedCard4 = pickCard(15);
console.log("card: " + pickedCard4.card + " of " + pickedCard4.suit) // card: 2 of spades














