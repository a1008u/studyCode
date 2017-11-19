/** ----------------------------------------------
 Classes
 ---------------------------------------------- */
// Classes -------------------------------------------------------------------------------------------------------------
class Greeter {
    // メンバ
    greeting: string
    constructor(message: string) {this.greeting = message}
    greet() {return "Hello, " + this.greeting}
}

let greeter = new Greeter("world")
console.log(greeter.greet()) // Hello, world

// Inheritance ---------------------------------------------------------------------------------------------------------
// サブクラスのコンストラクタでは、親クラスのコンストラクタを呼び出すためにsuper()メソッドを必ず呼ぶ必要があります。
class Animalx {
    name: string
    constructor(theName: string) { this.name = theName}
    move(distanceInMeters: number = 0) {console.log(`${this.name} moved ${distanceInMeters}m.`)}
}

class Snake extends Animalx {
    constructor(name: string) { super(name) }
    move(distanceInMeters = 5) {
        console.log("Slithering...")
        super.move(distanceInMeters)
    }
}

class Horse extends Animalx {
    constructor(name: string) { super(name) }
    move(distanceInMeters = 45) {
        console.log("Galloping...")
        super.move(distanceInMeters)
    }
}
/*
Slithering...
Sammy the Python moved 5m.
*/
let sam = new Snake("Sammy the Python")
sam.move()

/*
Galloping...
Tommy the Palomino moved 34m.
*/
let tom: Animalx = new Horse("Tommy the Palomino")
tom.move(34)

// Public, private, and protected modifiers ----------------------------------------------------------------------------
// Public by default 明示的にも記載可能
class Animal4 {
    public name: string
    public constructor(theName: string) { this.name = theName }
    public move1(distanceInMeters: number) {console.log(`${this.name} moved ${distanceInMeters}m.`)}
}

// Understanding private -----------------------------------------------------------------------------------------------
class Animal2 {
    private name: string;
    constructor(theName: string) { this.name = theName; }
}
// new Animal("Cat").name error

class Animal3 {
    private name: string
    constructor(theName: string) { this.name = theName }
}

class Rhino extends Animal3 {
    constructor() { super("Rhino") }
}

class Employee {
    private name: string
    constructor(theName: string) { this.name = theName }
}

let animal = new Animal3("Goat")
let rhino = new Rhino()
let employee = new Employee("Bob")

animal = rhino; // OK。'Animal' と 'Rhino' の 'name' プロパティは両方とも 'Animal' クラスで宣言されている
console.log(animal);
// animal = employee; エラー。'Employee' の 'name' プロパティは 'Animal' クラスで宣言されたものではない


// Understanding protected ---------------------------------------------------------------------------------------------
// protectedは、宣言したクラスとそのサブクラスからのみアクセスできる。
class Person2 {
    protected name: string
    protected constructor(name: string) { this.name = name }
}

class Employee2 extends Person2 {
    private department: string

    constructor(name: string, department: string) {
        super(name)
        this.department = department
    }

    public getElevatorPitch() {
        // ここからは 'name' にアクセスできる
        return `Hello, my name is ${this.name} and I work in ${this.department}.`
    }
}

let howard = new Employee2("Howard", "Sales")
console.log(howard.getElevatorPitch())
// console.log(howard.name); エラー。ここからは 'name' にアクセスできない
// let john = new Person("John"); エラー。'Person'クラスのコンストラクタはprotected

// Readonly modifier ---------------------------------------------------------------------------------------------------
// readonly キーワードをつけることでプロパティを読み取り専用
class Octopus {
    readonly name: string
    readonly numberOfLegs: number = 8
    constructor (theName: string) {this.name = theName}
}
let dad = new Octopus("Man with the 8 strong legs")
// dad.name = "Man with the 3-piece suit" エラー。'name' は読み取り専用

// Parameter properties ------------------------------------------------------------------------------------------------
// パラメータプロパティを使用することで一度に宣言と初期化を行う
// コンストラクタの引数にアクセス修飾子 (private、protected、public) や readonly を付与
class Octopus2 {
    readonly numberOfLegs: number = 8
    constructor(readonly name: string) {}
}

// Accessors -----------------------------------------------------------------------------------------------------------
// accessorなし
class Employee3 {fullName: string}
let employee3 = new Employee3()
employee3.fullName = "Bob Smith"
if (employee3.fullName) {console.log(employee3.fullName)} // Bob Smith

