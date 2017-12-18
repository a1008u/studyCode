// type StirngOrNumber = string | number
// function addWithArias(args: StirngOrNumber, args2: StirngOrNumber) {
//     return args.toString() + args2.toString()
// }
//
// console.log(addWithArias(1, 2))
//
//
//
// let nameObj = { name : "nameObj"};
// let idObj = { id : 2};
//
// let obj3 = { ...nameObj, ...idObj };
// console.log(`obj3.id : ${obj3.id}`);
// console.log(`obj3.name : ${obj3.name}`)
//
// interface IOptionalProp {
//     id: number;
//     name?: string;
// }
//
// let idOnly : IOptionalProp = { id: 1 };
// let idAndName : IOptionalProp = { id: 2, name : "idAndName" };

enum PersonCategory {
    Infant,
    Child,
    Adult
}

interface IPerson {
    Category: PersonCategory
    canSignContracts(): boolean
    printDetails()
}

abstract class Person implements IPerson {
    Category: PersonCategory
    private DateOfBirth: Date

    constructor(dateOfBirth: Date) {this.DateOfBirth = dateOfBirth}

    abstract canSignContracts(): boolean

    printDetails() : void {
        console.log(`Person : `);
        console.log(`Date of Birth : ` + `${this.DateOfBirth.toDateString()}`);
        console.log(`Category : `      + `${PersonCategory[this.Category]}`);
        console.log(`Can sign : `      + `${this.canSignContracts()}`);
    }
}

class Infant extends Person  {
    constructor(dateOfBirth: Date) {super(dateOfBirth);
        this.Category = PersonCategory.Infant;}
    canSignContracts(): boolean { return false; }
}

class Child extends Person  {
    constructor(dateOfBirth: Date) {super(dateOfBirth);
        this.Category = PersonCategory.Child;}
    canSignContracts(): boolean { return false; }
}

class Adult extends Person  {
    constructor(dateOfBirth: Date) {super(dateOfBirth);
        this.Category = PersonCategory.Adult;}
    canSignContracts(): boolean { return true; }
}

class PersonFactory {
    getPerson(dateOfBirth: Date) : IPerson {
        let dateNow = new Date(); // defaults to now.
        let currentMonth = dateNow.getMonth() + 1;
        let currentDate = dateNow.getDate();

        let dateTwoYearsAgo = new Date(dateNow.getFullYear() - 2, currentMonth, currentDate);

        let date18YearsAgo = new Date(dateNow.getFullYear() - 18, currentMonth, currentDate);

        if (dateOfBirth >= dateTwoYearsAgo) {return new Infant(dateOfBirth);}
        if (dateOfBirth >= date18YearsAgo) {return new Child(dateOfBirth);}
        return new Adult(dateOfBirth);
    }
}

let factory = new PersonFactory();
let p1 = factory.getPerson(new Date(2015, 0, 20));
p1.printDetails();
/* ------------------------------------
Person :
Date of Birth : Tue Jan 20 2015
Category : Child
Can sign : false
------------------------------------ */

let p2 = factory.getPerson(new Date(2000, 0, 20));
p2.printDetails();
/* ------------------------------------
Person :
Date of Birth : Thu Jan 20 2000
Category : Child
Can sign : false
------------------------------------ */

let p3 = factory.getPerson(new Date(1969, 0, 20));
p3.printDetails();
/* ------------------------------------
Person :
Date of Birth : Mon Jan 20 1969
Category : Adult
Can sign : true
------------------------------------ */

/** Decorator---------------------------------------------------- */

function simpleDecorator(constructor : Function) {
    console.log('simpleDecorator called1.');
}

@simpleDecorator
class ClassWithSimpleDecorator {

}

let instance_1 = new ClassWithSimpleDecorator()
let instance_2 = new ClassWithSimpleDecorator()

console.log(`instance_1: ${instance_1}`)
console.log(`instance_2 : ${instance_2}`)

function secondDecorator(constructor : Function) {
    console.log('secondDecorator called2.')
}

