// http://127.0.0.1:8887/chap02/35.if_nest.html

var x = 30;
if (x >= 10) {
  if (x >= 20) {
    console.log('変数xは20以上です。');
  } else {
    console.log('変数xは10以上20未満です。');
  }
} else {
  console.log('変数xは10未満です。');
}

if (x <= 10) {
  console.log('変数xは10未満です。');
} else {
  if (x >= 20) {
    console.log('変数xは20以上です。');
  } else {
    console.log('変数xは10以上20未満です。');
  }
}
