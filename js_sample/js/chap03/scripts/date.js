// http://127.0.0.1:8887/chap03/16_1.date.html

var dat = new Date(2016, 11, 25, 11, 37, 15, 999);
console.log(dat); // 結果：Sun Dec 25 2016 11:37:15 GMT+0900
console.log(dat.getFullYear());  // 結果：2016
console.log(dat.getMonth()); // 結果：11
console.log(dat.getDate()); // 結果：25
console.log(dat.getDay()); // 結果：0
console.log(dat.getHours()); // 結果：11
console.log(dat.getMinutes()); // 結果：37
console.log(dat.getSeconds()); // 結果：15
console.log(dat.getMilliseconds()); // 結果：999
console.log(dat.getTime()); // 結果：1482633435999
console.log(dat.getTimezoneOffset()); // 結果：-540

console.log(dat.getUTCFullYear());  // 結果：2016
console.log(dat.getUTCMonth()); // 結果：11
console.log(dat.getUTCDate()); // 結果：25
console.log(dat.getUTCDay()); // 結果：0
console.log(dat.getUTCHours()); // 結果：2
console.log(dat.getUTCMinutes()); // 結果：37
console.log(dat.getUTCSeconds()); // 結果：15
console.log(dat.getUTCMilliseconds()); // 結果：999

var dat2 = new Date();
dat2.setFullYear(2017);
dat2.setMonth(7);
dat2.setDate(5);
dat2.setHours(11);
dat2.setMinutes(37);
dat2.setSeconds(15);
dat2.setMilliseconds(513);

console.log(dat2.toLocaleString()); // 結果：2017/8/5 11:37:15
console.log(dat2.toUTCString()); // 結果：Sat, 05 Aug 2017 02:37:15 GMT
console.log(dat2.toDateString()); // 結果：Sat Aug 05 2017 
console.log(dat2.toTimeString()); // 結果：11:37:15 GMT+0900
console.log(dat2.toLocaleDateString()); // 結果：2017/8/5 
console.log(dat2.toLocaleTimeString()); // 結果：11:37:15
console.log(dat2.toJSON()); // 2017-08-05T02:37:15.513Z

console.log(Date.parse('2016/11/05')); // 結果：1478271600000
console.log(Date.UTC(2016, 11, 5)); // 結果：1480896000000
console.log(Date.now()); // 結果：1465971930329