@simpleDecorator
@secondDecorator
class ClassWithMultipleDecorators {

}
/* ------------------------------------
simpleDecorator called.
instance_1: [object Object]
instance_2 : [object Object]
------------------------------------ */

/** Decorator Factory---------------------------------------------------- */

function decoratorFactory(name: string) {
    return function (constructor : Function ) {
        console.log(`decorator function called with : ${name}`);
    }
}

@decoratorFactory('testName')
class ClassWithDecoratorFactory {

}
/* ------------------------------------
decorator function called with : testName
------------------------------------ */

function classConstructorDec(constructor: Function) {
    console.log(`constructor : ${constructor}`);
}

@classConstructorDec
class ClassWithConstructor {

}

/* ------------------------------------
constructor : function t(){}
------------------------------------ */

function classConstructorDec2(constructor: Function) {
    console.log(`constructor : ${constructor}`);
    console.log(`constructor.name : ${(<any>constructor).name}`);
    constructor.prototype.testProperty = "testProperty_value" // inject
}

@classConstructorDec2
class ClassWithConstructor {

}

let classConstrInstance = new ClassWithConstructor();
console.log(`classConstrInstance.testProperty : ` + `${(<any>classConstrInstance).testProperty}`)

/* ------------------------------------
constructor : function t(){}
constructor.name : t
classConstrInstance.testProperty : testProperty_value
------------------------------------ */

/** Property Decorator ---------------------------------------------------- */

function propertyDec(target: any, propertyKey : string) {
    console.log(`target : ${target}`);
    console.log(`target.constructor : ${target.constructor}`);
    console.log(`class name : ` + `${target.constructor.name}`);
    console.log(`propertyKey : ${propertyKey}`);
}

class ClassWithPropertyDec {
    @propertyDec
    name: string;
}
/* ------------------------------------
target : [object Object] // object property
target.constructor : function t(){}
class name : t
propertyKey : name
------------------------------------ */

/** Static Property Decorator ---------------------------------------------------- */
class StaticClassWithPropertyDec {
    @propertyDec
    static name: string;
}
/* ------------------------------------
target : function t(){} // constructor function
target.constructor : function Function() { [native code] }
class name : Function
propertyKey : name
------------------------------------ */

function propertyDec(target: any, propertyKey : string) {
    if(typeof(target) === 'function') {
        console.log(`class name : ${target.name}`);
    } else {
        console.log(`class name : ${target.constructor.name}`);
    }

    console.log(`propertyKey : ${propertyKey}`);
}

class ClassWithPropertyDec{
    @propertyDec
    name: string;
}
/* ------------------------------------
class name : t
propertyKey : name
------------------------------------ */
class StaticClassWithPropertyDec {
    @propertyDec
    static name: string;
}
/* ------------------------------------
class name : t
propertyKey : name
------------------------------------ */

/** Promises ---------------------------------------------------- */
// callback
function delayedResponseWithCallback(callback: Function) {
    function delayedAfterTimeout() {
        console.log(`delayedAfterTimeout`);
        callback();
    }
    setTimeout(delayedAfterTimeout, 1000);
}

function callDelayedAndWait() {
    function afterWait() {console.log(`afterWait`);}
    console.log(`calling delayedResponseWithCallback`);
    delayedResponseWithCallback(afterWait);
    console.log(`after calling delayedResponseWithCallback`);
}

callDelayedAndWait();
/* ------------------------------------
calling delayedResponseWithCallback
after calling delayedResponseWithCallback
delayedAfterTimeout <--- Asynchronous
afterWait  <--- Asynchronous
------------------------------------ */


/** Creating new objects within generics ---------------------------------------------------- */
class FirstClass {
    id: number
}

class SecondClass {
    name: string
}

class GenericCreator< T > {
    create(arg1: { new(): T }) : T {return new arg1()}
}

let creator1 = new GenericCreator<FirstClass>();
let firstClass: FirstClass = creator1.create(FirstClass);

