(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
function getBirthday() {
    let year = document.getElementById("year").value;
    let month = document.getElementById("month").value;
    let day = document.getElementById("day").value;
    return new Date(+year, +month - 1, day);
}
function getDateDiff(previous, latest) {
    let diff = latest.getTime() - previous.getTime();
    let days = Math.floor(diff / (1000 * 60 * 60 * 24));
    diff -= days * (1000 * 60 * 60 * 24);
    let hours = Math.floor(diff / (1000 * 60 * 60));
    diff -= hours * (1000 * 60 * 60);
    let mins = Math.floor(diff / (1000 * 60));
    diff -= mins * (1000 * 60);
    let seconds = Math.floor(diff / (1000));
    diff -= seconds * (1000);
    return { days: days, hours: hours, mins: mins, seconds: seconds };
}
let calculateBirthday = function () {
    let now = new Date();
    let birth = getBirthday();
    let diff = getDateDiff(birth, now);
    let message = "あなたが生まれてから" + diff.days + "日になりました";
    let result = document.getElementById("result");
    result.textContent = message;
    result.style.display = "";
};
// 実行
let check = document.getElementById("check");
check.addEventListener("click", calculateBirthday, false);
const main_1 = require("./main");
let myValidator7 = new main_1.ZipCodeValidatorX();
console.log(myValidator7.isAcceptable("12345")); // true
console.log('chanchan');

},{"./main":3}],2:[function(require,module,exports){
"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.numberRegexp = /^[0-9]+$/;

},{}],3:[function(require,module,exports){
"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const cons_1 = require("./cons");
class ZipCodeValidatorX {
    isAcceptable(s) {
        return s.length === 5 && cons_1.numberRegexp.test(s);
    }
}
exports.ZipCodeValidatorX = ZipCodeValidatorX;
let myValidator7 = new ZipCodeValidatorX();
console.log(myValidator7.isAcceptable("12345")); // true
console.log('chanchan');

},{"./cons":2}]},{},[1])

//# sourceMappingURL=all.js.map
