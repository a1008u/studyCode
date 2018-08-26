var Member = function(firstName, lastName) {
  this.firstName = firstName;
  this.lastName = lastName;
};

var mem = new Member('祥寛', '山田');

mem.getName = function() {
  return this.lastName + ' ' + this.firstName;
}

console.log(mem.getName());
