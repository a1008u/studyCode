import Person from './person';

class Friend extends Person {
  constructor(name) {
    super(name);
  }

  callName() {
    alert(this.name);
  }
}

const friend = new Friend('Ryo');

friend.callName();
