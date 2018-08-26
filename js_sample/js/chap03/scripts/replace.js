var p = /(http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?)/gi;
var str = 'サポートサイトはhttp://www.wings.msn.to/です。';
document.write(str.replace(p, '<a href="$1">$1</a>'));
