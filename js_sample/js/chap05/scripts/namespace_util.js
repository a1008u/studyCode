function namespace(ns) {
  var names = ns.split('.');
  var parent = window;

  for (var i = 0, len = names.length; i < len; i++) {
    parent[names[i]] = parent[names[i]] || {};
    parent = parent[names[i]];
  }
  return parent;
}

var my = namespace('Wings.Gihyo.Js.MyApp');
my.Person = function() {};
var p = new my.Person();
console.log(p instanceof Wings.Gihyo.Js.MyApp.Person);