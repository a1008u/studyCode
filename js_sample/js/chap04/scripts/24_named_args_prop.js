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

function show2({mid, name}) {
  console.log(`mid === ${mid}  name === ${name}`);
};
show2(member);

// 関数2
function show3(name) {
  console.log(name);
};
show3(member);