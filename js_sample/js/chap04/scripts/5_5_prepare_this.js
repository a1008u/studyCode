var data = ' ====== this is within global ====== ';
function func() {
  console.log(this.data);
}

const arrowFunc = () => {
  console.log(this.data);
};


console.log(this);

const f = {
  data: 'within object',
  execute: func
};
f.execute();
// => 'within object'



const af = {
  data: 'this is within object',
  execute: tt.arrowFunc
};
af.execute();
// => 'this is within global'