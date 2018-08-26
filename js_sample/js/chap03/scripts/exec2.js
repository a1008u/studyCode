var p = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/gi;
var str = 'サポートサイトはhttp://www.wings.msn.to/です。';
str += 'サンプル紹介サイトHTTP://www.web-deli.com/もよろしく！'
while((result = p.exec(str)) !== null) {
  console.log(result[0]);
}
