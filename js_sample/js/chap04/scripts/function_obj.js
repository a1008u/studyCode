var getTriangle = new Function('base', 'height', 'return base * height / 2;');
//var getTriangle = Function('base', 'height', 'return base * height / 2;');
//var getTriangle = new Function('base, height', 'return base * height / 2;');
console.log('三角形の面積：' + getTriangle(5, 2));
