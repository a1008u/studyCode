function hoge() {
  var args = Array.prototype.slice.call(arguments);
  console.log(args.join('／'));
}

hoge('Angular', 'React', 'Backbone');