let creator2 = new GenericCreator<SecondClass>();
let secondClass : SecondClass = creator2.create(SecondClass);

/** Using Promises ---------------------------------------------------- */
function delayedPromise() : Promise<void> {
    return new Promise<void>(
        ( resolve : () => void, reject: () => void) => { function afterTimeout() {resolve()}
            setTimeout( afterTimeout, 1000);}
    );
}

function errorPromise() : Promise<void> {
    return new Promise<void>(
        (resolve: () => void, reject: () => void) => {reject();}
    );
}

function callErrorPromise() {
    console.log(`calling errorPromise`);
    errorPromise().then(() => { console.log(`no error.`) }).catch(
        () => { console.log(`an error occurred`)}
    );
}

function callDelayedPromise() {
    console.log(`calling delayedPromise`);
    delayedPromise().then(() => { console.log(`delayedPromise.then()`) })
}

callDelayedPromise();
callErrorPromise();
/* ------------------------------------
calling delayedPromise
calling errorPromise
an error occurred
delayedPromise.then()
------------------------------------ */

/** Returning values from Promises ---------------------------------------------------- */
function delayedPromiseWithParam() : Promise<string> {
    return new Promise<string>(
        (resolve: (str: string) => void, reject: (str:string ) => void) => {function afterWait() {resolve("resolved_within_promise")}
            setTimeout( afterWait , 2000 )}
    )
}

function callPromiseWithParam() {
    console.log(`calling delayedPromiseWithParam`);
    delayedPromiseWithParam().then( (message: string) => {console.log(`Promise.then() returned ${message} `)})
}

callPromiseWithParam();
/* ------------------------------------
calling delayedPromiseWithParam
Promise.then() returned resolved_within_promise
------------------------------------ */

interface IPromiseMessage {
    message: string;
    id: number;
}

function promiseWithInterface() : Promise<IPromiseMessage> {
    return new Promise<IPromiseMessage> (
        (resolve: (message: IPromiseMessage) => void, reject: (message: IPromiseMessage) => void)  => {resolve({message: "test", id: 1})}
    );
}

/** Async and await ---------------------------------------------------- */
function awaitDelayed() : Promise<void> {
    return new Promise<void> (
        ( resolve: () => void, reject: () => void )
            => { function afterWait() { console.log(`calling resolve`)
                                        resolve()
                                      }
            setTimeout(afterWait, 1000)
        }
    )
}

async function callAwaitDelayed() {
    console.log(`call awaitDelayed1`);
    await awaitDelayed();
    console.log(`after awaitDelayed2`);
}

callAwaitDelayed();

/* ------------------------------------
call awaitDelayed1
after awaitDelayed2
------------------------------------ */

// Await errors
function awaitError() : Promise<string> {
    return new Promise<string> (
        ( resolve: (message: string) => void, reject: (error: string) => void )
            => { function afterWait() { console.log(`calling reject`)
                                        reject("an error occurred")
                                      }
            setTimeout(afterWait, 1000)
        }
    )
}

async function callAwaitError() {
    console.log(`call awaitError`)

    try {
        await awaitError()
    } catch (error) {
        console.log(`error returned : ${error}`)
    }

    console.log(`after awaitDelayed`)
}

callAwaitError()
/* ------------------------------------
call awaitError
calling reject
error returned : an error occurred
after awaitDelayed
------------------------------------ */

// Await messages
function asyncWithMessage() : Promise<string> {
    return new Promise<string> (
        ( resolve: (message: string ) => void, reject: (message: string) => void)
            => { function afterWait() { resolve("resolve_message") }
            setTimeout(afterWait, 1000)
        }
    )
}

async function awaitMessage() {
    console.log(`calling asyncWithMessage`)
    let message: string = await asyncWithMessage()
    console.log(`message returned: ${message}`)
}

awaitMessage();
/* ------------------------------------
calling asyncWithMessage
message returned: resolve_message
------------------------------------ */













