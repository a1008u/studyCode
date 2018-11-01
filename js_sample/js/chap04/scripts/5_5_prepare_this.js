// // 
// function func() {
//   console.log(this.data);
// }

const arrowFunc = () => {
  console.log(this.data);
};


// console.log(this);

// const f = {
//   data: 'within object',
//   execute: func
// };

// f.execute();
// // => 'within object'



const af = {
  data: 'this is within object',
  execute: arrowFunc
};
var data = ' ====== this is within global ====== ';
af.execute();
// => 'this is within global'