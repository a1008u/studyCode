function getTriangle({ base = 1, height = 1 }) {
  return base * height / 2;
}
const value = getTriangle({ base:5, height:4 });
console.log(value);

const value2 = getTriangle({});
console.log(value2);

// {プロパティ名 = デフォルト値, ... }