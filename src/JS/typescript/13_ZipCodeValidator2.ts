let numberRegexp = /^[0-9]+$/;
class ZipCodeValidatorY {
    isAcceptable(s: string) {
        return s.length === 5 && numberRegexp.test(s);
    }
}
export = ZipCodeValidatorY;

