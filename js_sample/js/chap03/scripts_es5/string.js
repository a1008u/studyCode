// http://127.0.0.1:8887/chap03/3_1.string.html

/**
 * 組み込みオブジェクト String
 */
'use strict';
var str1 = 'にわにはにわにわとりがいる';
console.log(`str1 ${str1}`);
console.log(`str1.indexOf('にわ') ${str1.indexOf('にわ')}`);
console.log(`str1.lastIndexOf('にわ') ${str1.lastIndexOf('にわ')}`);
console.log(`str1.indexOf('にわ', 3) ${str1.indexOf('にわ', 3)}`);
console.log(`str1.lastIndexOf('わ', 5) ${str1.lastIndexOf('わ', 5)}`);
console.log(`str1.indexOf('ガーデン') ${str1.indexOf('ガーデン')}`);
console.log(`str1.startsWith('にわ') ${str1.startsWith('にわ')}`);
console.log(`str1.endsWith('にわ') ${str1.endsWith('にわ')}`);
console.log(`str1.includes('にわ') ${str1.includes('にわ')}`);
console.log(`str1.split('わ', 3) ${str1.split('わ', 3)}`);

var str2 = 'Wingsプロジェクト';
console.log(`str2 ${str2}`);
console.log(`str2.charAt(4) ${str2.charAt(4)}`);
console.log(`str2.slice(5, 8) ${str2.slice(5, 8)}`); // 文字列の第1引数+1〜end文字列を抽出
console.log(`str2.substring(5, 8) ${str2.substring(5, 8)}`); // 文字列の第1引数+1〜end文字列を抽出
console.log(`str2.substr(5, 3) ${str2.substr(5, 3)}`); // 文字列の第1引数+1文字目から第2引数分の文字列を抽出
console.log(`str2.split('s') ${str2.split('s')}`);
console.log(`str2.charCodeAt(0) ${str2.charCodeAt(0)}`);
console.log(`str2.concat(' 有限会社') ${str2.concat(' 有限会社')}`);
console.log(`str2.repeat(2) ${str2.repeat(2)}`);
console.log(`str2.length ${str2.length}`);

var str3 = '𠮟られて';
console.log(`str3 ${str3}`);
console.log(`str3.codePointAt(0)) ${str3.codePointAt(0)}`);

var str4 = '   wings   ';
console.log(`str4 ${str4}`);
console.log(`str4.trim() ${str4.trim()}`);

console.log(`String.fromCharCode(87, 105, 110, 103) ${String.fromCharCode(87, 105, 110, 103)}`);
console.log(`String.fromCodePoint(134047) ${String.fromCodePoint(134047)}`);