// Json
let member = {
  mid: 'Y0001',
  name: '山田太郎',
  address: 't_yamada@example.com'
};

// 関数1
function show({name}) {
  console.log(name);
};
show(member);

// 関数2
function show2(name) {
  console.log(name);
};
show2(member);