import person from "../src/js/person";

describe("demoTest", function() {
    it("testメソッドの確認", function() {
        let p = new person('Ryo');
        let result = p.test(2);
        expect(4).toEqual(result);
    })
});
