/** ---------------------------------------------------
 * Enums
---------------------------------------------------- */
/*
Enumは0個以上のメンバを持ち、各メンバには数値が割り当てられます。
この時に割当可能な値は[定数]または[計算された値]のいずれかです。
 */
enum Direction {
    Up = 1,
    Down,
    Left,
    Right
}

/*
enumのメンバは以下の場合に定数とみなされます。
それ以外の場合はすべて[計算された値]としてみなされます。

【メンバに初期値が指定されておらず、かつ、前のメンバが定数である。】
    この場合、前のメンバの値 + 1 がこのメンバの値となります。
    ただし、最初のメンバで初期値が指定されていない場合は0になります。
【初期値として定数enum式が指定されている。】
    定数enum式とはコンパイル時に評価可能な定数式のことで、以下のいずれかになります。
        数値定数
        定義済みの enum の値 (他の enum の値でも可)。
            同じ enum 内のメンバであれば enum 名を指定せずに参照可。
        括弧で囲まれた定数 enum 式
        単項演算子 (+、 -、 ~) が指定された定数 enum 式
        二項演算子 (+、 -、 *、 /、 %、 <<、 >>、 >>>、 &、 |、 ^) を含む定数 enum 式。
        ＊ただし、評価の結果が NaN または Infinity になる場合はコンパイルエラーになります。
*/
enum FileAccess {
    // 定数
    None,
    Read    = 1 << 1,
    Write   = 1 << 2,
    ReadWrite  = Read | Write,
    // 計算された値
    G = "123".length
}

// enumの値からenum名に逆変換できるようにする
enum Enum {
    A
}
let Ea = Enum.A;
let nameOfA = Enum[Ea];
console.log(nameOfA);// "A"

// 定数enumは通常のenumと異なり、宣言はコンパイル時に削除され、メンバの値がインライン化されます。
// 定数enumを宣言するにはenumキーワードの前にconst修飾子を付けます。
const enum Enum2 {
    A = 1,
    B = A * 2
}
const enum Directions {
    Up,
    Down,
    Left,
    Right
}
let directions = [Directions.Up, Directions.Down, Directions.Left, Directions.Right]
console.log(directions); // [ 0, 1, 2, 3 ]


// Ambient enums -------------------------------------------------------------------------------------------------------
// 通常のenumとの違いは、初期値が指定されていないメンバが通常のenumでは定数とみなされるのに対し、計算された値としてみなされる点です。
declare enum Enum {
    A3 = 1,
    B3,
    C3 = 2
}

console.log(Enum.A3, Enum.B3); // undefined undefined














