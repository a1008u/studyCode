// http://127.0.0.1:8887/chap02/20.dest_obj.html
'use strict';

var book = { title: 'Javaポケットリファレンス '
            , publish: '技術評論社'
            , price: 2680 };
var price = book.price;
var title = book['title'];
var _book$memo = book.memo;
var memo = _book$memo === undefined ? 'なし' : _book$memo;

let [xprice, xtitle, xmemo='なし'] = book;
console.log(`titleは${title} xtitleは${xtitle}`);
console.log(`priceは${price} xpriceは${xprice}`);
console.log(`memoは${memo} xmemoは${xmemo}`);


