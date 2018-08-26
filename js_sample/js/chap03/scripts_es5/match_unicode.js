// http://127.0.0.1:8887/chap03/17_3.match_unicode.html
'use strict';

var str = '𠮟ります';
console.log(str.match(/^(?:[\0-\t\x0B\f\x0E-\u2027\u202A-\uD7FF\uE000-\uFFFF]|[\uD800-\uDBFF][\uDC00-\uDFFF]|[\uD800-\uDBFF](?![\uDC00-\uDFFF])|(?:[^\uD800-\uDBFF]|^)[\uDC00-\uDFFF])\u308A\u307E\u3059$/g));
