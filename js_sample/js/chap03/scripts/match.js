// http://127.0.0.1:8887/chap03/17_1.match.html

var p = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/gi;
//var p = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/i;
//var p = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/g;
var str = 'サポートサイトはhttp://www.wings.msn.to/です。';
str += 'サンプル紹介サイトHTTP://www.web-deli.com/もよろしく！';
var result = str.match(p);

for (var i = 0, len = result.length; i < len; i++) {
  console.log(result[i]);
}

result.forEach(r => {
  console.log(r);
})