// パッキングフィールド
let passcode = "secret passcode"
class Employee4 {
    private _fullName: string
        get fullName(): string {return this._fullName}

        set fullName(newName: string) {
            if (passcode && passcode == "secret passcode") {this._fullName = newName}
            else {　console.log("Error: Unauthorized update of employee!")　}
        }
}

let employee4 = new Employee4()
employee4.fullName = "Bob Smith"
if (employee4.fullName) {console.log(employee4.fullName)} // Bob Smith

// Static Properties ---------------------------------------------------------------------------------------------------
// static キーワードを使用することで静的メンバを宣言することが可能です。
// 静的メンバにアクセスする場合にはクラス名を前に付ける必要がある点に注意してください。
class Grid {
    static origin = {x: 0, y: 0}
    calculateDistanceFromOrigin(point: {x: number; y: number;}) {
        let xDist = (point.x - Grid.origin.x)
        let yDist = (point.y - Grid.origin.y)
        return Math.sqrt(xDist * xDist + yDist * yDist) / this.scale
    }
    constructor (public scale: number) { }
}

let grid1 = new Grid(1.0);  // 1x scale
let grid2 = new Grid(5.0);  // 5x scale

console.log(grid1.calculateDistanceFromOrigin({x: 10, y: 10})) // 14.142135623730951
console.log(grid2.calculateDistanceFromOrigin({x: 10, y: 10})) // 2.8284271247461903

// Abstract Classes ----------------------------------------------------------------------------------------------------
abstract class Department {
    constructor(public name: string) {}
    printName(): void {console.log("Department name: " + this.name)}
    abstract printMeeting(): void; // サブクラスで必ず実装する必要がある
}

class AccountingDepartment extends Department {
    // サブクラスのコンストラクタでは必ず 'super()' メソッドを呼ぶ必要がある
    constructor() {super("Accounting and Auditing")}
    printMeeting(): void {console.log("The Accounting Department meets each Monday at 10am.")}
    generateReports(): void {console.log("Generating accounting reports...")}
}

let department: Department // 抽象クラスの変数を宣言することは可能
// department = new Department() error 抽象クラスをインスタンス化することはできない
department = new AccountingDepartment() // 抽象クラスでないサブクラスをインスタンス化し、代入することは可能
department.printName() // Department name: Accounting and Auditing
department.printMeeting() // The Accounting Department meets each Monday at 10am.
// department.generateReports() エラー。抽象クラスで宣言されていないメンバにはアクセスできない

// Advanced Techniques =================================================================================================
// Constructor functions -----------------------------------------------------------------------------------------------
// TypeScrpitでクラスを宣言する方法① new演算子
class Greeter2 {
    greeting: string
    constructor(message: string) {this.greeting = message}
    greet() {return "Hello, " + this.greeting}
}

let greeter2: Greeter2
greeter2 = new Greeter("world")
console.log(greeter2.greet()) // Hello, world

// TypeScrpitでクラスを宣言する方法② コンストラクタ関数（コンストラクタにはすべての静的メンバが含まれています。）
let Greeter3 = (function () {
    function Greeter(message) {this.greeting = message}
    Greeter.prototype.greet = function () {return "Hello, " + this.greeting}
    return Greeter
})()

let greeter3
greeter3 = new Greeter3("world")
console.log(greeter.greet()) // Hello, world

// Greeter3の書き換え
class Greeter4 {
    static standardGreeting = "Hello, there";
    greeting: string;
    greet() {
        if (this.greeting) {return "Hello, " + this.greeting}
        else {return Greeter4.standardGreeting}
    }
}

let greeter4: Greeter4;
greeter4 = new Greeter4();
console.log(greeter4.greet()); // "Hello, there"

let greeterMaker: typeof Greeter4 = Greeter4;
greeterMaker.standardGreeting = "Hey there!";

let greeter5: Greeter4 = new greeterMaker();
console.log(greeter5.greet()); // "Hey there!"

// Using a class as an interface ---------------------------------------------------------------------------------------
// クラスをインタフェースとして使用することもできます。
class Point {
    x: number
    y: number
}

interface Point3d extends Point { // クラスを使ってインタフェースを拡張している!
    z: number
}

let point3d: Point3d = {x: 1, y: 2, z: 3}
console.log(point3d); // { x: 1, y: 2, z: 3 }











