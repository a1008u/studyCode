// http://127.0.0.1:8887/chap03/13_2.sort_clazz.html

// 0-部長 1-課長 2-主任 3-担当
var classes = ['部長', '課長', '主任', '担当'];
var members = [
  { name: '鈴木清子', clazz: '主任' },
  { name: '山口久雄', clazz: '部長' },
  { name: '井上太郎', clazz: '担当' },
  { name: '和田知美', clazz: '課長' },
  { name: '小森雄太', clazz: '担当' },
];

console.log(members.sort(function(x, y) {
  return classes.indexOf(x.clazz) - classes.indexOf(y.clazz);
}))

console.log(members.sort((x, y) => {
  return classes.indexOf(x.clazz) - classes.indexOf(y.clazz);
}))