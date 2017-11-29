
function getBirthday () {
    let year:HTMLInputElement = <HTMLInputElement>document.getElementById("year").value;
    let month:HTMLInputElement = <HTMLInputElement>document.getElementById("month").value;
    let day:HTMLInputElement = <HTMLInputElement>document.getElementById("day").value;

    return new Date(+year, +month - 1, day);
}

function getDateDiff(previous, latest) {
    let diff = latest.getTime() - previous.getTime();
    
    let days = Math.floor(diff / (1000 * 60 * 60 * 24));
    diff -=  days * (1000 * 60 * 60 * 24);
    let hours = Math.floor(diff / (1000 * 60 * 60));
    diff -= hours * (1000 * 60 * 60);
    let mins = Math.floor(diff / (1000 * 60));
    diff -= mins * (1000 * 60);
    let seconds = Math.floor(diff / (1000));
    diff -= seconds * (1000);

    return {days:days, hours:hours, mins:mins, seconds:seconds};
}

let calculateBirthday = function () {
    let now = new Date();
    let birth = getBirthday();

    let diff = getDateDiff(birth, now);
    let message = "あなたが生まれてから" + diff.days + "日になりました";

    let result = document.getElementById("result");
    result.textContent = message;
    result.style.display = "";
}


// 実行


let check = document.getElementById("check");
check.addEventListener("click", calculateBirthday,false)

import {ZipCodeValidatorX} from "./main";
let myValidator7 = new ZipCodeValidatorX();
console.log(myValidator7.isAcceptable("12345")) // true
console.log('chanchan');