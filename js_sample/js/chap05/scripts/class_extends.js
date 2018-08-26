class Member {
  constructor(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  getName() {
    return this.lastName + this.firstName;
  }
}

class BusinessMember extends Member {
  work() {
    return this.getName() + 'は働いています。';
  }
}

let bm = new BusinessMember('太郎', '山田');
console.log(bm.getName());
console.log(bm.work());
