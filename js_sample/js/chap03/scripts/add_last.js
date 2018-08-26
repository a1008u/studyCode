// http://127.0.0.1:8887/chap03/16_3.add_last.html

var dat = new Date(2017, 4, 15, 11, 40);
console.log(dat.toLocaleString()); // 結果：2017/5/15 11:40:00 

// 来月の0日目は当月の最終日
dat.setMonth(dat.getMonth() + 1);
dat.setDate(0);
console.log(dat.toLocaleString()); // 結果：2017/5/31 11:40:00