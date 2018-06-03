type Foo = { a: number; b: string; c: string[] };

function getProperty<T, K extends keyof T>(obj: T, key: K) {
  return obj[key];
}

export class IndexAndIndexedAccessTypes {
  dotest(): void {
    let foo: Foo = { a: 1, b: 'test', c: ['ttt', 'ssss'] };
    let a = getProperty(foo, 'a');
    console.log(a);

  }
}

// declare let foo: Foo;
// declare let key: keyof Foo;
// type FooKey = keyof Foo;
// type FooA = Foo[a];
// type FooProp = Foo[keyof Foo];
