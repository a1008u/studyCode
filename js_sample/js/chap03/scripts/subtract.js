// http://127.0.0.1:8887/chap03/16_4.subtract.html

// 経過ms / (1000ms * 60s * 60m * 24h) = 日数
var dat1 = new Date(2017, 4, 15); // 2017/05/15
var dat2 = new Date(2017, 5, 20); // 2017/06/20
var diff = (dat2.getTime() - dat1.getTime()) / (1000 * 60 * 60 * 24);
console.log(`${diff}日の差があります。`); //36
