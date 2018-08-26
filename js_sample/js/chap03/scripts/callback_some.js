// http://127.0.0.1:8887/chap03/12-3.callback_some.html

var data = [4, 9, 16, 25];
var result = data.some(function(value, index, array) {
  return value % 3 === 0;
});
if (result) {
  console.log('3の倍数が見つかりました。');
} else {
  console.log('3の倍数は見つかりませんでした。');
}

// アロー
var result2 = data.some((value, index, array) =>  {
  return value % 3 === 0;
});
if (result２) {
  console.log('アロー：3の倍数が見つかりました。');
} else {
  console.log('アロー：3の倍数は見つかりませんでした。');
}