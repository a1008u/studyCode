let data = { red: '赤色', yellow: '黄色' };
var proxy = new Proxy(data, {
  get(target, prop) {
    return prop in target ? target[prop] : '?';
  }
});

console.log(proxy.red);
console.log(proxy.nothing);

proxy.red = 'レッド';
console.log(data.red);
console.log(proxy.red);
