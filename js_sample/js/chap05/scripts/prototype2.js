var Member = function() { };

Member.prototype.sex = '男';
var mem1 = new Member();
var mem2 = new Member();

console.log(mem1.sex + '|' + mem2.sex);
mem2.sex = '女';
console.log(mem1.sex + '|' + mem2.sex);
