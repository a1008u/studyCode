const SECRET_VALUE = Symbol();

export default class  {
  constructor(secret) {
    
    this.hoge = 'hoge';
    this.foo  = 'foo';
    this[SECRET_VALUE] = secret;
  }

  checkValue(secret) {
    return this[SECRET_VALUE] === secret;
  }
}
