
import {numberRegexp} from "./cons";

interface StringValidator {isAcceptable(s:any): boolean}

export class ZipCodeValidatorX implements StringValidator {
    isAcceptable(s: string) {
        return s.length === 5 && numberRegexp.test(s);
    }
}

let myValidator7 = new ZipCodeValidatorX();
console.log(myValidator7.isAcceptable("12345")) // true
console.log('chanchan');