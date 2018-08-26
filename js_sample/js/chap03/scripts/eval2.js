var obj = { hoge: 1, foo: 2 };
var prop = 'hoge';
eval('console.log(obj.'+ prop + ')');

// console.log(obj[prop]);

/*
eval('var data = { "hoge": 1, "foo": 2 }');
console.log(data.hoge);
*/